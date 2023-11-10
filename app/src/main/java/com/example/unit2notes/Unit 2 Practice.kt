package com.example.unit2notes

//1. Mobile notifications
//Typically, your phone provides you with a summary of notifications.
//
//In the initial code provided in the following code snippet, write a program that prints the summary message based on the number of notifications that you received. The message should include:
//
//The exact number of notifications when there are less than 100 notifications.
//99+ as the number of notifications when there are 100 notifications or more.
//
//Complete the printNotificationSummary() function so that the program prints these lines:
//
//
//You have 51 notifications.
//Your phone is blowing up! You have 99+ notifications.
fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    // Fill in the code.
    when(numberOfMessages) {
        in 0..99 -> println("You have $numberOfMessages notifications.")
        else -> println("Yo phone is blowing up! You have 99+ notifications.")
    }
}



fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

//2. Movie tickets are typically priced differently based on the age of moviegoers.
//
//In the initial code provided in the following code snippet, write a program that calculates these age-based ticket prices:
//
//A children's ticket price of $15 for people 12 years old or younger.
//A standard ticket price of $30 for people between 13 and 60 years old. On Mondays, discount the standard ticket price to $25 for this same age group.
//A senior ticket price of $20 for people 61 years old and older. Assume that the maximum age of a moviegoer is 100 years old.
//A -1 value to indicate that the price is invalid when a user inputs an age outside of the age specifications
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Fill in the code.
    return when (age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}



fun main() {
    // Fill in the code.
    printFinalTemperature(23.0, "Celsius", "Fahrenheit") {it * (9/5) + 32}
    printFinalTemperature(345.17, "Kelvin", "Celsius") {it - 273.15}
    printFinalTemperature(43.6, "Fahrenheit", "Kelvin") {((it - 32) * (5/9) + 273.15)}
}

//There are three main temperature scales used in the world: Celsius, Fahrenheit, and Kelvin.
//
//In the initial code provided in the following code snippet, write a program that converts a temperature from one scale to another with these formulas:
//
//Celsius to Fahrenheit: ° F = 9/5 (° C) + 32
//Kelvin to Celsius: ° C = K - 273.15
//Fahrenheit to Kelvin: K = 5/9 (° F - 32) + 273.15
//Note that the String.format("%.2f", /* measurement */ ) method is used to convert a number into a String type with 2 decimal places.
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}


//imagine that you need to create a music-player app.
//
//Create a class that can represent the structure of a song. The Song class must include these code elements:
//
//Properties for the title, artist, year published, and play count
//A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
//A method that prints a song description in this format:
//"[Title], performed by [artist], was released in [year published]."
open class Song(
    val title: String,
    val artist: String,
    val year: Int,
    val playCount: Int
) {
    val popular: Boolean
        get() = playCount >= 1000

    open fun songDescription() {
        println("$title, performed by $artist, was released in $year.")
    }
}

fun main() {
    val gunna = Song("Wunna", "Gunna", 2020, 83699565)
    gunna.songDescription()
    println(gunna.popular)
}

//6. Internet profile
//Oftentimes, you're required to complete profiles for online websites that contain mandatory and non-mandatory fields. For example, you can add your personal information and link to other people who referred you to sign up for the profile.
//
//In the initial code provided in the following code snippet, write a program which prints out a person's profile details.

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        // Fill in code
        if(referrer != null) {
            println("Name: $name\nAge: $age\nLikes to $hobby. Has a referrer named ${referrer.name} who likes to ${referrer.hobby}.")
        } else {
            println("Name: $name\nAge: $age\nLikes to $hobby. Doesn't have a referrer.")
        }
    }
}

//Foldable phones
//Typically, a phone screen turns on and off when the power button is pressed. In contrast, if a foldable phone is folded, the main inner screen on a foldable phone doesn't turn on when the power button is pressed.
//
//In the initial code provided in the following code snippet, write a FoldablePhone class that inherits from the Phone class. It should contain the following:
//
//A property that indicates whether the phone is folded.
//A different switchOn() function behavior than the Phone class so that it only turns the screen on when the phone isn't folded.
//Methods to change the folding state.
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = false): Phone() {


    override fun switchOn() {
        if(!isFolded) {
            isScreenLightOn = false
        }

        fun fold() {
            isFolded = true
        }

        fun unfold() {
            isFolded = false
        }

    }
}

//Typically in an auction, the highest bidder determines the price of an item. In this special auction, if there's no bidder for an item, the item is automatically sold to the auction house at the minimum price.
//
//In the initial code provided in the following code snippet, you're given an auctionPrice() function that accepts a nullable Bid? type as an argument:

//Elvis operator
fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    // Fill in the code.
    return bid?.amount ?: minimumPrice
}

