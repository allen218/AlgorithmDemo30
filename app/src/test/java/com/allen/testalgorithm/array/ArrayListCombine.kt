package com.allen.testalgorithm.array

import org.junit.Test

/**
 * 3. 实现两个有序数组合并成一个有序数组（ArrayListCombine）
 * Created by allen on 2020-02-05.
 */


class ArrayListCombine {
    fun combine(array1: Array<Int>, array2: Array<Int>): Array<Int> {
        if (!check(array1) || !check(array2)) {
            throw RuntimeException("at least one of arrays isn't ordered array.")
        }

        val size = array1.size + array2.size
        val newArray = Array(size) { 0 }
        var i = 0
        var j = 0
        var k = 0

        while (i < array1.size && j < array2.size) {
            if (array1[i] > array2[j]) {
                newArray[k++] = array2[j++]
            } else {
                newArray[k++] = array1[i++]
            }
        }

        if (i >= array1.size - 1) {
            for (x in j until array2.size) {
                newArray[k++] = array2[x]
            }
        } else {
            for (y in i until array1.size) {
                newArray[k++] = array1[y]
            }
        }
        return newArray
    }

    fun check(array: Array<Int>): Boolean {
        for (i in 0 until array.size - 1) {
            if (array[i] > array[i + 1]) {
                return false
            }
        }
        return true
    }
}

class ArrayListCombineTest {
    @Test
    fun test() {
        var arrCombine = ArrayListCombine()
        var arr1 = arrayOf(1, 2, 5, 18, 30, 41, 52, 63, 71, 88, 91)
        var arr2 = arrayOf(3, 8, 10, 22, 23, 55, 56, 78, 81, 92)
        arrCombine.combine(arr1, arr2).printArray()

    }
}


fun Array<Int>.printArray() {
    for (i in 0 until size) {
        print("${this[i]},")
    }
    println()
}