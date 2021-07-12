package com.hanzs.study

abstract class AbsClass {
    abstract fun absMethod()

    //必须显示添加open 才可覆写
    open fun overridable() {}

    fun nonOverridable() {}
}