package com.allen.testalgorithm.stack

import org.junit.Test

/**
 * 1. 用数组实现一个顺序栈（ArrayStack）
 * Created by allen on 2020-02-08.
 */
class ArrayStack(var size: Int = 10) {
    var array = Array(size) { 0 }
    var index = 0

    fun push(element: Int) {
        if (index + 1 >= size) {
            val tmp = Array(size * 2) { 0 }
            System.arraycopy(array, 0, tmp, 0, array.size)
            array = tmp
        }

        array[index++] = element
    }

    fun pop(): Int {
        if (isEmpty()) {
            throw NullPointerException()
        }

        return array[--index]
    }

    fun peek(): Int {
        if (isEmpty()) {
            throw NullPointerException()
        }

        return array[index]
    }

    fun isEmpty(): Boolean = index == 0

    fun print() {
        for (i in index - 1 downTo 0) {
            print("${array[i]},")
        }
        println()
    }
}

class ArrayStackTest {
    @Test
    fun test() {
        val arrayStack = ArrayStack()
        arrayStack.push(1)
        arrayStack.push(2)
        arrayStack.push(3)
        arrayStack.push(4)
        arrayStack.print()
        println("after popping 2 elements : ")
        arrayStack.pop()
        arrayStack.pop()
        arrayStack.print()
        println("last second element's value : ")
        println(arrayStack.pop())
        arrayStack.pop()
        print("after removing all isEmpty(): ${arrayStack.isEmpty()}")
    }
}