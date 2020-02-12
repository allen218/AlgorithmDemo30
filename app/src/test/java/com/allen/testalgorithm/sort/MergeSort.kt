package com.allen.testalgorithm.sort

import org.junit.Test

/**
 * 4. 归并排序（MergeSort）
 * Created by allen on 2020-02-12.
 */
class MergeSort {
    fun sort(array: Array<Int>) {
        mergeSort(array, 0, array.size - 1)
    }

    fun mergeSort(array: Array<Int>, start: Int, end: Int) {
        if (start >= end) {
            return
        }

        val middle = (start + end) / 2
        mergeSort(array, start, middle)
        mergeSort(array, middle + 1, end)
        merge(array, start, middle, end)
    }

    fun merge(array: Array<Int>, start: Int, middle: Int, end: Int) {
        var low = start
        var high = middle + 1
        val tmp = Array(array.size) { 0 }
        var k = 0

        while (low <= middle && high <= end) {
            if (array[low] > array[high]) {
                tmp[k++] = array[high++]
            } else {
                tmp[k++] = array[low++]
            }
        }

        var i = low
        var j = middle
        if (high <= end) {
            i = high
            j = end
        }

        for (x in i..j) {
            tmp[k++] = array[x]
        }

        var y = 0
        for (i in start..end) {
            array[i] = tmp[y++]
        }
    }
}

class MergeSortTest {
    @Test
    fun test() {
        val mergeSort = MergeSort()
        val array = arrayOf(9, 7, 1, 2, 5, 6, 5, 3, 8)
        mergeSort.sort(array)
        array.print()
    }
}