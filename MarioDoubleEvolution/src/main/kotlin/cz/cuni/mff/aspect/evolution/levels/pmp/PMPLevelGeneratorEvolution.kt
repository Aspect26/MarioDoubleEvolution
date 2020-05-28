package cz.cuni.mff.aspect.evolution.levels.pmp

import cz.cuni.mff.aspect.evolution.jenetics.alterers.UpdatedGaussianMutator
import cz.cuni.mff.aspect.evolution.jenetics.genotype.ZeroInitializingDoubleGenotypeFactory
import cz.cuni.mff.aspect.evolution.levels.JeneticsLevelGeneratorEvolution
import cz.cuni.mff.aspect.evolution.levels.pmp.evaluators.PMPLevelEvaluator
import cz.cuni.mff.aspect.evolution.levels.pmp.metadata.PMPLevelMetadata
import cz.cuni.mff.aspect.mario.GameSimulator
import cz.cuni.mff.aspect.mario.GameStatistics
import cz.cuni.mff.aspect.mario.level.MarioLevel
import cz.cuni.mff.aspect.utils.getDoubleValues
import cz.cuni.mff.aspect.visualisation.charts.evolution.EvolutionLineChart
import io.jenetics.*
import io.jenetics.util.DoubleRange
import io.jenetics.util.Factory

/**
 * Implementation of a Super Mario level generator evolution of [PMPLevelGenerator]. The implementation is highly
 * customizable in terms of multiple properties of the evolution, which can be specified via primary constructor.
 *
 * @param populationSize population size during the evolution.
 * @param generationsCount number of generations of the evolution.
 * @param fitnessFunction function computing fitness value of individuals.
 * @param objectiveFunction function computing objective value of individuals.
 * @param evaluateOnLevelsCount number specifying on how many levels, generated by a generator represented by some individual
 * the fitness and objective functions should be computed.
 * @param levelLength level lengths property of [PMPLevelGenerator].
 * @param chartLabel label of the evolution's chart.
 * @param displayChart specifies, whether the evolution's chart should be displayed in realtime.
 * @see EvolutionLineChart for more specifics about the chart.
 * @see PMPLevelGenerator for more info about the level generation process.
 */
class PMPLevelGeneratorEvolution(
    populationSize: Int,
    generationsCount: Int,
    private val fitnessFunction: PMPLevelEvaluator<Float>,
    private val objectiveFunction: PMPLevelEvaluator<Float>,
    alterers: Array<Alterer<DoubleGene, Float>> = arrayOf(UpdatedGaussianMutator(0.2, 0.1)),
    private val evaluateOnLevelsCount: Int = DEFAULT_EVALUATE_ON_LEVELS_COUNT,
    private val levelLength: Int = DEFAULT_LEVEL_LENGTH,
    chartLabel: String = DEFAULT_CHART_LABEL,
    displayChart: Boolean = true
) : JeneticsLevelGeneratorEvolution<PMPLevelGenerator>(
    populationSize,
    generationsCount,
    fitnessOptimization = fitnessFunction.optimize,
    objectiveOptimization = objectiveFunction.optimize,
    alterers = alterers,
    survivorsSelector = EliteSelector(2),
    offspringSelector = RouletteWheelSelector(),
    displayChart = displayChart,
    chartLabel = chartLabel
) {

    override fun createGenotypeFactory(): Factory<Genotype<DoubleGene>> =
        ZeroInitializingDoubleGenotypeFactory(PMPLevelGenerator.PROBABILITIES_COUNT, DoubleRange.of(0.0, 1.0))

    override fun entityFromIndividual(genotype: Genotype<DoubleGene>): PMPLevelGenerator =
        PMPLevelGenerator(genotype.getDoubleValues(), this.levelLength)

    override fun entityToIndividual(levelGenerator: PMPLevelGenerator): Genotype<DoubleGene> =
        Genotype.of(DoubleChromosome.of(levelGenerator.data.map { DoubleGene.of(it, 0.0, 1.0) }))

    override fun computeFitnessAndObjective(genotype: Genotype<DoubleGene>): Pair<Float, Float> {
        val levelGenerator = this.entityFromIndividual(genotype)

        val levels: MutableList<MarioLevel> = mutableListOf()
        val metadata: MutableList<PMPLevelMetadata> = mutableListOf()
        val gameStatistics: MutableList<GameStatistics> = mutableListOf()

        repeat(this.evaluateOnLevelsCount) {
            val agent = agentFactory()
            val level = levelGenerator.generate()
            val levelMetadata = levelGenerator.lastMetadata

            val marioSimulator = GameSimulator(2000)
            val currentGameStatistics = marioSimulator.playMario(agent, level, false)

            levels.add(level)
            metadata.add(levelMetadata)
            gameStatistics.add(currentGameStatistics)
        }

        return Pair(this.fitnessFunction(levels, metadata, gameStatistics), this.objectiveFunction(levels, metadata, gameStatistics))
    }

    companion object {
        private const val DEFAULT_LEVEL_LENGTH = 200
        private const val DEFAULT_EVALUATE_ON_LEVELS_COUNT: Int = 5
        private const val DEFAULT_CHART_LABEL = "PMP Level Generator Evolution"
    }

}
