package cz.cuni.mff.aspect.launch

import cz.cuni.mff.aspect.evolution.levels.pc.PCLevelGenerator
import cz.cuni.mff.aspect.evolution.results.Agents
import cz.cuni.mff.aspect.mario.GameSimulator
import cz.cuni.mff.aspect.mario.MarioAgent
import cz.cuni.mff.aspect.mario.controllers.MarioController
import cz.cuni.mff.aspect.mario.level.MarioLevel
import cz.cuni.mff.aspect.storage.LevelStorage
import cz.cuni.mff.aspect.storage.ObjectStorage

/** Launches Super Mario simulator using specified AI player and level generator. */
fun main() {
    aiPlayLevel()
//    neatAiPlayLevel()
}


private fun aiPlayLevel() {
//    val agent = Agents.NeuroEvolution.Stage4Level1Solver
    val agent = MarioAgent(ObjectStorage.load("data/coev/6_all_fitness_lg/neuro_pc/ai_20.ai") as MarioController)
    val levelGenerator = PCLevelGenerator()
//    val levelGenerator = ObjectStorage.load("data/coev/third_lg.lg") as LevelGenerator
//    val levelGenerator = LevelGenerators.StaticGenerator(TrainingLevelsSet)

    val gameSimulator = GameSimulator(1400)
    val stats = Array(10) { levelGenerator.generate() }.map {
        gameSimulator.playMario(agent, it, true)
    }
    println(stats.sumBy { if (it.levelFinished) 1 else 0 })
}


private fun neatAiPlayLevel() {
//    val agent = MarioAgent(controller)
    val agent = Agents.NEAT.Stage4Level1Solver

    val levels = listOf<MarioLevel>(LevelStorage.loadLevel("current.lvl"))
    val simulator = GameSimulator(1000)

    for (level in levels) {
        val stats = simulator.playMario(agent, level, true)
        println(stats.jumps)
    }


}
