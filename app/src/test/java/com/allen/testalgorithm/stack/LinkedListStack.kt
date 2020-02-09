package com.allen.testalgorithm.stack

import com.allen.testalgorithm.linedList.Node
import org.junit.Test

/**
 * 2. 用链表实现一个链式栈（LinkedListStack）
 * Created by allen on 2020-02-09.
 */
class LinkedListStack {
    var head: Node? = null
    var tail: Node? = null

    fun push(element: Int) {
        val node = Node(null, element)
        if (head == null) {
            head = node
            tail = head
            return
        }

        tail?.next = node
        tail = tail?.next
    }

    fun pop(): Int {
        if (isEmpty()) {
            throw NullPointerException()
        }

        if (head!!.next == null) {
            val tmp = head?.value
            head = null
            return tmp!!
        }

        var tmp = head
        while (tmp?.next?.next != null) {
            tmp = tmp.next
        }

        val value = tmp?.next?.value
        tmp?.next = null
        tail = tmp

        return value!!
    }

    fun peek(): Int {
        if (isEmpty()) {
            throw NullPointerException()
        }

        var tmp = head
        while (tmp?.next != null) {
            tmp = tmp.next
        }

        val value = tmp?.value

        return value!!
    }

    fun isEmpty(): Boolean = head == null
}

class LinkedListStackTest {
    @Test
    fun test() {
        val linkedListStack = LinkedListStack()
        linkedListStack.push(1)
        linkedListStack.push(2)
        linkedListStack.push(3)
        linkedListStack.push(4)

        println("popping 1 : ${linkedListStack.pop()}")
        println("popping 2 : ${linkedListStack.pop()}")

        println("after adding 2 element : ")

        linkedListStack.push(3)
        linkedListStack.push(4)

        println("popping 1 : ${linkedListStack.pop()}")
        println("popping 2 : ${linkedListStack.pop()}")
        println("popping 3 : ${linkedListStack.pop()}")
        println("popping 4 : ${linkedListStack.pop()}")
    }
}