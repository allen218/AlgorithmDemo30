package com.allen.testalgorithm.tree

import org.junit.Test

/**
 * Only support 26 elements alphabet of low case.
 *
 * Created by allen on 20/5/7.
 */
class TrieTree {
    private val root = TrieNode('/')

    @Test
    fun test() {
        insert("abcde")
        insert("adbaaccc")
        insert("allen")
        insert("naamaa")
        println(find("abcde"))
        println(find("abcd"))
    }

    fun insert(str: String) {
        var p = root
        str.toCharArray().forEach {
            val index = it - 'a'
            if (p.children[index] == null) {
                val newNode = TrieNode(it)
                p.children[index] = newNode
            }
            p = p.children[index]!!
        }
        p.isEndingChar = true
    }

    fun find(str: String): Boolean {
        var p = root
        str.toCharArray().forEach {
            val index = it - 'a'
            if (p.children[index] == null) {
                return false
            }
            p = p.children[index]!!
        }
        if (p.isEndingChar) {
            return true
        }
        return false
    }
}

class TrieNode(
    var data: Char,
    val children: Array<TrieNode?> = Array(26) { null },
    var isEndingChar: Boolean = false
)