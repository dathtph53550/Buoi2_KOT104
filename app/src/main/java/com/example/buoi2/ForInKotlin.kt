package com.example.buoi2

import androidx.core.graphics.convertTo

fun main() {
//    Until là <
    for (i in 1 until 10){
        println("hihi " + i);
    }


    for (i in 0 .. 10 step 2){ //step buoc nhay
        println(i)
    }

    for (i in 10 downTo  1 step 2){
        println("hihi " + i);
    }

    //Use rangTo in kotlin
    for (i in 1.rangeTo(20)){
        println("hihi " + i);
    }




}