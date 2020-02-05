package com.allen.testalgorithm

import org.junit.Test

/**
 * 1. 实现一个支持动态扩容的数组 (ArrayList)
 * Created by allen on 2020-02-05.
 */
class ArrayList(capacity: Int = 10) {
    var datas: Array<Int> = Array(capacity) { 0 }
    var total: Int = capacity
    var size: Int = 0

    fun add(element: Int) {
        if (size == total) {
            total *= 2
            val newArray = Array(total) { 0 }
            System.arraycopy(datas, 0, newArray, 0, datas.size - 1)
            datas = newArray
        }

        datas[size++] = element
    }

    fun remove(index: Int): Int {
        if (index < 0 || index >= size) {
            throw ArrayIndexOutOfBoundsException()
        }

        size--
        val delElement = datas[index]
        System.arraycopy(datas, index + 1, datas, index, size - index - 1)
        return delElement
    }

    fun print() {
        datas.print()
    }
}

class ArrayTest {
    @Test
    fun arrayListTest() {
        val arr = ArrayList()
        arr.add(1)
        arr.add(2)
        arr.add(3)
        arr.add(4)
        arr.add(5)
        arr.print()
    }
}