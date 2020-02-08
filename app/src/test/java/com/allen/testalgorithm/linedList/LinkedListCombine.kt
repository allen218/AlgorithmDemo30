package com.allen.testalgorithm.linedList

import org.junit.Test

/**
 * 3. 实现两个有序的链表合并为一个有序链表
 * Created by allen on 2020-02-08.
 */
class LinkedListCombine {
    fun combine(orderedList1: LinkedList, orderedList2: LinkedList): LinkedList {
        if (!check(orderedList1) || !check(orderedList2)) {
            throw RuntimeException("at least one of params isn't ordered.")
        }

        var o1 = orderedList1.head
        var o2 = orderedList2.head
        var newList = LinkedList()

        if (o1!!.value > o2!!.value) {
            newList.add(o2.value)
            o2 = o2.next
        } else {
            newList.add(o1.value)
            o1 = o1.next
        }

        while (o1 != null && o2 != null) {
            if (o1.value > o2.value) {
                newList.add(o2.value)
                o2 = o2.next
            } else {
                newList.add(o1.value)
                o1 = o1.next
            }
        }

        if (o1 == null) {
            while (o2 != null) {
                newList.add(o2.value)
                o2 = o2.next
            }
        }

        if (o2 == null) {
            while (o1 != null) {
                newList.add(o1.value)
                o1 = o1.next
            }
        }

        return newList

    }

    fun check(orderedList: LinkedList): Boolean {
        var tmp = orderedList.head
        while (tmp?.next != null) {
            if (tmp.value > tmp.next!!.value) {
                return false
            }
            tmp = tmp.next
        }
        return true
    }
}

class LinkedListCombineTest {
    @Test
    fun test() {
        val ordered1 = LinkedList()
        ordered1.add(1)
        ordered1.add(8)
        ordered1.add(12)
        ordered1.add(18)
        val ordered2 = LinkedList()
        ordered2.add(2)
        ordered2.add(9)
        ordered2.add(10)
        ordered2.add(17)
        val linkedListCombine = LinkedListCombine()
        val combineList = linkedListCombine.combine(ordered1, ordered2)
        combineList.print()
    }
}