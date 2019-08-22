package cz.cuni.mff.aspect.mario

import ch.idsia.agents.AgentOptions
import ch.idsia.agents.IAgent
import ch.idsia.agents.controllers.MarioHijackAIBase
import ch.idsia.benchmark.mario.engine.input.MarioInput
import cz.cuni.mff.aspect.coevolution.agent.EvolutionaryAgent
import cz.cuni.mff.aspect.coevolution.agent.MarioAction
import java.util.*

class MarioAgent(private val _evolvedAgent: EvolutionaryAgent) : MarioHijackAIBase(), IAgent {

    override fun reset(options: AgentOptions) {
        super.reset(options)
    }

    override fun actionSelectionAI(): MarioInput {
        val actions = this._evolvedAgent.playAction(t, e)
        for (action in actions) {
            when (action) {
                MarioAction.RUN_RIGHT -> control.runRight()
                MarioAction.RUN_LEFT -> control.runLeft()
                MarioAction.JUMP -> control.jump()
                MarioAction.SPECIAL -> control.shoot() // TODO: check which type of mario we have...
            }
        }

        return action
    }

}