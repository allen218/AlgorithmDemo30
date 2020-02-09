package com.allen.testalgorithm

import org.junit.Test

/**
 * Created by allen on 19/12/21.
 */
class SortO2 {
    @Test
    fun testBubble() {
        val arr = arrayOf(6, 5, 1, 3, 4, 7, 9, 2, 8)
//        bubbleSort(arr)
//        optimizedBuddleSort(arr)
//        insertSort(arr)
//        quickSort(arr)
        countingSort(arr, arr.size)
        arr.print()

    }

    fun test() {
        for (i in 5..0) {
            print(i)
        }
    }

    private fun bubbleSort(arr: Array<Int>) {
        for (i in 0 until arr.size) {
            for (j in 0 until arr.size - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val tmp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = tmp
                }
            }
        }
    }

    private fun optimizedBuddleSort(arr: Array<Int>) {
        for (i in 0 until arr.size) {
            var isSortCompleted = true
            for (j in 0 until arr.size - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val tmp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = tmp
                    isSortCompleted = false
                }
            }
            if (isSortCompleted) break
        }
    }
}

fun Array<Int>.print() {
    for (i in this) {
        print(i)
    }
}

fun insertSort(arr: Array<Int>) {
    if (arr.size <= 1) return

    for (i in 1 until arr.size) {
        var value = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > value) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = value

    }
}

fun selectSort(arr: Array<Int>) {
    if (arr.size <= 1) return

    for (i in 0 until arr.size - 1) {
        for (j in (i + 1) until arr.size) {
            if (arr[i] > arr[j]) {
                val tmp = arr[i]
                arr[i] = arr[j]
                arr[j] = tmp
            }
        }
    }
}

fun mergeSort(arr: Array<Int>) {
    mergeSortDetail(arr, 0, arr.size - 1)

}

fun mergeSortDetail(arr: Array<Int>, left: Int, right: Int) {
    if (left >= right) return

    var q = (left + right) / 2

    mergeSortDetail(arr, left, q)
    mergeSortDetail(arr, q + 1, right)
    mergeGuard(arr, left, q, right)
}

fun merge(arr: Array<Int>, left: Int, middle: Int, right: Int) {
    var tmp = Array(arr.size) { 0 }

    var i = left
    var j = middle + 1
    var k = 0

    while (i <= middle && j <= right) {
        if (arr[i] <= arr[j]) {
            tmp[k++] = arr[i++]
        } else {
            tmp[k++] = arr[j++]
        }
    }

    var start = i
    var end = middle
    if (j <= right) {
        start = j
        end = right
    }

    while (start <= end) {
        tmp[k++] = arr[start++]
    }

    for (i in 0..(right - left)) {
        arr[left + i] = tmp[i]
    }
}

fun mergeGuard(arr: Array<Int>, left: Int, middle: Int, right: Int) {
    var leftSize = middle - left + 1
    var rightSize = right - middle

    var tmpLeft = Array(leftSize + 1) { 0 }
    var tmpRight = Array(rightSize + 1) { 0 }

    for (i in 0 until leftSize) {
        tmpLeft[i] = arr[left + i]
    }

    for (j in 0 until rightSize) {
        tmpRight[j] = arr[middle + 1 + j]
    }

    tmpLeft[leftSize] = Int.MAX_VALUE
    tmpRight[rightSize] = Int.MAX_VALUE

    var i = 0
    var j = 0
    for (k in left..right) {
        if (tmpLeft[i] <= tmpRight[j]) {
            arr[k] = tmpLeft[i++]
        } else {
            arr[k] = tmpRight[j++]
        }
    }
}

fun quickSort(arr: Array<Int>) {
    if (arr.size <= 1) return
    realQuickSort(arr, 0, arr.size - 1)

}

fun realQuickSort(arr: Array<Int>, low: Int, high: Int) {
    if (low >= high) return
    var q = partition(arr, low, high)
    realQuickSort(arr, low, q - 1)
    realQuickSort(arr, q + 1, high)
}

fun partition(arr: Array<Int>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low
    for (j in low until high) {

        if (arr[j] < pivot) {
            if (i == j) {
                i++
            } else {
                val tmp = arr[j]
                arr[j] = arr[i]
                arr[i] = tmp
                i++
            }
        }
    }

    val tmp = arr[i]
    arr[i] = arr[high]
    arr[high] = tmp

    return i
}

fun countingSort(arr: Array<Int>, n: Int) {
    if (n <= 1) return

    // 1. acquire range of data
    var max = arr[0]
    for (i in arr) {
        if (i > max) {
            max = i
        }
    }

    // 2. create range array.
    var C6 = Array(max + 1) { 0 }

    // 3. calculate element count
    for (i in arr) {
        C6[i]++
    }

    // 4. accumulate range array
    for (i in 1 until C6.size) {
        C6[i] = C6[i - 1] + C6[i]
    }

    // 5. create sequenced array
    var R8 = Array(arr.size) { 0 }

    // 6. traverse array A in reverse order
    for (i in arr.size - 1 downTo 0) {
        R8[--C6[arr[i]]] = arr[i]
    }

    // 7. remove data from R8 to A8
    for (i in 0 until R8.size) {
        arr[i] = R8[i]
    }
}

class TestBinarySearch {
    @Test
    fun testBinarySearch() {
        val testArr = arrayOf(1, 2, 3, 4, 5, 5, 5, 6, 7, 9)
//        println(binarySearch(testArr, testArr.isEmpty, 5))
//        println(binarySearchReserve(testArr, testArr.isEmpty, 5))
//        println(bFirstSearch(testArr, testArr.isEmpty, 5))
//        println(bFirstSearchSimple(testArr, testArr.isEmpty, 5))
//        println(bLastSearchSimple(testArr, testArr.isEmpty, 5))
//        println(bFirstGtSearch(testArr, testArr.isEmpty, 8))
        println(bLastLtSearch(testArr, testArr.size, 8))
    }
}

fun binarySearch(arr: Array<Int>, n: Int, key: Int): Int {
    var low = 0
    var high = n - 1
    while (low <= high) {
        var mid = (low + high) / 2
        when {
            arr[mid] == key -> return mid
            arr[mid] > key -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return -1
}

fun binarySearchReserve(arr: Array<Int>, n: Int, key: Int): Int {
    return binarySearchCore(arr, 0, n - 1, key)
}

fun binarySearchCore(arr: Array<Int>, low: Int, high: Int, key: Int): Int {
    if (low > high) return -1

    var mid = low + ((high - low) shr 1)  // shr equals >>
    if (arr[mid] == key) {
        return mid
    } else if (arr[mid] > key) {
        return binarySearchCore(arr, mid + 1, high, key)
    } else {
        return binarySearchCore(arr, low, mid - 1, key)
    }
}

fun bFirstSearch(arr: Array<Int>, n: Int, key: Int): Int {
    var low = 0
    var high = n - 1
    while (low <= high) {
        var mid = low + ((high - low) shr 1)
        when {
            arr[mid] >= key -> high = mid - 1
            else ->
                low = mid + 1
        }
    }

    return if (low < n && arr[low] == key) low else -1
}

fun bFirstSearchSimple(arr: Array<Int>, n: Int, key: Int): Int {
    var low = 0
    var high = n - 1
    while (low <= high) {
        var mid = low + ((high - low) shr 1)
        when {
            arr[mid] < key -> low = mid + 1
            arr[mid] > key -> high = mid - 1
            else ->
                if (mid == 0 || arr[mid - 1] != key) return mid else high = mid - 1
        }
    }
    return -1
}

fun bLastSearchSimple(arr: Array<Int>, n: Int, key: Int): Int {
    var low = 0
    var high = n - 1
    while (low <= high) {
        var mid = low + ((high - low) shr 1)
        when {
            arr[mid] < key -> low = mid + 1
            arr[mid] > key -> high = mid - 1
            else ->
                if (mid == n - 1 || arr[mid + 1] != key) return mid else low = mid + 1
        }
    }
    return -1
}

fun bFirstGtSearch(arr: Array<Int>, n: Int, key: Int): Int {
    var low = 0
    var high = n - 1
    while (low <= high) {
        var mid = low + ((high - low) shr 1)
        when {
            arr[mid] >= key -> if (mid == 0 || arr[mid - 1] < key) return mid else high = mid - 1
            arr[mid] < key -> low = mid + 1
        }
    }
    return -1
}

fun bLastLtSearch(arr: Array<Int>, n: Int, key: Int): Int {
    var low = 0
    var high = n - 1
    while (low <= high) {
        var mid = low + ((high - low) shr 1)
        when {
            arr[mid] > key -> high = mid - 1
            arr[mid] <= key -> if (mid == n - 1 || arr[mid + 1] > key) return mid else low = mid + 1
        }
    }

    return -1
}


