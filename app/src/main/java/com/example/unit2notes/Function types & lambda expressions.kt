package com.example.unit2notes
//3. Store a function in a variable
//So far, you learned how to declare functions with the fun keyword. A function declared with the fun keyword can be called, which causes the code in the function body to execute.
//
//As a first-class construct, functions are also data types, so you can store functions in variables, pass them to functions, and return them from functions. Perhaps you want the ability to change the behavior of a piece of your app at runtime or nest composable functions to build layouts like you did in previous codelabs. All this is made possible by lambda expressions.
//With lambda expressions, you can create variables that store functions, call these variables like functions, and store them in other variables that you can call like functions.

fun main() {
    val trickFunction = trick
    trick()
    trickFunction()
}

val trick = { //setting function = to a variable
    println("No treats!")
}

//4. Use functions as a data type
//You learned in a previous codelab that Kotlin has type inference. When you declare a variable, you often don't need to explicitly specify the type. In the previous example, the Kotlin compiler was able to infer that the value of trick was a function. However, if you want to specify the type of a function parameter or a return type, you need to know the syntax for expressing function types. Function types consist of a set of parentheses that contain an optional parameter list, the -> symbol, and a return type.

//The data type of the trick variable that you declared earlier would be () -> Unit. The parentheses are empty because the function doesn't have any parameters. The return type is Unit because the function doesn't return anything. If you had a function that took two Int parameters and returned an Int, its data type would be (Int, Int) -> Int.
//Use a function as a return type
//A function is a data type, so you can use it like any other data type. You can even return functions from other functions.
fun main() {
    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if(isTrick) {
        return trick
    } else {
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}

//Pass a function to another function as an argument
//In some parts of the world that celebrate Halloween, children receive spare change instead of candy or they receive both. You'll modify your trickOrTreat() function to allow an additional treat represented by a function to be provided as an argument.
//
//The function that trickOrTreat() uses as a parameter also needs to take a parameter of its own. When declaring function types, the parameters aren't labeled. You only need to specify the data types of each parameter, separated by a comma. =
//When you write a lambda expression for a function that takes a parameter, the parameters are given names in the order that they occur. Parameter names are listed after the opening curly braces and each name is separated by a comma.

fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = { "Have a cupcake!" }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if(isTrick) {
        return trick
    } else {
        println(extraTreat(5))
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}

///Nullable function types
//Like other data types, function types can be declared as nullable. In these cases, a variable could contain a function or it could be null.
//
//To declare a function as nullable, surround the function type in parentheses followed by a ? symbol outside the ending parenthesis. For example, if you want to make the () -> String type nullable, declare it as a (() -> String)? type.

fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = { "Have a cupcake!" }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if(isTrick) {
        return trick
    } else {
        if(extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}