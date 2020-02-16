package com.allen.testalgorithm.linkedList

import org.junit.Test

/**
 * 4. 实现求链表的中间节点（MiddleNodeLinkedList）
 * Created by allen on 2020-02-08.
 */
class MiddleNodeLinkedList {
    fun queryMiddleNode(node: Node): List<Node> {
        var tmp: Node? = node
        var size = 0
        while (tmp != null) {
            size++
            tmp = tmp.next
        }

        var isOdd = size % 2 == 1
        var middle = size / 2
        var middleNode: ArrayList<Node> = ArrayList()
        var tmp1 = node
        if (isOdd) {
            while (middle > 0) {
                tmp1 = tmp1.next!!
                middle--
            }
            middleNode.add(tmp1)
        } else {
            middle -= 1
            while (middle > 0) {
                tmp1 = tmp1.next!!
                middle--
            }
            middleNode.add(tmp1)
            middleNode.add(tmp1.next!!)
        }

        return middleNode
    }
}

class QueryMiddleNodeLinkedListTest {
    @Test
    fun test() {
        val linkedList = LinkedList()
        linkedList.add(1)
        linkedList.add(2)
        linkedList.add(3)
        linkedList.add(4)
        println("odd of 1,2,3,4 :")
        val queryMiddleNodeLinkedList = MiddleNodeLinkedList()

        queryMiddleNodeLinkedList.queryMiddleNode(linkedList.head!!).forEach {
            print("${it.value},")
        }
        linkedList.add(5)
        println()
        println("even of 1,2,3,4,5 :")

        queryMiddleNodeLinkedList.queryMiddleNode(linkedList.head!!).forEach {
            print("${it.value},")
        }
    }
}