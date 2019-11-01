package cz.cuni.mff.aspect.visualisation

import java.awt.Color

class EvolutionLineChart(label: String = "Evolution", private val hideFirst: Int = 0, private val hideNegative: Boolean = false) {

    private val lineChart = LineChart(label, "Generations", "Fitness")

    private val data: List<Triple<String, Color, MutableList<Pair<Double, Double>>>> = listOf(
        Triple("Max fitness", Color.BLUE, mutableListOf(Pair(0.0, 0.0))),
        Triple("Average fitness", Color.GREEN, mutableListOf(Pair(0.0, 0.0))),
        Triple("Min fitness", Color.RED, mutableListOf(Pair(0.0, 0.0)))
    )

    fun show() {
        this.lineChart.renderChart()
    }

    fun update(generation: Int, maxFitness: Double, averageFitness: Double, minFitness: Double) {
        this.data[0].third.add(Pair(generation.toDouble(), if (hideNegative) 0.0.coerceAtLeast(maxFitness) else maxFitness))
        this.data[1].third.add(Pair(generation.toDouble(), if (hideNegative) 0.0.coerceAtLeast(averageFitness) else averageFitness))
        this.data[2].third.add(Pair(generation.toDouble(), if (hideNegative) 0.0.coerceAtLeast(minFitness) else minFitness))

        if (this.hideFirst > 0 && this.data[0].third.size > this.hideFirst) {
            val offset = this.hideFirst.coerceAtMost(this.data[0].third.size - this.hideFirst)
            val shownData = this.data.map { lineData -> Triple(lineData.first, lineData.second, lineData.third.subList(offset, lineData.third.size)) }
            this.lineChart.updateChart(shownData)
        } else {
            this.lineChart.updateChart(this.data)
        }
    }

    fun save(path: String) {
        this.lineChart.save(path)
    }

}