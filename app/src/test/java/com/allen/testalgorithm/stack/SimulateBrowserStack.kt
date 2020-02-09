package com.allen.testalgorithm.stack

import org.junit.Test

/**
 * 3. 编程模拟实现一个浏览器的前进、后退功能（SimulateBrowserStack）
 * Created by allen on 2020-02-09.
 */
class SimulateBrowserStack {
    private var forwardStack = LinkedListStack()
    private var backStack = LinkedListStack()

    /**
     * page: example: page > 0
     */
    fun forward(page: Int) {
        println("forward:$page,")
        if (page <= 0) {
            throw RuntimeException("please input page > 0")
        }
        backStack.push(page)
    }

    fun back(): Int {
        if (backStack.isEmpty()) {
            return -1
        }

        var tmp = backStack.pop()
        forwardStack.push(tmp)
        println("back: $tmp,")

        return tmp
    }

    fun forwardNew(page: Int) {
        while (!forwardStack.isEmpty()) {
            forwardStack.pop()
        }

        backStack.push(page)
    }
}

class SimulateBrowserStackTest {
    @Test
    fun test() {
        val simulateBrowserStack = SimulateBrowserStack()
        println("forward 1,2,3 : ")
        simulateBrowserStack.forward(1)
        simulateBrowserStack.forward(2)
        simulateBrowserStack.forward(3)

        println("back 2 times : ")
        simulateBrowserStack.back()
        simulateBrowserStack.back()

        println("forward new page 4,5:")
        simulateBrowserStack.forward(4)
        simulateBrowserStack.forward(5)

        println("back all page:")
        while (simulateBrowserStack.back() != -1) {
            simulateBrowserStack.back()
        }

        println("can't back")
    }
}