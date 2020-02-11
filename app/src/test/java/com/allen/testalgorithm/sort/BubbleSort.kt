package com.allen.testalgorithm.sort

import org.junit.Test

/**
 * 2. 冒泡排序（BubbleSort）
 * Created by allen on 2020-02-11.
 */
class BubbleSort {
    fun sort(array: Array<Int>) {
        for (i in 0 until array.size - 1) {
            for (j in 0 until array.size - 1 - i) {
                if (array[j] > array[j + 1]) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                }
            }
        }
    }
}

class BubbleSortTest {
    @Test
    fun test() {
        val bubbleSort = BubbleSort()
        val array = arrayOf(5, 8, 9, 1, 3, 2, 7, 6, 4)
        bubbleSort.sort(array)
        array.print()
    }
}