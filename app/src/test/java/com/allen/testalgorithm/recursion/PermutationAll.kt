package com.allen.testalgorithm.recursion

import com.allen.testalgorithm.print
import org.junit.Test

/**
 * 3. 编程实现一组数据集合的全排列（PermutationAll）
 * Created by allen on 2020-02-10.
 */
class PermutationAll {
    private var sum: Int = 0

    fun permute(array: Array<Int>, length: Int, start: Int) {
        if (length == start) {
            array.print()
            println()
            sum++
        } else {
            for (i in start until length) {
                swap(array, start, i)
                permute(array, length, start + 1)
                swap(array, start, i)
            }
        }
    }

    private fun swap(array: Array<Int>, x: Int, y: Int) {
        val tmp = array[x]
        array[x] = array[y]
        array[y] = tmp
    }
}

class PermutationTest {
    @Test
    fun test() {
        val permutationAll = PermutationAll()
        val array = arrayOf(1, 2, 3)
        permutationAll.permute(array, array.size, 0)
    }
}