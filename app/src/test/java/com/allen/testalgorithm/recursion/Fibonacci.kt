package com.allen.testalgorithm.recursion

import org.junit.Test

/**
 * 1. 1. 编程实现斐波那契数列求值（Fibonacci）
 * Created by allen on 2020-02-10.
 */
class Fibonacci {
    fun calculate(length: Int): Int {
        if (length == 1 || length == 0) return 0
        if (length == 2) return 1

        return calculate(length - 1) + calculate(length - 2)
    }
}

class FibonacciTest {
    @Test
    fun test() {
        val fibonacci = Fibonacci()
        println("current length 5,values = ${fibonacci.calculate(8)}")
    }
}