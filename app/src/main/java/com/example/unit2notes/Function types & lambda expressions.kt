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

//5. Write lambda expressions with shorthand syntax
//Lambda expressions provide a variety of ways to make your code more concise. You explore a few of them in this section because most of the lambda expressions that you encounter and write are written with shorthand syntax.
// When a function has a single parameter and you don't provide a name, Kotlin implicitly assigns it the it name, so you can omit the parameter name and -> symbol, which makes your lambda expressions more concise
fun main() {
    val coins: (Int) -> String = {
        "$it quarters"
    }

    //Pass a lambda expression directly into a function
//The coins() function is currently only used in one place. What if you could simply pass a lambda expression directly into the trickOrTreat() function without the need to first create a variable?
//
//Lambda expressions are simply function literals, just like 0 is an integer literal or "Hello" is a string literal. You can pass a lambda expression directly into a function call.

    fun main() {
        val treatFunction = trickOrTreat(false, { "$it quarters" })
        val trickFunction = trickOrTreat(true, null)
        treatFunction()
        trickFunction()
    }

//Use trailing lambda syntax
//You can use another shorthand option to write lambdas when a function type is the last parameter of a function. If so, you can place the lambda expression after the closing parenthesis to call the function.
    val treatFunction = trickOrTreat(false) { "$it quarters" }

//6. Use the repeat() function
//When a function returns a function or takes a function as an argument, it's called a higher-order function. The trickOrTreat() function is an example of a higher-order function because it takes a function of ((Int) -> String)? type as a parameter and returns a function of () -> Unit type. Kotlin provides several useful higher-order functions, which you can take advantage of with your newfound knowledge of lambdas.
//
//The repeat() function is one such higher-order function. The repeat() function is a concise way to express a for loop with functions.

    repeat(times: Int, action: (Int) -> Unit)

//The times parameter is the number of times that the action should happen. The action parameter is a function that takes a single Int parameter and returns a Unit type. The action function's Int parameter is the number of times that the action has executed so far, such as a 0 argument for the first iteration or a 1 argument for the second iteration. You can use the repeat() function to repeat code a specified number of times, similar to a for loop.

    fun main() {

        val cupcake: (Int) -> String = { "Have a cupcake!" }

        val treatFunction = trickOrTreat(false) { "$it quarters" }
        val trickFunction = trickOrTreat(true, null)
        repeat(4) {
            treatFunction()
        }
        trickFunction()
    }

//    7. Conclusion
//Congratulations! You learned the basics of function types and lambda expressions. Familiarity with these concepts helps you as you learn more about the Kotlin language. The use of function types, higher-order functions, and shorthand syntax also makes your code more concise and easier to read.
//
//Summary
//Functions in Kotlin are first-class constructs and can be treated like data types.
//Lambda expressions provide a shorthand syntax to write functions.
//You can pass function types into other functions.
//You can return a function type from another function.
//A lambda expression returns the value of the last expression.
//If a parameter label is omitted in a lambda expression with a single parameter, it's referred to with the it identifier.
//Lambdas can be written inline without a variable name.
//If a function's last parameter is a function type, you can use trailing lambda syntax to move the lambda expression after the last parenthesis when you call a function.
//Higher-order functions are functions that take other functions as parameters or return a function.
//The repeat() function is a higher-order function that works similarly to a for loop.

