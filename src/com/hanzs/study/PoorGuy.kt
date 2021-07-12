package com.hanzs.study

class PoorGuy {
    var pocket: Double = 0.0
}

fun PoorGuy.noMoney() {

}

// 扩展属性
// property = backing field + getter + setter 类里面
var PoorGuy.moneyLeft: Double
    get() {
        return 0.0
    }
    set(value) {
        pocket = value
    }

//接口中无法存储状态，只有行为
interface Guy {
    var moneyLeft: Double
        get() {
            return 0.0
        }
        set(value) {}
}