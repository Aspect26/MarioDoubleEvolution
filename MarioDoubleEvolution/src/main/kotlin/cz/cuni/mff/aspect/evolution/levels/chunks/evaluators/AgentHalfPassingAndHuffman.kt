package cz.cuni.mff.aspect.evolution.levels.chunks.evaluators

import cz.cuni.mff.aspect.evolution.levels.chunks.metadata.ChunksLevelMetadata
import cz.cuni.mff.aspect.evolution.levels.evaluators.compression.ImageHuffmanCompression
import cz.cuni.mff.aspect.mario.GameStatistics
import cz.cuni.mff.aspect.mario.level.MarioLevel
import cz.cuni.mff.aspect.visualisation.level.LevelToImageConverter
import io.jenetics.Optimize
import kotlin.math.abs

class AgentHalfPassingAndHuffman : PCLevelGeneratorEvaluatorBase() {

    override fun evaluate(
        levels: List<MarioLevel>,
        levelsChunkMetadata: List<ChunksLevelMetadata>,
        gameStatistics: List<GameStatistics>
    ): Float {
        val wonCount = gameStatistics.sumBy { if (it.levelFinished) 1 else 0 }
        val lostCount = gameStatistics.size - wonCount

        val maxDifference = gameStatistics.size / 2
        val wonLostDifference = abs(wonCount - lostCount)
        val reversedWonLostDifference = maxDifference - wonLostDifference

        val compressionSize = List(levels.size) {
            val image = LevelToImageConverter.createMinified(levels[it], noAlpha=true)
            ImageHuffmanCompression(2).getSize(image)
        }.sum()

        return reversedWonLostDifference.toFloat() * compressionSize
    }

    override val optimize: Optimize get() = Optimize.MAXIMUM

}