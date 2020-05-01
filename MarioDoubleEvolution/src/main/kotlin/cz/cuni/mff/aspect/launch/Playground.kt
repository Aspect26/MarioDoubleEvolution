package cz.cuni.mff.aspect.launch

import cz.cuni.mff.aspect.visualisation.charts.CoevolutionLineChart
import cz.cuni.mff.aspect.visualisation.charts.EvolutionLineChart

fun main() {
    val chart1 = EvolutionLineChart(label="TEST1")
    val chart2 = EvolutionLineChart(label="TEST2")

    chart1.nextGeneration(1.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.addStop()

    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.addStop()

    chart1.nextGeneration(2.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.addStop()

    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.addStop()

    chart1.nextGeneration(3.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 2.0)
    chart1.addStop()

    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.addStop()

    chart1.nextGeneration(4.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.addStop()

    chart2.nextGeneration(3.0, 0.0, 0.0, 1.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 2.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 3.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 4.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 5.0)
    chart2.addStop()

    chart1.nextGeneration(5.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.addStop()

    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.addStop()

    chart1.nextGeneration(6.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.addStop()

    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.addStop()

    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.nextGeneration(7.0, 0.0, 0.0, 0.0)
    chart1.addStop()

    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.nextGeneration(3.0, 0.0, 0.0, 0.0)
    chart2.addStop()

    val coevolutionLineChart = CoevolutionLineChart(chart1, chart2, "Coevolution chart")
    coevolutionLineChart.show()
}
