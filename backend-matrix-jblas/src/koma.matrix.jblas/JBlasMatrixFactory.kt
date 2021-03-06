package koma.matrix.jblas

import koma.*
import koma.matrix.common.*
import koma.matrix.jblas.backend.*
import org.jblas.DoubleMatrix

class JBlasMatrixFactory : DoubleFactoryBase<JBlasMatrix>() {
    override fun zeros(rows: Int, cols: Int) = JBlasMatrix(koma.matrix.jblas.backend.zeros(rows, cols))
    @Deprecated(DEPRECATE_IMPLICIT_2D, ReplaceWith("zeros(size, size)"))
    override fun zeros(size: Int) = JBlasMatrix(koma.matrix.jblas.backend.zeros(size, size))
    override fun create(data: IntRange) = JBlasMatrix(DoubleMatrix(data.map { it.toDouble() }))
    override fun create(data: DoubleArray) = JBlasMatrix(DoubleMatrix(data))
    override fun create(data: Array<DoubleArray>) = JBlasMatrix(DoubleMatrix(data))
    @Deprecated(DEPRECATE_IMPLICIT_2D, ReplaceWith("ones(size, size)"))
    override fun ones(size: Int) = JBlasMatrix(DoubleMatrix(size, size).mapMat { 1.0 })
    override fun ones(rows: Int, cols: Int) = JBlasMatrix(DoubleMatrix(rows, cols).mapMat { 1.0 })
    override fun eye(size: Int) = JBlasMatrix(DoubleMatrix.eye(size))
    override fun eye(rows: Int, cols: Int): JBlasMatrix {
        val out = DoubleMatrix(rows, cols)
        for (i in 0..rows - 1)
            out[i, i] = 1.0
        return JBlasMatrix(out)
    }
}
