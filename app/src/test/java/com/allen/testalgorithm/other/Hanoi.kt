package com.allen.testalgorithm.other

import org.junit.Test

/**
 * 描述:
 * 作者:王聪 001928
 * 创建日期：2020/5/29 on 20:10
 */
class Hanoi {
    @Test
    fun test() {
        hanoi(3, 'A', 'B', 'C')
    }

    fun hanoi(n: Int, from: Char, buffer: Char, to: Char) {
        if (n == 1) {
            println("$from to $to")
        } else {
            hanoi(n - 1, from, to, buffer)
            println("$from to $to")
            hanoi(n - 1, to, buffer, from)
        }
    }
}