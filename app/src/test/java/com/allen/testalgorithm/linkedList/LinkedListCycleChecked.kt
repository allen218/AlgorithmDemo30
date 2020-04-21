package com.allen.testalgorithm.linkedList

import org.junit.Test

/**
 * 1-2. 循环链表（CircularLinkedList）,支持增删操作
 * Created by allen on 2020-02-08.
 */

class LinkedListCycleChecked {

    fun hasCycle(node: Node?): Boolean {
        if (node?.next == null) {
            return false
        }

        var p1 = node.next
        var p2 = p1?.next

        while (p1 != null && p2 != null) {
            p1 = p1.next
            p2 = p2.next
            if (p2?.next != null) {
                p2 = p2.next
            }

            if (p2 == p1) {
                return true
            }
        }
        return false
    }
}

class LinkedListCycleCheckedTest {
    @Test
    fun test() {
        val linkedListCycleChecked = LinkedListCycleChecked()
        val node0 = Node(null, 0)
        val node1 = Node(null, 1)
        val node2 = Node(null, 2)
        val node3 = Node(null, 3)
        val node4 = Node(null, 4)
        node0.next = node1
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node2

        println(
            "it has a cycle in this linked list. the result is : ${linkedListCycleChecked.hasCycle(
                node0
            )}"
        )

        node4.next = null

        println(
            "it hasn't a cycle in this linked list. the result is : ${linkedListCycleChecked.hasCycle(
                node0
            )}"
        )

    }
}