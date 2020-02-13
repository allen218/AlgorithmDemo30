package com.allen.testalgorithm.binarysearch

import org.junit.Test

/**
 * 1.
 * Created by allen on 2020-02-13.
 */
class BinarySearch {
    fun find(array: Array<Int>, k: Int): Int {
        var low = 0
        var high = array.size - 1
        while (low <= high) {
            var middle = low + (high - low) / 2
            when {
                array[middle] == k -> return middle
                array[middle] > k -> high = middle - 1
                else -> low = middle + 1
            }
        }
        return -1
    }
}

class BinarySearchTest {
    @Test
    fun test() {
        val binarySearch = BinarySearch()
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(binarySearch.find(array, 5))
    }
}