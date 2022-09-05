package com.example.learnkotlin


fun sum (a: Int, b: Int): Int {
    return a + b
}

fun div (a: Int, b: Int): Int {
    return a / b
}

fun sub (a: Int, b: Int): Int {
    return a - b
}

fun mul (a: Float, b: Float): Float {
    return a * b}

fun printSum(a: Int, b: Int){
    println("Sum of $a and $b is ${a+b}")
}

fun printSub(a: Int, b: Int){
    println("Sub of $a and $b is ${a-b}")
}

fun printDiv(a: Int, b: Float) {
    println("Div of $a and $b is ${a/b} ")
}

fun printMul(a: Int, b: Int) {
    println("Mul of $a and $b is ${a*b}")
}

fun main()
{
    print(sum(5,6))
    print("\n")
    print(sub(1000,5))
    print("\n")
    print(mul(10F, 10F))
    print("\n")
    printSum(100, 200)
    print("\n")
    printMul(100,500)
    print("\n")
    printDiv(400, 500F)
    print("\n")
    printSub(500, 320)

}