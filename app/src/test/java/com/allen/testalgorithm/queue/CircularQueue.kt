package com.allen.testalgorithm.queue

import org.junit.Test

/**
 * Created by allen on 2020-02-09.
 */
class CircularQueue(private val capacity: Int = 10) {
    private var items = Array(capacity) { 0 }
    var head: Int = 0
    var tail: Int = 0

    fun enqueue(element: Int) {
        if (isFull()) {
            throw RuntimeException("it's full.")
        }

        items[tail++] = element
        tail %= capacity
    }

    fun dequeue(): Int {
        if (isEmpty()) {
            throw RuntimeException("it's empty.")
        }

        val tmp = items[head++]
        head %= capacity
        return tmp
    }

    fun isEmpty() = head == tail

    fun isFull() = head == (tail + 1) % capacity
}

class CircularQueueTest {
    @Test
    fun test() {
        val circularQueue = CircularQueue()
        circularQueue.enqueue(1)
        circularQueue.enqueue(2)
        circularQueue.enqueue(3)
        circularQueue.enqueue(4)
        circularQueue.enqueue(5)
        circularQueue.enqueue(6)
        circularQueue.enqueue(7)
        circularQueue.enqueue(8)
        circularQueue.enqueue(9)
        println("after add 1 ~ 9 elements,isFull : ${circularQueue.isFull()}")

        circularQueue.dequeue()
        circularQueue.dequeue()
        circularQueue.dequeue()
        circularQueue.dequeue()
        println("after remove 4 elements :")

        circularQueue.enqueue(10)
        circularQueue.enqueue(11)
        circularQueue.enqueue(12)
        circularQueue.enqueue(13)
        println("after add 10 ~13 elements :")

        while (!circularQueue.isEmpty()) {
            print("${circularQueue.dequeue()},")
        }
        println()
        println("after remove all elements, isEmpty: ${circularQueue.isEmpty()}")
    }

}