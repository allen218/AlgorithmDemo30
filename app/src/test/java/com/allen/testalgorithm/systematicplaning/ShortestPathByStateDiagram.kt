package com.allen.testalgorithm.systematicplaning

import org.junit.Test

/**
 * To solve the problem of the shortest path from a[0][0] to a[i][j] by state diagram method.
 */
class ShortestPathByStateDiagram {
    @Test
    fun test() {
        val matrixs = arrayOf(
            arrayOf(1, 3, 5, 9),
            arrayOf(2, 1, 3, 4),
            arrayOf(5, 2, 6, 7),
            arrayOf(6, 8, 4, 3)
        )
        println(f(matrixs, matrixs.size))
    }

    fun f(matrixs: Array<Array<Int>>, n: Int): Int {
        val states = Array(n) { Array(n) { 0 } }

        var sum = 0
        for (j in 0 until n) {
            sum += matrixs[0][j]
            matrixs[0][j] = sum
        }

        sum = 0
        for (i in 0 until n) {
            sum += matrixs[i][0]
            matrixs[i][0] = sum
        }

        for (i in 1 until n) {
            for (j in 1 until n) {
                states[i][j] = matrixs[i][j] + Math.min(states[i - 1][j], states[i][j - 1])
            }
        }

        return states[n - 1][n - 1]
    }
}