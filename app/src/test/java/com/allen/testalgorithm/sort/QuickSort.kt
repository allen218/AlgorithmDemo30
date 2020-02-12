package com.allen.testalgorithm.sort

import org.junit.Test

/**
 * 5. 快速排序（quickSort）
 * Created by allen on 2020-02-13.
 */
class QuickSort {
    fun sort(array: Array<Int>) {
        quickSort(array, 0, array.size - 1)
    }

    fun quickSort(array: Array<Int>, start: Int, end: Int) {
        if (start >= end) {
            return
        }

        val pivot = partition(array, start, end)
        quickSort(array, start, pivot - 1)
        quickSort(array, pivot + 1, end)
    }

    fun partition(array: Array<Int>, low: Int, high: Int): Int {
        val pivot = array[high]

        var i = low
        var j = low

        while (j <= high - 1) {
            if (array[j] < pivot) {
                val tmp = array[i]
                array[i] = array[j]
                array[j] = tmp
                i++
            }

            j++
        }

        val tmp = array[i]
        array[i] = array[high]
        array[high] = tmp
        return i
    }
}

class QuickSortTest {
    @Test
    fun test() {
        val quickSort = QuickSort()
        val array = arrayOf(9, 7, 1, 2, 5, 6, 5, 3, 8)
        quickSort.sort(array)
        array.print()
    }
}