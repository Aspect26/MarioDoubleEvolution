package cz.cuni.mff.aspect.evolution.controller

import cz.cuni.mff.aspect.evolution.levels.LevelGenerator
import cz.cuni.mff.aspect.mario.controllers.MarioController
import cz.cuni.mff.aspect.visualisation.charts.EvolutionLineChart


/** Interface representing controller evolution. */
interface ControllerEvolution {

    /** Chart of the evolution. */
    val chart: EvolutionLineChart

    /** Evolves a mario agent controller, which will be evaluated using level generators given. */
    fun evolve(levelGenerators: List<LevelGenerator>): MarioController

    /** Continues evolution of already evolved controller, using given level generators for its evaluation. */
    fun continueEvolution(controller: MarioController, levelGenerators: List<LevelGenerator>): MarioController

}
