package com.example.buoi2

fun main() {
    var month = 0;
    println("Nhập tháng : ");
    val s: String? = readLine()
    if (s != null) month = s.toInt()
    when(month){
        in 1..3 -> println("Quý 1")
        in 4..6 -> println("Quý 2")
        in 7..9 -> println("Quý 3")
        in 10..12 -> println("Quý 4")
        else -> println("Tháng " + month+ "không hợp lệ");

    }
}