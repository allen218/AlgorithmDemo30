package com.allen.testalgorithm.sort

import org.junit.Test

/**
 * 2. 编程实现 O(n) 时间复杂度内找到一组数据的第 K 大元素（FindOutKth）
 * Created by allen on 2020-02-13.
 */
class FindOutKth {
    fun find(array: Array<Int>, k: Int) {
        if (k > array.size) {
            throw IndexOutOfBoundsException()
        }

        val kIndex = find(array, 0, array.size - 1, k)
        if (kIndex == -1) {
            print("application not working.")
            return
        }

        println("Kth value is : ${array[kIndex]}")
    }

    fun find(array: Array<Int>, start: Int, end: Int, k: Int): Int {
        var low = start
        var high = end
        while (low <= high) {
            val pivot = partition(array, low, high)
            when {
                pivot + 1 == k -> return pivot
                pivot + 1 < k -> low = pivot + 1
                else -> high = pivot - 1
            }
        }

        return -1
    }


    fun partition(array: Array<Int>, start: Int, end: Int): Int {
        var i = start
        var j = start
        var pivot = array[end]

        while (j < end) {
            if (array[j] > pivot) {
                val tmp = array[i]
                array[i] = array[j]
                array[j] = tmp
                i++
            }

            j++
        }

        val tmp = array[i]
        array[i] = array[end]
        array[end] = tmp

        return i
    }
}

class FindOutKthTest {
    @Test
    fun test() {
        val array = arrayOf(6, 9, 5, 3, 2, 7, 8, 4, 1)
        val findOutKth = FindOutKth()
        findOutKth.find(array, 5)
    }
}