package com.example.buoi2

fun main() {
//    var listFood = listOf("Pho", "Bo", 34, "Com Rang", true);
//    for (item in listFood){
//        println(item)
//    }

//    for(index in listFood.indices){
//        println(listFood[index]);
//    }

//    for ((index,value) in listFood.withIndex()){
//
//        println("$index la $value");
//    }

    var listFood = listOf("Pho", "Bo", "Ho", "Com Rang", "bibi");
    var price = listOf(34,23,45,6,63)

    Name@ for((index,value) in listFood.withIndex()){
        println(value)
        for(i in index .. price.size){
            println(price[i]);
            if(price[i] == 45) break@Name
            else continue@Name
        }
    }
}