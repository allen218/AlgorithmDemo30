package com.allen.testalgorithm

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testRecursion() {
        println(cinema(5))
        println(cinemaTraverse(5))
    }

    @Test
    fun testTraverse() {
        println(stairTraverse(3))
    }

    var depth: Int = 0
    fun cinema(n: Int): Int {
        depth++
        if (depth >= 1000) {
            throw RuntimeException("over max depth.")
        }

        if (n == 1) {
            return 1
        }
        return cinema(n - 1) + 1
    }

    val map = mutableMapOf<Int, Int>()
    fun optimizedRercusion(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        if (map.containsKey(n)) {
            return map[n]!!
        }

        val ret = optimizedRercusion(n - 1) + optimizedRercusion(n - 2)

        map.put(n, ret)
        return ret
    }

    fun cinemaTraverse(n: Int): Int {
        var ret = 1
        for (i in 2..n) {
            ret += 1
        }
        return ret
    }

    fun stairTraverse(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        var ret = 0
        var prepare = 1
        var pre = 2

        for (i in 3..n) {
            ret = pre + prepare
            prepare = pre
            pre = ret
        }
        return ret
    }
}
