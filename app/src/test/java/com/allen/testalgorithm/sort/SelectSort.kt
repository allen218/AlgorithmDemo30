package com.allen.testalgorithm.sort

import org.junit.Test

/**
 * 1. 选择排序（SelectSort）
 * Created by allen on 2020-02-11.
 */
class SelectSort {
    fun sort(array: Array<Int>) {
        for (i in 0 until array.size - 1) {
            for (j in i + 1 until array.size) {
                if (array[i] > array[j]) {
                    val tmp = array[i]
                    array[i] = array[j]
                    array[j] = tmp
                }
            }
        }
    }
}

class SelectSortTest {
    @Test
    fun test() {
        val selectSort = SelectSort()
        val array = arrayOf(5, 6, 1, 4, 7, 8, 3, 2, 9)
        selectSort.sort(array)
        array.print()
    }
}

fun Array<Int>.print() {
    for (i in this.indices) {
        print("${this[i]},")
    }
    println()
}
