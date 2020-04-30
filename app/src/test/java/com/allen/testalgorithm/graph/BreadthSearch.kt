package com.allen.testalgorithm.graph

import org.junit.Test
import java.util.*

/**
 * 描述:
 * 作者:王聪 001928
 * 创建日期：2020/4/30 on 10:04
 */
class BreadthSearch {
    fun bfs(graph: Graph, s: Int, t: Int) {
        if (s == t) {
            return
        }

        val isVisited = Array(graph.v) { false }
        isVisited[s] = true
        val queue: Queue<Int> = LinkedList()
        queue.add(s)
        val preV = Array(graph.v) { -1 }

        while (!queue.isEmpty()) {
            val v = queue.poll()
            for (i in 0 until graph.adj[v].size) {
                val w = graph.adj[v][i]
                if (!isVisited[w]) {
                    preV[w] = v
                    if (w == t) {
                        print(preV, s, t)
                        return
                    }
                }
                isVisited[w] = true
                queue.add(w)
            }
        }
    }

    fun print(preV: Array<Int>, s: Int, t: Int) {
        if (preV[t] != -1 && t != s) {
            print(preV, s, preV[t])
        }
        println(" $t")
    }

    @Test
    fun test() {
        val graph = Graph(10)
        graph.addEdge(5, 1)
        graph.addEdge(5, 6)
        graph.addEdge(6, 3)
        graph.addEdge(6, 4)
        graph.addEdge(4, 8)
        graph.addEdge(4, 9)
        graph.addEdge(4, 2)

        val breadthSearch = BreadthSearch()
        breadthSearch.bfs(graph, 5, 2)
    }
}