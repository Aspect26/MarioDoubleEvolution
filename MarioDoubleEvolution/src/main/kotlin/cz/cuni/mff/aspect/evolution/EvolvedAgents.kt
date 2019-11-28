package cz.cuni.mff.aspect.evolution

import ch.idsia.agents.IAgent
import cz.cuni.mff.aspect.RuleBasedAgent
import cz.cuni.mff.aspect.mario.MarioAgent
import cz.cuni.mff.aspect.mario.controllers.MarioController
import cz.cuni.mff.aspect.storage.ObjectStorage

object EvolvedAgents {

    val ruleBasedAgent: IAgent get() = RuleBasedAgent()

    val stage2Level1Solver: IAgent get() = MarioAgent(ObjectStorage.load("experiments/Gaussian test evaluation - S2S/NeuroEvolution, Mutator 0.45_ai.ai") as MarioController)
    val stage4Level1Solver: IAgent get() = MarioAgent(ObjectStorage.load("experiments/Gaussian test evaluation - S4S/NeuroEvolution, Mutator 0.45_ai.ai") as MarioController)

}