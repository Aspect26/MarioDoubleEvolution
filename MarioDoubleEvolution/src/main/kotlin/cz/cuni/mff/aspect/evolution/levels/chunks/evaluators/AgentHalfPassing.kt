package cz.cuni.mff.aspect.evolution.levels.chunks.evaluators

import cz.cuni.mff.aspect.evolution.levels.chunks.metadata.ChunksLevelMetadata
import cz.cuni.mff.aspect.mario.GameStatistics
import cz.cuni.mff.aspect.mario.level.MarioLevel
import io.jenetics.Optimize
import kotlin.math.abs

class AgentHalfPassing : PCLevelEvaluator<Float> {

    override fun invoke(
        levels: List<MarioLevel>,
        levelsChunkMetadata: List<ChunksLevelMetadata>,
        gameStatistics: List<GameStatistics>
    ): Float {
        val wonCount = gameStatistics.sumBy { if (it.levelFinished) 1 else 0 }
        val lostCount = gameStatistics.size - wonCount

        val maxDifference = gameStatistics.size
        val wonLostDifference = abs(wonCount - lostCount) * 1000
        val reversedWonLostDifference = maxDifference - wonLostDifference

        return reversedWonLostDifference.toFloat()
    }

    override val optimize: Optimize get() = Optimize.MAXIMUM

}