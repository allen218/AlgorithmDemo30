package com.allen.testalgorithm.hashtable

import org.junit.Test

/**
 * Created by allen on 2020-02-14.
 */
class HashMap(val capacity: Int = 16) {
    private val datas = Array<String?>(capacity) { null }
    private val nodes = Array<Node?>(capacity) { null }

    fun put(element: String) {
        val hashValue = hash(element)
        if (datas[hashValue] == null) {
            datas[hashValue] = element
        } else {
            if (datas[hashValue] == element) {
                return
            } else {
                var node: Node? = nodes[hashValue]
                if (node == null) {
                    node = Node(null, null, element)
                    nodes[hashValue] = node
                } else {
                    // check linked list is or not exist
                    var isExist = false
                    while (node?.next != null) {
                        if (node.value == element) {
                            isExist = true
                            break
                        }
                        node = node.next
                    }

                    if (!isExist) {
                        node?.next = Node(null, node, element)
                    }
                }
            }
        }
    }

    fun remove(element: String): String? {
        val hashV = hash(element)
        val value = datas[hashV]
        if (value != null) {
            if (value == element) {
                datas[hashV] = null
                return value
            } else {
                var node = nodes[hashV]
                var isExist = false
                while (node != null) {
                    if (node.value == element) {
                        isExist = true
                        break
                    }
                }

                if (isExist) {
                    val delValue = node?.value
                    node?.pre?.next = node?.next
                    return delValue
                }
                return null
            }
        } else {
            return null
        }

    }

    fun hash(element: String): Int {
        val h = element.hashCode()
        return h xor (h ushr 3) and (capacity - 1)
    }
}

class Node(
    var next: Node?,
    var pre: Node?,
    val value: String
)

class HashMapTest {
    @Test
    fun test() {
        val hashMap = HashMap()
        hashMap.put("aadf")
        hashMap.put("badbads")
        hashMap.put("ccc")
        hashMap.put("adfbab")
        hashMap.put("afbadf")
        hashMap.put("asfgrqg")
        println(hashMap.remove("asfgrqg"))
    }
}
