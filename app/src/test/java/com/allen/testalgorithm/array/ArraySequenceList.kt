package com.allen.testalgorithm.array

import org.junit.Test

/**
 * 2. 实现一个大小固定的有序数组，支持动态增删改操作（ArraySequenceList）
 * Created by allen on 2020-02-08.
 */
class ArraySequenceList(private val capacity: Int = 10) {
    var datas = Array(capacity) { 0 }
    var size = 0

    fun add(element: Int): Boolean {
        if (size >= capacity) {
            return false
        }

        realSort(element)

        size++
        return true
    }

    private fun realSort(element: Int) {
        var curIndex = 0
        for (i in size - 1 downTo 0) {
            if (datas[i] > element) {
                datas[i + 1] = datas[i]
            } else {
                curIndex = i + 1
                break
            }
        }
        datas[curIndex] = element
    }

    fun remove(index: Int): Int {
        if (index < 0 || index >= size) {
            throw ArrayIndexOutOfBoundsException()
        }

        val delElement = datas[index]
        val moveSize = size - index - 1
        if (moveSize > 0) {
            System.arraycopy(datas, index + 1, datas, index, moveSize)
        }
        size--
        return delElement
    }

    fun update(index: Int, element: Int): Int {
        if (index < 0 || index >= size) {
            throw ArrayIndexOutOfBoundsException()
        }

        val oldValue = datas[index]
        realSort(element)
        return oldValue
    }

    fun print() {
        for (i in 0 until size) {
            print("${datas[i]},")
        }
        println()
    }
}

class ArraySequenceListTest {
    @Test
    fun test() {
        val arr = ArraySequenceList()
        arr.add(5)
        arr.add(7)
        arr.add(3)
        arr.add(9)
        arr.add(8)
        arr.add(1)
        arr.add(2)
        arr.print()
        arr.remove(0)
        arr.remove(0)
        arr.remove(0)
        println("after del 0 to 2 :")
        arr.print()
        arr.add(3)
        arr.add(7)
        arr.add(10)
        arr.add(1)
        println("after add 4 elements :")
        arr.print()
    }
}