package com.example.learnkotlin
import kotlin.math.PI
import kotlin.math.sqrt


abstract class Dwelling (private var amount: Int){
    abstract val buildingMaterial: String
    abstract val size: Int

    fun hasRoom(): Boolean {
        return amount < size
    }


    fun getRoom() {
        if (size > amount) {
            println("You got a room")
        }else {
            println("Sorry room is not available")
        }
    }

    abstract fun floorArea(): Double
}

class SquareCabin(amount: Int, private val length: Double): Dwelling(amount){
    override val buildingMaterial = "Wood"
    override val size = 6

    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(amount: Int, private val radius: Double): Dwelling(amount){
    override val buildingMaterial = "Straw"
    override val size = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun cal(): Double {
        val dimater = 2 * radius
        return sqrt(dimater*dimater/2)
    }

}

class RoundTower(amount: Int, radius: Double, private val floors: Int = 2) : RoundHut(amount, radius)
{
    override val buildingMaterial = "Stone"
    override val size = 5 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

fun main() {

    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $size")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))

    }

    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $size")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Has room? ${hasRoom()}")
        getRoom()

        println("Carpet size: ${cal()}")
    }

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Capacity: $size")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))

        println("Carpet size: ${cal()}")
    }
}


