package com.allen.testalgorithm.binarysearch

import org.junit.Test

/**
 * Created by allen on 2020-02-13.
 */
class BinarySearchVague {
    fun find(array: Array<Int>, k: Int): Int {
        var low = 0
        var high = array.size - 1

        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                array[mid] >= k -> {
                    if (mid == 0 || array[mid - 1] < k) {
                        return mid
                    }
                    high = mid - 1
                }
                else -> low = mid + 1
            }
        }

        return -1
    }
}

class BinarySearchVagueTest {
    @Test
    fun test() {
        val binarySearchVague = BinarySearchVague()
        val array = arrayOf(1, 7, 10, 18, 18, 18, 18, 19, 19, 20, 30)
        println(binarySearchVague.find(array, 18))
    }
}