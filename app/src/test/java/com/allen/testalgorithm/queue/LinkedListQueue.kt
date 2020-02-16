package com.allen.testalgorithm.queue

import com.allen.testalgorithm.linkedList.Node
import org.junit.Test

/**
 * Created by allen on 2020-02-09.
 */
class LinkedListQueue {
    private var head: Node? = null
    private var tail: Node? = null

    fun enqueue(element: Int) {
        val node = Node(null, element)
        if (head == null) {
            head = node
            tail = head
            return
        }

        tail?.next = node
        tail = tail?.next
    }

    fun dequeue(): Int {
        if (head == null) {
            throw NullPointerException()
        }

        val tmp = head?.value
        head = head?.next
        return tmp!!
    }

    fun isEmpty() = head == null
}

class LinkedListQueueTest {
    @Test
    fun test() {
        val linkedListQueue = LinkedListQueue()

        println("add 4 elements to queue :")
        linkedListQueue.enqueue(1)
        linkedListQueue.enqueue(2)
        linkedListQueue.enqueue(3)
        linkedListQueue.enqueue(4)

        println("remove all elements :")
        while (!linkedListQueue.isEmpty()) {
            print("${linkedListQueue.dequeue()},")
        }
        println()
        println("current queue is empty : ${linkedListQueue.isEmpty()}")
    }
}