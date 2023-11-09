//simple if statement
fun main() {
    val trafficLightColor = "Red"

    if(trafficLightColor == "Red"){
        println("Stop!")
    }
}

//else branch added
fun main() {
    val trafficLightColor = "Green"

    if(trafficLightColor == "Red"){
        println("Stop!")
    } else {
        println("Go!")
    }
}

//else if
//note: else if is added after "if" & does not need an "else"
fun main() {
    val trafficLightColor = "Yellow"

    if(trafficLightColor == "Red"){
        println("Stop!")
    } else if (trafficLightColor == "Yellow") {
        println("Slow!")
    } else {
        println("Go!")
    }
}

//fixed logic errors
fun main() {
    val trafficLightColor = "Black"

    if(trafficLightColor == "Red"){
        println("Stop!")
    } else if (trafficLightColor == "Yellow") {
        println("Slow!")
    } else if (trafficLightColor == "Green") {
        println("Go!")
    } else {
        println("Invalid traffic-light color. Pay attention")
    }
}

//WHEN STATEMENT
///In Kotlin, when you deal with multiple branches, you can use the when statement instead of the if/else statement because it improves readability
//WHEN statements are preferred when there are more than two branches to consider
//A when statement accepts a single value through the parameter. The value is then evaluated against each of the conditions sequentially. The corresponding body of the first condition that's met is then executed. Each condition and body are separated by an arrow (->)

fun main() {
    val trafficLightColor = "Black"

    when (trafficLightColor) {
        "Red" -> println("Stop!")
        "Yellow" -> println("Slow!")
        "Green" -> println("Go!")
        else -> println("Invalid traffic-light color. Pay attention")
    }
}

//Write more complex conditions in a when statement
//So far you learned how to write when conditions for a single equal condition, such as when the trafficLightColor variable is assigned a "Yellow" value. Next, you learn to use the comma (,), the in keyword, and the is keyword to form more complex when conditions.

fun main() {
    val x = 8

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        else -> println("x is not a prime number between 1 and 10")
    }
}

//Besides the comma (,) symbol to denote multiple conditions, you can also use the in keyword and a range of values in when branches.

//A diagram that shows the anatomy of a when statement. It starts with a when keyword followed by parentheses with a parameter block inside them. Next, inside a pair curly braces, there are two lines of cases. On the first line, there's an in keyword followed by a range start block, two dots, a range end block, an arrow symbol, and then a body block. On the second line, there's a condition block followed by an arrow symbol and a body block.

//To use a range of values, add a number that denotes the start of the range followed by two periods without any spaces and then close it with another number that denotes the end of the range.

//When the value of the parameter is equal to any value in the range between start of the range and the end of the range, the first body executes.

fun main() {
    val x = 4

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number")
        else -> println("x is not a prime number between 1 and 10")
    }
}

//you can use the is keyword as a condition to check the data type of an evaluated value.

fun main() {
    val x: Any = 88.99

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        is Int -> println("x is an integer number, but not between 1 and 10.")
        else -> println("x isn't an integer number.")
    }
}

//4. Use if/else and when as expressions
//The syntax for conditionals as expressions is similar to statements, but the last line of bodies in each branch need to return a value or an expression, and the conditionals are assigned to a variable.

//If the bodies only contain a return value or expression, you can remove the curly braces to make the code more concise.

fun main() {
    val trafficLightColor = "Black"

    val message =
        if (trafficLightColor == "Red") "Stop"
        else if (trafficLightColor == "Yellow") "Slow"
        else if (trafficLightColor == "Green") "Go"
        else "Invalid traffic-light color"

    println(message)
}

//Convert when statement to a when expression
fun main() {
    val trafficLightColor = "Amber"

    val message = when (trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message)
}


//5. Conclusion
//Summary
//In Kotlin, branching can be achieved with if/else or when conditionals.
//The body of an if branch in an if/else conditional is only executed when the boolean expression inside the if branch condition returns a true value.
//Subsequent else if branches in an if/else conditional get executed only when previous if or else if branches return false values.
//The final else branch in an if/else conditional only gets executed when all previous if or else if branches return false values.
//It's recommended to use the when conditional to replace an if/else conditional when there are more than two branches.
//You can write more complex conditions in when conditionals with the comma (,), in ranges, and the is keyword.
//if/else and when conditionals can work as either statements or expressions.

