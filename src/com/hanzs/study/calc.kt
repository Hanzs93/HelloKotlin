package com.hanzs.study

/**
 * input: 3 * 4
 * 简单四则运算器
 */
fun main(vararg args: String) {
    if (args.size < 3) {
        return showHelp1()
    }

    val operators = mapOf(
        "+" to ::plus1,
        "-" to ::minus1,
        "*" to ::times1,
        "/" to ::div1,
    )

    val op = args[1]
    val opFunc = operators[op] ?: return showHelp1()

    try {
        println("Input:${args.joinToString(" ")}")
        println("Output:${opFunc(args[0].toInt(), args[2].toInt())}")
    } catch (e: Exception) {
        println("Invalid Arguments")
        showHelp1()
    }
}

fun showHelp1() {
    println(
        """
            
        Simple Calculator:
            Input: 3 * 4
            Output : 12
    """.trimIndent()
    )
}

fun plus1(arg0: Int, arg1: Int): Int {
    return arg0 + arg1
}

fun minus1(arg0: Int, arg1: Int): Int {
    return arg0 - arg1
}

fun times1(arg0: Int, arg1: Int): Int {
    return arg0 * arg1
}

fun div1(arg0: Int, arg1: Int): Int {
    return arg0 / arg1
}