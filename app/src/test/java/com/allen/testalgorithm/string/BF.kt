package com.allen.testalgorithm.string

/**
 * 描述:
 * 作者:王聪 001928
 * 创建日期：2020/8/11 on 10:45
 */

class BF {
    @Test
    fun test() {
        val test1 = "aaaaaab"
        val test2 = "aaab"

        println(match(test1, test2))
    }

    private fun match(a: String, b: String): Int {
        for (i in 0 until a.length - b.length + 1) {
            val tmpStr = a.substring(i, i + b.length)
            if (tmpStr == b) {
                return i
            }
        }
        return -1
    }
}