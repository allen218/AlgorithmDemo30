package com.allen.testalgorithm.systematicplaning

import org.junit.Test

/**
 * To solve the problem of 0 or 1 bag by dynamic planing method with a dimensional array.
 */
class ZeroOrOneByDynamic2 {

    @Test
    fun test() {
        val items = arrayOf(5, 9, 8, 3, 4, 9, 5)
        f(items, items.size, 6)
    }

    fun f(item: Array<Int>, n: Int, w: Int) {
        val states = Array(w + 1) { false }
        states[0] = true
        if (item[0] <= w) {
            states[item[0]] = true
        }

        for (i in 1 until n) {
            for (j in w - item[i] downTo 0) {
                if (states[j]) {
                    states[j + item[i]] = true
                }
            }
        }

        for (i in w downTo 0) {
            if (states[i]) {
                println("max value is : $i")
                break
            }
        }
    }
}