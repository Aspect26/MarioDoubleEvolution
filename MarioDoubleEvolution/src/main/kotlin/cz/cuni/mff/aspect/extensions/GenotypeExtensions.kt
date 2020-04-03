package cz.cuni.mff.aspect.extensions

import cz.cuni.mff.aspect.evolution.levels.ge.algorithm.jenetics.ByteGene
import io.jenetics.Genotype
import io.jenetics.IntegerGene
import io.jenetics.NumericGene
import io.jenetics.util.Seq


fun <G> Genotype<G>.getDoubleValues(): DoubleArray
        where G : NumericGene<*, G> {
    val geneSequence: Seq<G> = this.chromosome.toSeq()

    val array = DoubleArray(geneSequence.size())
    var i = geneSequence.size()
    while (--i >= 0) {
        array[i] = geneSequence[i].getAllele().toDouble()
    }
    return array
}

fun Genotype<IntegerGene>.getIntValues(): IntArray {
    val geneSequence: Seq<IntegerGene> = this.chromosome.toSeq()

    val array = IntArray(geneSequence.size())
    var i = geneSequence.size()
    while (--i >= 0) {
        array[i] = geneSequence[i].allele
    }
    return array
}

fun Genotype<ByteGene>.getByteValues(): ByteArray {
    val geneSequence: Seq<ByteGene> = this.chromosome.toSeq()

    val array = ByteArray(geneSequence.size())
    var i = geneSequence.size()
    while (--i >= 0) {
        array[i] = geneSequence[i].allele
    }
    return array
}
