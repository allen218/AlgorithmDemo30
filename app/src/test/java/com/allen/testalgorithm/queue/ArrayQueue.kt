package com.allen.testalgorithm.queue

import org.junit.Test

/**
 * 1. 用数组实现一个顺序队列（ArrayQueue）
 * Created by allen on 2020-02-09.
 */
class ArrayQueue(private var capacity: Int = 10) {
    private var items = Array(capacity) { 0 }
    private var head: Int = 0
    private var tail: Int = 0

    fun enqueue(element: Int) {
        if (tail == capacity) {
            val tmp = Array(capacity * 2) { 0 }
            System.arraycopy(items, 0, tmp, 0, isEmpty())
            items = tmp
        }

        items[tail++] = element
    }

    fun dequeue(): Int {
        if (isEmpty() == 0) {
            throw NullPointerException()
        }

        return items[head++]
    }

    fun isEmpty() = tail - head

}

class ArrayQueueTest {
    @Test
    fun test() {
        val arrayQueue = ArrayQueue()
        arrayQueue.enqueue(1)
        arrayQueue.enqueue(2)
        arrayQueue.enqueue(3)
        arrayQueue.enqueue(4)
        arrayQueue.enqueue(5)
        arrayQueue.enqueue(6)
        arrayQueue.enqueue(7)
        arrayQueue.enqueue(8)
        arrayQueue.enqueue(9)
        arrayQueue.enqueue(10)
        arrayQueue.enqueue(11)
        arrayQueue.enqueue(12)
        println("current queue isEmpty : ${arrayQueue.isEmpty()}")

        println("all get out of the queue :")
        while (arrayQueue.isEmpty() != 0) {
            print("${arrayQueue.dequeue()},")
        }
        println()
    }
}