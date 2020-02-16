package com.allen.testalgorithm.linkedList

import org.junit.Test

/**
 * 1-2. 循环链表（CircularLinkedList）,支持增删操作
 * Created by allen on 2020-02-08.
 */

class CircularLinkedList {
    var head: Node? = null
    var tail: Node? = null

    fun add(value: Int) {
        val node = Node(null, value)
        if (head == null) {
            head = node
            tail = node
            head?.next = tail
            tail?.next = head
            return
        }

        tail?.next = node
        tail = tail?.next
        tail?.next = head
    }

    fun delete(): Int {
        if (head == null) {
            throw NullPointerException()
        }

        var tmp = head
        while (tmp?.next?.next != head) {
            tmp = tmp?.next
        }

        val delValue = tmp!!.next!!.value
        tmp.next = head
        tail = tmp
        return delValue
    }

    fun print() {
        var tmp = head
        while (tmp?.next != head) {
            val value = tmp?.value
            print("$value,")
            tmp = tmp?.next
        }
        print("${tmp?.value}")
        println()
    }
}

class CircularLinkedListTest {
    @Test
    fun test() {
        val circularLinkedList = CircularLinkedList()
        circularLinkedList.add(1)
        circularLinkedList.add(2)
        circularLinkedList.add(3)
        circularLinkedList.print()
        println("after deleting 2 numbers :")
        circularLinkedList.delete()
        circularLinkedList.delete()
        circularLinkedList.print()
        println("after adding 2 numbers :")
        circularLinkedList.add(2)
        circularLinkedList.add(3)
        circularLinkedList.print()
    }
}