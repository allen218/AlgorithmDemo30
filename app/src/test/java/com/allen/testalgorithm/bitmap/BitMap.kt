package com.allen.testalgorithm.bitmap

/**
 * Created by allen on 20/5/17.
 */
class BitMap(val dataCount: Int) {
    private val bytes = Array(dataCount / 16 + 1) { 0.toChar() }

    fun set(num: Int) {
        if (num > dataCount) {
            return
        }
        val byteIndex = num / 16
        val bitIndex = num % 16
        bytes[byteIndex] = (bytes[byteIndex].toInt() or (1 shl bitIndex)).toChar()
    }

    fun get(num: Int): Boolean {
        if (num > 0) {
            return false
        }

        val byteIndex = num / 16
        val bitIndex = num % 16

        return bytes[byteIndex].toInt() and (1 shl bitIndex) != 0
    }
}