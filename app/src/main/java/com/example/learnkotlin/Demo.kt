package com.example.learnkotlin

import kotlin.math.sqrt

abstract class Hotel(private val number: Int, private val name: String){
    abstract val type: String

    abstract val size: Int

    fun hasRoomofHotel(): Boolean {
        return number < size
    }

    fun getRoomofHotel() {
        if (number < size){
            println("You have room in our Hotel")
        }else {
            println("Your room is not available")
        }
    }

    abstract fun dientichsan() : Double
}

class Luxury(number: Int, name: String, private val length: Int) : Hotel(number, name) {
    override val type = "Luxury"
    override val size = 100

    override fun dientichsan() : Double {
        return (length * length).toDouble()
    }
}


open class Normal(number: Int, name: String, private val radius: Double) : Hotel(number, name) {
    override val type = "Normal"
    override val size = 1000

    override fun dientichsan(): Double {
        return 3.14 * radius
    }

    fun cal(): Double {
        val mewo = radius * 3.14
        return sqrt(mewo)
    }
}

class UnderNormal(number: Int, name:String, radius: Double, private val cc: Int = 1000): Normal(number, name, radius)
{
    override val type = "Under Normal"
    override val size = 10000


    override fun dientichsan(): Double {
        return super.dientichsan() * cc
    }
}

fun main()
{
    val Luxury = Luxury(20, "Luxury loai 1", 1000)
    val UnderNormal = UnderNormal(233, "UnderNormal 1", 3.14)
    val normal = Normal(1000, "Normal", 3.14)

    with(Luxury) {
        println("Has luxury? ${hasRoomofHotel()}")
        println("Dien tich san la: ${dientichsan()}")
    }

    with(UnderNormal){
        println("Has Under normal: ${hasRoomofHotel()}")
        println("Under Normal dien tich san la: ${dientichsan()}")
    }

    with(normal){
        println("Has Normal? ${hasRoomofHotel()}")
        println("Dien tich san ? ${dientichsan()}")
        println("Tinh toan: ${cal()}")
    }
}


