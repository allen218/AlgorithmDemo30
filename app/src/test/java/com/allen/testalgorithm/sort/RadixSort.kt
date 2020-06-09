package com.allen.testalgorithm.sort

import com.allen.testalgorithm.array.printArray
import org.junit.Test

/**
 * 描述: 基数排序（RadixSort），时间复杂度为 O(n).
 * 创建日期：2020/6/9 on 9:42
 */
class RadixSort {
    @Test
    fun test() {
        val arr = arrayOf(500, 2, 1000, 200, 13, 15, 3000, 500, 20)
        radixSort(arr)
        arr.printArray()
    }

    private fun radixSort(arr: Array<Int>) {
        var d = 0
        arr.forEach {
            val len = it.toString().length
            if (len > d) {
                d = len
            }
        }

        var n = 1
        var k = 0
        var m = 0
        val temp = Array(10) { Array(arr.size) { 0 } }
        val radixCount = Array(10) { 0 }
        while (m <= d) {
            for (i in arr.indices) {
                val index = arr[i] / n % 10
                temp[index][radixCount[index]] = arr[i]
                radixCount[index]++
            }

            for (i in 0 until 10) {
                if (radixCount[i] != 0) {
                    for (j in 0 until radixCount[i]) {
                        arr[k++] = temp[i][j]
                    }
                }
                radixCount[i] = 0
            }
            k = 0
            m++
            n *= 10
        }
    }
}