package com.allen.testalgorithm.recursion

import org.junit.Test

/**
 * 2. 编程实现求阶乘 n!
 * Created by allen on 2020-02-10.
 */
class Factorial {
    fun calculate(num: Int): Int {
        if (num == 0) {
            return 0
        }

        if (num == 1) {
            return 1
        }

        return num * calculate(num - 1)
    }
}

class FactorialTest {
    @Test
    fun test() {
        val factorial = Factorial()
        println("factorial 5 values = ${factorial.calculate(5)}")
    }
}