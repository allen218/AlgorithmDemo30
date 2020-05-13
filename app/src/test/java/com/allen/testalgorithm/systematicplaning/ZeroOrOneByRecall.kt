package com.allen.testalgorithm.systematicplaning

import org.junit.Test

/**
 * To solve the problem of 0 or 1 bag by recalling method.
 */
class ZeroOrOneByRecall {
    @Test
    fun test() {
        val weight = arrayOf(2, 9, 3, 6, 11, 5)
        f(0, weight, 0, weight.size, 10)
        println(maxWeight)
    }

    private var maxWeight = Integer.MIN_VALUE
    fun f(i: Int, weight: Array<Int>, cw: Int, n: Int, w: Int) {
        if (cw == w || i == n) {
            if (cw > maxWeight) {
                maxWeight = cw
            }
            return
        }

        f(i + 1, weight, cw, n, w)
        if (cw + weight[i] <= w) {
            f(i + 1, weight, cw + weight[i], n, w)
        }
    }
}