package com.allen.testalgorithm.graph

import java.util.*

/**
 * 描述:
 * 作者:王聪 001928
 * 创建日期：2020/4/30 on 9:45
 */
class Graph(
    val v: Int
) {
    var adj: Array<LinkedList<Int>> = Array(v) { LinkedList<Int>() }

    fun addEdge(s: Int, t: Int) {
        adj[s].add(t)
        adj[t].add(s)
    }
}