package com.allen.testalgorithm.linkedList

import org.junit.Test

/**
 * 5. 实现结点的两两交换（SwapInPairsLinkedList）
 * Created by allen on 2020-02-09.
 */
class SwapInPairsLinkedList {
    fun swap(node: Node): Node? {
        var self = Node(null, -1)
        var pre = self
        pre.next = node
        var swapA: Node?
        var swapB: Node?
        while (pre.next != null && pre.next?.next != null) {
            swapA = pre.next
            swapB = swapA?.next

            pre.next = swapB
            val swapTmp = swapB?.next
            swapB?.next = swapA
            swapA?.next = swapTmp

            pre = swapA!!
        }
        return self.next
    }
}

class SwapInPairsLinkedListTest {
    @Test
    fun test() {
        val linkedList = LinkedList()
        linkedList.add(1)
        linkedList.add(2)
        linkedList.add(3)
        linkedList.add(4)
        linkedList.add(5)
        linkedList.add(6)
        linkedList.add(7)
        linkedList.print()
        println("after swapping in pairs :")
        val swapInPairsLinkedList = SwapInPairsLinkedList()
        printNode(swapInPairsLinkedList.swap(linkedList.head!!))
    }
}