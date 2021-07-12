package com.hanzs.study

import com.sun.org.apache.xpath.internal.functions.Function3Args

fun main(vararg args: String): Unit {
    println(args.contentToString())

    //函数引用
    val f: () -> Unit = ::foo
    val g: (Int) -> String = ::foo
    //(Foo.String,Long)->Any = Foo.(Strin,Long) -> Any = Function3<Foo,String,Long,Any>
    val h: (Foo, String, Long) -> Any = Foo::bar
    val i: Foo.(String, Long) -> Any = Foo::bar
    val j: Function3<Foo, String, Long, Any> = Foo::bar
    yy(h)

    val foo = Foo() //将Foo实例化出来
    val m: (String, Long) -> Any = foo::bar //绑定receiver的函数引用

    //变长参数
    multiParameters(1, 2, 3, 4)
    listOf(1, 2, 3, 4)//源码就是变长参数

    //多返回值
    val (a, b, c) = multiReturnValues()
    val r = a + b
    val r1 = a + c

    //默认参数
    defaultParameter1(5, "Hello")

    //具名参数
    defaultParameter2(y = "Hello")
}

//将一个函数作为参数
fun yy(p: (Foo, String, Long) -> Any) {
    p(Foo(), "Hello", 3L)
    //p.invoke(Foo(),"Hello",3L)
}

//kotlin中可以不定义类，直接定义函数，这些也叫顶级函数
//函数类型： ()->Unit
fun foo() {}

//函数类型； (Int) -> String
fun foo(p: Int): String {
    TODO()
}

//bar的函数类型：
//Foo.(String,Long) -> Any  有一个Receiver
//相当于(Foo,String,Long) -> Any
class Foo() {
    //方法
    fun bar(p0: String, p1: Long): Any {
        TODO()
    }
}

//变长参数
//fun main(vararg args: String) {
//    println(args.contentToString())
//}
fun multiParameters(vararg ints: Int) {
    println(ints.contentToString())
}

//多返回值
fun multiReturnValues(): Triple<Int, Long, Double> {
    return Triple(1, 3L, 4.0)
}

//默认参数
fun defaultParameter(x: Int, y: String, z: Long) {
    TODO()
}

//不传参，使用默认值。放在最后
fun defaultParameter1(x: Int, y: String, z: Long = 0L) {
    TODO()
}

//具名参数
fun defaultParameter2(x: Int = 5, y: String, z: Long = 0L) {

}