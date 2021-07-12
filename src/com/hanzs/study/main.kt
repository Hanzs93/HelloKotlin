package com.hanzs.study

import java.net.URLDecoder
import java.net.URLEncoder

/*fun main() {
//    println("HelloWorld")
    runBlock {
        List(1000) {
            println("HelloWorld")
        }
    }
}*/

/*
fun runBlock(block: () -> Un it) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)
}*/

fun main(vararg args: String) {
    //基本数据类型比较
    var a = String("字符串".toCharArray())
    var b = String("字符串".toCharArray())
    val c = "字符串"
    //String中重写了equals方法，所以比较的是值
    println("a == b: ${a == b}")
    println("a.equals(b) : ${a.equals(b)}")

    //对象的比较
    var person1 = Person("张三", 12)
    var person2 = Person("张三", 12)
    //person1和2是两个不同的对象，内存地址不同
    //重写Person类中的equals方法后，用 == 或者equasl 可以比较值(取决于equals方法如何实现)，
    //但此时 === 的结果还是false，也就是内存地址不一样
    var person3: Person = person1
    println(
        """
        |person1.toString = ${person1.toString()}, 
        |person2.toString = ${person2.toString()} 
        |person3.toString = ${person3.toString()}""".trimMargin()
    )
    println("1 == 2 : ${person1 == person2}")
    println("1.equals2 : ${person1.equals(person2)}")
    println("1 === 2 : ${person1 === person2}")

    println("1 == 3 : ${person1 == person3}")
    println("1.equals3 : ${person1.equals(person3)}")
    println("1=== 3 : ${person1 === person3}")

    //数组的创建
    val c0 = intArrayOf(1, 2, 3, 4, 5)
    println("c0 = ${c0.contentToString()}")
    val c1 = IntArray(5) { it + 1 }
    println("c1 = ${c1.contentToString()}")
    val c2 = IntArray(5) { it -> 3 * (it + 1) }
    println("c2 = ${c2.contentToString()}")

    val e = floatArrayOf(1f, 3f, 5f, 7f)
    e.forEach { println(it) }

    if (1f in e) {
        println(" 1f exists in variable 'e'")
    }

    if (e.any { it == 1f }) {
        println(" 1f exists in variable 'e'")
    }

    if (e.asList().contains(1f)) {
        println(" 1f exists in variable 'e'")
    }

    val intList: List<Int> = listOf(1, 2, 3)
    val intList2: MutableList<Int> = mutableListOf(1, 2, 3)

    val map: Map<String, Any> = mapOf("name" to "hzs", "age" to 20) //Any等价于Java中的Object
    val map2: Map<String, Any> = mapOf("name" to "hzs", "age" to 20)
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    //to 符号创建了一个短时存活的 Pair 对象，因此建议仅在性能不重要时才使用它。
    // 为避免过多的内存使用，请使用其他方法。
    // 例如，可以创建可写 Map 并使用写入操作填充它。
    // apply() 函数可以帮助保持初始化流畅。
    val numbersMap2 = mutableMapOf<String, String>().apply { this["one"] = "1"; this["two"] = "2" }

    val stringList = ArrayList<String>(10)
    for (i in 0..10) {
        stringList.add("num:$i")
    }
    println(stringList.joinToString())

    val mutableStringList: MutableList<String> = MutableList(10, { "num = ${it * 2 + 1}" })
    println(mutableStringList.joinToString())
    val empty = emptyList<String>()

    //类和接口

    //类的实例化
//    val simpleClass = SimpleClass(9, "Hello")
//    println(simpleClass.x)
//    simpleClass.y()

    //扩展方法
    println("Hello".padding(10))


    //空类型安全
    var nullable: String? = "Hello"
    nullable = null //可空类型
    val length = nullable?.length  //length Int?类型
    val length1 = nullable?.length ?: 0  //length1 Int类型

    var value:String? = null
//    value = "benny"
    if (value != null){
        println(value.length)
    }
}


//四则运算
//fun main(vararg args: String) {
//    /*var jiamihouToken = "3575.36212097%3B75780%3B264%3A631%3A3253"
//    val originalInfo = UserTools.getOriginalInfo("3:2", URLDecoder.decode(jiamihouToken,"utf-8"))
//    println("解密后：$originalInfo")
//
//    var jiamiqianToken = "07158318864492693999720308103935"
//    val encodeInfo = UserTools.encodeInfo(jiamiqianToken, "3:2")
//    println("加密后：$encodeInfo")
//    println("加密且encoed后：${URLEncoder.encode(encodeInfo,"utf-8")}")*/
//    if (args.size < 3) {
//        return showHelp()
//    }
//
//    val operators = mapOf(
//        "+" to ::plus,
//        "-" to ::minus,
//        "*" to ::times,
//        "/" to ::div,
//    )
//
//    //三个参数中的第二个表示运算符
//    val op = args[1]
//    val opFunc = operators[op] ?: return showHelp()
//
//    try {
//        println("Input:${args.joinToString(" ")}")
//        println("Output:${opFunc(args[0].toInt(),args[2].toInt())}")
//    } catch (e: Exception) {
//        println("Invalid Arguments.")
//        showHelp()
//    }
//}

fun plus(arg0: Int, arg1: Int): Int {
    return arg0 + arg1
}

fun minus(arg0: Int, arg1: Int): Int {
    return arg0 - arg1
}

fun times(arg0: Int, arg1: Int): Int {
    return arg0 * arg1
}

fun div(arg0: Int, arg1: Int): Int {
    return arg0 / arg1
}

fun showHelp() {
    println(
        """
            
        Simple Calculator:
            Input: 3 * 4
            Output:12
    """.trimIndent()
    )
}

// 扩展方法
fun String.padding(count: Int, char: Char = ' '): String {
    val padding = (1..count).joinToString("") { char.toString() }
    return "${padding}${this}${padding}"
}

// 扩展方法
fun String.times(count: Int): String {
    return (1..count).joinToString("") { this }
}

// "*".times(10)  ==>  "**********"

