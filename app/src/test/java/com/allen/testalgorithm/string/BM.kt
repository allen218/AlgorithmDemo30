package com.allen.testalgorithm.string

import org.junit.Test


/**
 * Description: To match Strings using BM Algorithm.
 */
class BM {
    private val SIZE = 256

    @Test
    fun test() {
        val arr = "aaabaaabaaaa".toCharArray()
        val subArr = "aaaa".toCharArray()
        println(bm(arr, subArr, arr.size, subArr.size))
    }

    fun bm(arr: CharArray, b: CharArray, n: Int, m: Int): Int {
        val bc = Array(SIZE) { -1 }
        generateBC(bc, b, m)
        val suffix = IntArray(m) { -1 }
        val prefix = BooleanArray(m) { false }
        generateSP(suffix, prefix, b, m)

        var i = 0
        while (i <= n - m) {
            var j = m - 1
            while (j >= 0) {
                if (arr[i + j] != b[j]) {
                    break
                }
                j--
            }
            if (j < 0) {
                return i
            }

            val x = j - bc[i + j]
            var y = 0
            if (j < m - 1) {
                y = moveBySP(suffix, prefix, m, j)
            }
            i += Math.max(x, y)
        }

        return -1
    }

    private fun moveBySP(
        suffix: IntArray,
        prefix: BooleanArray,
        m: Int,
        j: Int
    ): Int {
        val k = m - 1 - j
        if (suffix[k] != -1) {
            return j - suffix[k] + 1
        }
        for (r in j + 2 until m) {
            if (prefix[m - r]) {
                return r
            }
        }
        return m
    }

    private fun generateSP(
        suffix: IntArray,
        prefix: BooleanArray,
        b: CharArray,
        m: Int
    ) {
        for (i in 0 until m - 1) {
            var j = i
            var k = 0
            while (j >= 0 && b[j] == b[m - 1 - k]) {
                j--
                k++
                suffix[k] = i
            }

            if (j == -1) {
                prefix[k] = true
            }
        }
    }

    private fun generateBC(bc: Array<Int>, b: CharArray, m: Int) {
        for (i in 0 until m) {
            val ascii = b[i].toInt()
            bc[ascii] = i
        }
    }
}
