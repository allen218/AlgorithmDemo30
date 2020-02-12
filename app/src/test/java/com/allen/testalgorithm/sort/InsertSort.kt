package com.allen.testalgorithm.sort

import org.junit.Test

/**
 * 3. 插入排序（InsertSort）
 * Created by allen on 2020-02-11.
 */
class InsertSort {
    fun sort(array: Array<Int>) {
        println(array.javaClass)
        for (i in 1 until array.size) {
            val unSortFirstNode = array[i]
            var index = -1
            var isMove = false
            for (j in i - 1 downTo 0) {
                if (array[j] > unSortFirstNode) {
                    isMove = true
                    index = j
                    array[j + 1] = array[j]
                } else {
                    break
                }
            }

            if (isMove) {
                array[index] = unSortFirstNode
            }
        }
    }
}

class InsertSortTest {
    @Test
    fun test() {
        val insertSort = InsertSort()
        val array = arrayOf(6, 8, 5, 3, 1, 2, 4, 9, 7)
        insertSort.sort(array)
        array.print()
    }
}