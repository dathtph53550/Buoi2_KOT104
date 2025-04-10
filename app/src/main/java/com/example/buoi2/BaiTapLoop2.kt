package com.example.buoi2

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {
    operator fun iterator(): Iterator<Animal> { //Toán tử operator fun iterator() giúp lớp Zoo có thể sử dụng vòng lặp for.
        return animals.iterator() //animals.iterator() trả về một iterator của danh sách động vật,
    }
}

fun main() {
    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
    for (animal in zoo) {
        println("Watch out, it's a ${animal.name}")
    }
}