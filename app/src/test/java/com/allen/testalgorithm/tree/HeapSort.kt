package com.allen.testalgorithm.tree

import org.junit.Test

/**
 * 描述:
 * 作者:王聪 001928
 * 创建日期：2020/4/29 on 9:40
 */
class HeapSort {
    fun heapSort(array: Array<Int>, n: Int) {
        // build heap
        buildHeap(array, n)

        var k = n - 1
        while (k > 0) {
            swap(array, 0, k)
            k--
            heapify(array, k, 0)
        }
    }

    private fun buildHeap(array: Array<Int>, n: Int) {
        for (i in ((n - 1) / 2) downTo 0) {
            heapify(array, n - 1, i)
        }
    }

    private fun heapify(array: Array<Int>, n: Int, i: Int) {
        var cur = i
        while (true) {
            var maxPos = cur
            if (cur * 2 + 1 <= n && array[cur] < array[cur * 2 + 1]) {
                maxPos = cur * 2 + 1
            }
            if (cur * 2 + 2 <= n && array[maxPos] < array[cur * 2 + 2]) {
                maxPos = cur * 2 + 2
            }
            if (cur == maxPos) {
                break
            }
            swap(array, cur, maxPos)
            cur = maxPos
        }
    }

    fun swap(array: Array<Int>, i: Int, j: Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
    }

    fun Array<Int>.print() {
        for (i in this.indices) {
            print("${this[i]},")
        }
    }

    @Test
    fun test() {
        val heapSort = HeapSort()
        val array = arrayOf(0, 5, 4, 3, 7, 9, 8, 1, 2)
        heapSort.heapSort(array, array.size)
        array.print()
    }
}