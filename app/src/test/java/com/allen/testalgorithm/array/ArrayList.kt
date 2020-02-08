package com.allen.testalgorithm.array

import org.junit.Test

/**
 * 1. 实现一个支持动态扩容的数组 (ArrayList)
 * Created by allen on 2020-02-08.
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

        val delElement = datas[index]
        val moveSize = size - index - 1
        if (moveSize > 0) {
            System.arraycopy(datas, index + 1, datas, index, size - index - 1)
        }
        size--
        return delElement
    }

    fun print() {
        for (i in 0 until size) {
            print("${datas[i]},")
        }
        println()
    }
}

class ArrayListTest {
    @Test
    fun arrayListTest() {
        val arr = ArrayList()
        arr.add(1)
        arr.add(2)
        arr.add(3)
        arr.add(4)
        arr.add(5)
        arr.print()
        arr.remove(4)
        arr.remove(3)
        arr.remove(2)
        arr.remove(1)
        arr.remove(0)
        println("after removing all: size = ${arr.size}")
        arr.add(1)
        arr.add(2)
        arr.add(3)
        arr.add(4)
        arr.add(5)
        println("after adding 1 to 5 :")
        arr.remove(0)
        arr.remove(0)
        println("after del 0 to 1 :")
        arr.print()
    }
}