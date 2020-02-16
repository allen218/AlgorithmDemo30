package com.allen.testalgorithm.linkedList

import org.junit.Test

/**
 * 2. 单链表反转（ReverseLinkedList）
 * Created by allen on 2020-02-08.
 */
class ReverseLinkedList {
    fun reverse(head: Node?): Node? {
        if (head == null) {
            return null
        }

        var pre: Node? = null
        var cur: Node? = head
        while (cur != null) {
            val curNext = cur.next
            cur.next = pre
            pre = cur
            cur = curNext
        }
        return pre
    }
}

fun printNode(node: Node?) {
    var tmp = node
    if (node == null) {
        return
    }

    while (tmp != null) {
        print("${tmp.value},")
        tmp = tmp.next
    }
    println()
}

class ReverseLinkedListTest {
    @Test
    fun test() {
        val linkedList = LinkedList()
        linkedList.add(1)
        linkedList.add(2)
        linkedList.add(3)

        val reverseLinedList = ReverseLinkedList()
        printNode(reverseLinedList.reverse(linkedList.head))
    }
}