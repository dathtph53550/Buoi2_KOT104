package com.example.buoi2

fun main() {
    val point = 11
    when(point){
        8,9,10 -> println("xl gioi")
        5,6,7 -> println("xl kha")
        3,4 -> println("xl tb")
        else -> println("xl yeu")
    }
    when(point){
        in 8..10 -> println("xl gioi")
        in 5..7 -> println("xl kha")
        in 3..4 -> println("xl tb")
        else -> println("xl yeu")
    }
}