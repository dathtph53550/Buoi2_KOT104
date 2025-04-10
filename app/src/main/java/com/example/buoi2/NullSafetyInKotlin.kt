package com.example.buoi2

fun main() {
    var str1  = "Hihii";
    var str2 : String? = "Co gia tri"
    var str3 : String? = null
    funny2(str1)
}

fun funny(text : String?){
    if(text != null) println(text);
    else println("Loi rui ku iem")
}

fun  funny2(text : String?){
    var toPrint = text ?: "Loi rui ku";
    println(toPrint);
}