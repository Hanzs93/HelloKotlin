package com.hanzs.study

fun main() {
    /**
     * 1 声明变量
     */
    var a = 2
    val b = "Hello Kotlin"

//    val c = 1234567890l //compile error
    val c = 1234567890L //ok

    /**
     * 2 类型转换
     */
    val e: Int = 10
//    val f: Long = e //implicitness not allowed
    val f: Long = e.toLong()

    val float1 = 1f
    val double1 = float1.toDouble()

    /**
     * 3 无符号类型 （kotlin v1.3）
     */
    val g:UInt = 10u
    val h:ULong = 10000000000000000000u

    val i:UByte = 1u

    println("Range of Int:[${Int.MIN_VALUE},${Int.MAX_VALUE}]")
    println("Range of Int:[${UInt.MIN_VALUE},${UInt.MAX_VALUE}]")


}