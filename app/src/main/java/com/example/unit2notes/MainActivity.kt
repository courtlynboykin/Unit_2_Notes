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
        println("Invalid traffice-light color. Pay attention")
    }
}
