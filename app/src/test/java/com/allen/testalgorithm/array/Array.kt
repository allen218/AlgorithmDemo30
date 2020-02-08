package com.allen.testalgorithm.array

import org.junit.Test

/**
 * 1. 实现一个支持动态扩容的数组 (ArrayList)
 * 2. 实现一个大小固定的有序数组，支持动态增删改操作（ArraySequenceList）
 * 3. 实现两个有序数组合并成一个有序数组（ArrayListCombine）
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