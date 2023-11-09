package com.example.unit2notes

//1. Before you begin
//This codelab teaches you about nullability and the importance of null safety. Nullability is a concept commonly found in many programming languages. It refers to the ability of variables to have an absence of value. In Kotlin, nullability is intentionally treated to achieve null safety.

//In Kotlin, there's a distinction between nullable and non-nullable types:
//
//Nullable types are variables that can hold null.
//Non-null types are variables that can't hold null.
//A type is only nullable if you explicitly let it hold null. As the error message says, the String data type is a non-nullable type, so you can't reassign the variable to null.

fun main() {
    var favoriteActor: String = "Regina King"
    favoriteActor = null
}

//To declare nullable variables in Kotlin, you need to add a ? operator to the end of the type. For example, a String? type can hold either a string or null, whereas a String type can only hold a string. To declare a nullable variable, you need to explicitly add the nullable type. Without the nullable type, the Kotlin compiler infers that it's a non-nullable type.

fun main() {
    var number: Int? = 10
    println(number)

    number = null
    println(number)
}

//Kotlin intentionally applies syntactic rules so that it can achieve null safety, which refers to a guarantee that no accidental calls are made on potentially null variables. This doesn't mean that variables can't be null. It means that if a member of a variable is accessed, the variable can't be null.

//In this example, the code fails at compile time because the direct reference to the length property for the favoriteActor variable isn't allowed because there's a possibility that the variable is null.

//You can use the ?. safe call operator to access methods or properties of nullable variables.

//To use the ?. safe-call operator to access a method or property, add a ? symbol after the variable name and access the method or property with the . notation.

fun main() {
    var favoriteActor: String? = "Regina King"
    println(favoriteActor?.length)
}

//You can also use the !! not-null assertion operator to access methods or properties of nullable variables.

//After the nullable variable, you need to add the !! not-null assertion operator followed by the . operator and then the method or property without any spaces.

//As the name suggests, if you use the !! not-null assertion, it means that you assert that the value of the variable isn't null, regardless of whether it is or isn't.

//Unlike ?. safe-call operators, the use of a !! not-null assertion operator may result in a NullPointerException error being thrown if the nullable variable is indeed null. Thus, it should be done only when the variable is always non-nullable or proper exception handling is set in place.

fun main() {
    var favoriteActor: String? = "Regina King"
    println(favoriteActor!!.length)
}

//IF?ELSE Statement to check for null
//NULL check
fun main() {
    var favoriteActor: String? = "Regina King"
    if (favoriteActor != null) {
        println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    } else {
        println("You didn't input a name.")
    }
}

//IF/ELSE expression to check for null
fun main() {
    var favoriteActor: String? = "Regina King"

    val lengthOfName = if (favoriteActor != null) {
        favoriteActor.length
    } else {
        0
    }
    println("The number of characters in your favorite actor's name is $lengthOfName.")
}

///Use the ?: Elvis operator
//The ?: Elvis operator is an operator that you can use together with the ?. safe-call operator. With the ?: Elvis operator, you can add a default value when the ?. safe-call operator returns null. It's similar to an if/else expression, but in a more idiomatic way.
//
//If the variable isn't null, the expression before the ?: Elvis operator executes. If the variable is null, the expression after the ?: Elvis operator executes.

fun main() {
    var favoriteActor: String? = "Regina King"

    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}

//Summary
//A variable can be set to null to indicate that it holds no value.
//Non-nullable variables cannot be assigned null.
//Nullable variables can be assigned null.
//To access methods or properties of nullable variables, you need to use ?. safe-call operators or !! not-null assertion operators.
//You can use if/else statements with null checks to access nullable variables in non-nullable contexts.
//You can convert a nullable variable to a non-nullable type with if/else expressions.
//You can provide a default value for when a nullable variable is null with the if/else expression or the ?: Elvis operator.
