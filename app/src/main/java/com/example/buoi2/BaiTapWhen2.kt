package com.example.buoi2



fun main() {
    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(BaiTapWhen2()))
}

fun whenAssign(obj: Any): Any {
    val result = when (obj) {                   // 1
        1 -> "one"                              // 2
        "Hello" -> 1                            // 3
        is Long -> false                        // 4
        else -> 42                              // 5
    }
    return result
}

class BaiTapWhen2

