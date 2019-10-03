package cz.cuni.mff.aspect.mario.controllers

import ch.idsia.agents.controllers.modules.Entities
import ch.idsia.agents.controllers.modules.Tiles
import ch.idsia.benchmark.mario.engine.generalization.MarioEntity


/**
 * Representation of [cz.cuni.mff.aspect.mario.MarioAgent]'s controller. The controller tells the agent which actions
 * to do each tick.
 */
interface MarioController {

    fun playAction(tiles: Tiles, entities: Entities, mario: MarioEntity): List<MarioAction>

}

enum class MarioAction {
    RUN_RIGHT,
    RUN_LEFT,
    JUMP,
    SPECIAL
}