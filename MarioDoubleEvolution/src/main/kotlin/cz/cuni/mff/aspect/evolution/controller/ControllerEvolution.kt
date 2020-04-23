package cz.cuni.mff.aspect.evolution.controller

import cz.cuni.mff.aspect.evolution.levels.LevelGenerator
import cz.cuni.mff.aspect.mario.controllers.MarioController


/**
 * Interface representing controller evolution.
 */
interface ControllerEvolution {

    /**
     * Evolves a mario agent controller, being provided with level generator.
     *
     * @return the evolved agent controller
     */
    fun evolve(
        levelGenerators: List<LevelGenerator>,
        fitness: MarioGameplayEvaluator<Float>,
        objective: MarioGameplayEvaluator<Float>
    ): MarioController

    /**
     * Continue evolution of already evolved controller.
     *
     * @return the evolved agent controller
     */
    fun continueEvolution(
        controller: MarioController,
        levelGenerators: List<LevelGenerator>,
        fitness: MarioGameplayEvaluator<Float>,
        objective: MarioGameplayEvaluator<Float>
    ): MarioController

}
