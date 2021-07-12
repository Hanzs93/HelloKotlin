package com.hanzs.study


class Person(val name: String, val age: Int) {
    override fun toString(): String {
        return "toString = ${super.toString()},name = ${name},age = ${age}"
    }
//
//    override fun equals(other: Any?): Boolean {
//        if (other == null || other !is Person){
//            return false
//        }
//        return (name == other.name) && (age == other.age)
//    }
}