package com.allen.testalgorithm.systematicplaning

import org.junit.Test

/**
 * To solve the problem of 0 or 1 bag by dynamic planing method with two dimensional array.
 */
class ZeroOrOneByDynamic {

    @Test
    fun test() {
        val items = arrayOf(5, 9, 8, 7, 6, 3, 4, 9, 5)
        f(items, items.size, 10)
    }

    fun f(item: Array<Int>, n: Int, w: Int) {
        val states = Array(n) { Array(w + 1) { false } }

        states[0][0] = true
        if (item[0] <= w) {
            states[0][item[0]] = true
        }

        for (i in 1 until n) {
            for (j in 1..w) {
                if (states[i - 1][j]) {
                    states[i][j] = true
                }
            }

            for (j in 1..w - item[i]) {
                if (states[i - 1][j]) {
                    states[i][j + item[i]] = true
                }
            }
        }

        for (j in w downTo 0) {
            if (states[n - 1][j]) {
                println("max value is : $j")
                break
            }
        }

    }
}