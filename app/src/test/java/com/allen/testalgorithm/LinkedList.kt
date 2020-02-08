package com.allen.testalgorithm

import org.junit.Test

/**
 * 4-1. 实现单链表（LinkedList），循环链表（CircularLinkedList），双向链表（TwoWayLinkedList），支持增删操作
 * 5. 单链表反转（ReverseLinkedList）
 * 6. 实现两个有序的链表合并为一个有序链表（）
 * Created by allen on 2020-02-06.
 */
class LinkedList {
    var head: Node? = null
    var tail: Node? = null

    fun add(value: Int) {
        if (head == null) {
            val node = Node(null, value)
            head = node
            tail = node
            return
        }

        tail?.next = Node(null, value)
        tail = tail?.next
    }

    fun delete(): Boolean {
        if (head == null) {
            return false
        }

        if (head?.next == null) {
            tail = null
            head = null
            return false
        }

        var tmp = head

        while (tmp?.next?.next != null) {
            tmp = tmp.next
        }

        tmp?.next = null
        tail = tmp
        return true
    }


    fun print() {
        var tmp = head
        while (tmp != null) {
            val value = tmp.value
            print("$value,")
            tmp = tmp.next
        }
        println()
    }
}

class Node(
    var next: Node?,
    val value: Int
)

class LinkedListTest {
    @Test
    fun test() {
        val linkedList = LinkedList()
        linkedList.add(1)
        linkedList.add(2)
        linkedList.add(3)
        linkedList.print()
        println("after deleting 2 nums :")
        linkedList.delete()
        linkedList.delete()
        linkedList.print()
        println("after adding 2 nums :")
        linkedList.add(2)
        linkedList.add(3)
        linkedList.print()
    }
}

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



