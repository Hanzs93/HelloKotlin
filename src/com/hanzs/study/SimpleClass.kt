package com.hanzs.study

import com.hanzs.study.interfaces.SimpleInf

open class SimpleClass(var x: Int, val y: String) : AbsClass(), SimpleInf {
    val z: Long = 0L
    override fun absMethod() {}
    override val simpleProperty: Int
        get() {
            return 2
        }

    override fun simpleMethod() {}

    //加上final则子类不可覆写
    override fun overridable() {
        super.overridable()
    }

    fun y() {

    }

    fun zzz(string: String) {

    }

}


class SimpleClass2(x: Int, y: String) : SimpleClass(x, y) {
    override fun overridable() {
        super.overridable()
    }
}