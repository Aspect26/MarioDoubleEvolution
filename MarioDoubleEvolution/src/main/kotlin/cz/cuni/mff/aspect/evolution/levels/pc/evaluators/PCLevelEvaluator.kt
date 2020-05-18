package cz.cuni.mff.aspect.evolution.levels.pc.evaluators

import cz.cuni.mff.aspect.evolution.levels.pc.metadata.ChunksLevelMetadata
import cz.cuni.mff.aspect.mario.GameStatistics
import cz.cuni.mff.aspect.mario.level.MarioLevel
import io.jenetics.Optimize

/** Interface for evaluators of levels generated by Probabilistic Chunk level generator. */
interface PCLevelEvaluator<F> {

    /**
     * Computes the evaluation and returns its value.
     * @param levels the generated levels.
     * @param levelsChunkMetadata metadata of the generated levels.
     * @param gameStatistics gameplay statistics of some agent playing the levels.
     */
    operator fun invoke(levels: List<MarioLevel>, levelsChunkMetadata: List<ChunksLevelMetadata>, gameStatistics: List<GameStatistics>): F

    /** Specifies whether this evaluator's value should be maximized or minimized. */
    val optimize: Optimize

}
