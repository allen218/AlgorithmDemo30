package com.allen.testalgorithm.binarysearch

import com.allen.testalgorithm.array.printArray
import com.allen.testalgorithm.quickSort
import org.junit.Test

/**
 * Created by allen on 2020-02-13.
 */
class BinarySearchVague {

    fun binarySearch(arr: Array<Int>, key: Int): Int {
        var low = 0
        var high = arr.size - 1

        while (low <= high) {
            val middle = low + (high - low) / 2
            if (arr[middle] < key) {
                low = middle + 1
            } else if (arr[middle] > key) {
                high = middle - 1
            }

            return middle
        }
        return -1
    }

    fun binarySearchEqualsFirst(arr: Array<Int>, key: Int): Int {
        var low = 0
        var high = arr.size - 1

        while (low <= high) {
            val middle = low + (high - low) / 2
            if (arr[middle] < key) {
                low = middle + 1
            } else if (arr[middle] > key) {
                high = middle - 1
            } else {
                if (middle == 0 || arr[middle - 1] < key) {
                    return middle
                }
                high = middle - 1
            }
        }
        return -1
    }

    fun binarySearchEqualsLast(arr: Array<Int>, key: Int): Int {
        var low = 0
        var high = arr.size - 1

        while (low <= high) {
            val middle = low + (high - low) / 2
            if (arr[middle] < key) {
                low = middle + 1
            } else if (arr[middle] > key) {
                high = middle - 1
            } else {
                if (middle == arr.size - 1 || arr[middle + 1] > key) {
                    return middle
                }

                low = middle + 1
            }
        }
        return -1
    }

    fun binarySearchGtAndEqualsFirstKey(arr: Array<Int>, key: Int): Int {
        var low = 0
        var high = arr.size - 1

        while (low <= high) {
            val middle = low + (high - low) / 2
            if (arr[middle] < key) {
                low = middle + 1
            } else {
                if (middle == 0 || arr[middle - 1] < key) {
                    return middle
                }
                high = middle - 1
            }
        }
        return -1
    }

    fun binarySearchLtAndEqualsLastKey(arr: Array<Int>, key: Int): Int {
        var low = 0
        var high = arr.size - 1

        while (low <= high) {
            val middle = low + (high - low) / 2
            if (arr[middle] > key) {
                high = middle - 1
            } else {
                if (middle == arr.size - 1 || arr[middle + 1] > key) {
                    return middle
                }
                low = middle + 1
            }
        }
        return -1
    }
}

class BinarySearchVagueTest {
    @Test
    fun test() {
        val binarySearchVague = BinarySearchVague()
        val array = arrayOf(1, 9, 2, 8, 5, 7, 5, 4, 5, 3, 5)
        quickSort(array)
        println("The value is a index that equals 5 : ${binarySearchVague.binarySearch(array, 5)}")
        println(
            "The value is a index that equals 5 first: ${binarySearchVague.binarySearchEqualsFirst(
                array,
                5
            )}"
        )
        array.printArray()
        println(
            "The value is a index that equals 5 last: ${binarySearchVague.binarySearchEqualsLast(
                array,
                5
            )}"
        )
        println(
            "The value is a index that greater than or equals 6 first: ${binarySearchVague.binarySearchGtAndEqualsFirstKey(
                array,
                6
            )}"
        )
        println(
            "The value is a index that lesser than or equals 6 first: ${binarySearchVague.binarySearchLtAndEqualsLastKey(
                array,
                6
            )}"
        )
    }
}