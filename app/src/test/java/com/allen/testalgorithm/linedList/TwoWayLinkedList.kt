package com.allen.testalgorithm.linedList

import org.junit.Test

/**
 * 4-3. 双向链表（TwoWayLinkedList）,支持增删操作
 * Created by allen on 2020-02-08.
 */
class Node1(
    val value: Int,
    var next: Node1?,
    var pre: Node1?
)

class TwoWayLinkedList {
    private var head: Node1? = null

    fun add(element: Int) {
        val node = Node1(element, null, null)
        if (head == null) {
            head = node
            head?.next = node
            head?.pre = node
            return
        }

        node.next = head
        node.pre = head?.pre

        head?.pre?.next = node
        head?.pre = node
    }

    fun remove() {
        if (head?.next == head) {
            head = null
            return
        }
        val lastSecond = head?.pre?.pre
        lastSecond?.next = head
        head?.pre = lastSecond
    }

    fun print() {
        var tmp = head
        while (tmp?.next != head) {
            print("${tmp?.value},")
            tmp = tmp?.next
        }
        println("${tmp?.value}")
    }
}

class TwoWayLinkedListTest {
    @Test
    fun test() {
        val twoWayLinkedList = TwoWayLinkedList()
        twoWayLinkedList.add(1)
        twoWayLinkedList.add(2)
        twoWayLinkedList.add(3)
        twoWayLinkedList.add(4)
        twoWayLinkedList.print()
        println("after deleting 4 and 3 : ")
        twoWayLinkedList.remove()
        twoWayLinkedList.remove()
        twoWayLinkedList.print()
        println("after deleting all : ")
        twoWayLinkedList.remove()
        twoWayLinkedList.remove()
        println("after adding 1 : ")
        twoWayLinkedList.add(1)
        twoWayLinkedList.print()
    }
}