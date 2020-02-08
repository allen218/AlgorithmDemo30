package com.allen.testalgorithm.linedList

import com.allen.testalgorithm.LinkedList
import org.junit.Test

/**
 * 1-1. 实现单链表（LinkedList），支持增删操作
 * Created by allen on 2020-02-08.
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