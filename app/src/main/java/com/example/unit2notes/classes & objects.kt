package com.example.unit2notes

//1. Before you begin
//Classes provide blueprints from which objects can be constructed. An object is an instance of a class that consists of data specific to that object. You can use objects or class instances interchangeably.

//object-oriented programming (OOP), a framework that teaches you to enclose data, logic, and behavior in objects.

//OOP helps you simplify complex, real-world problems into smaller objects. There are four basic concepts of OOP, each of which you learn more about later in this codelab:

//Encapsulation. Wraps the related properties and methods that perform action on those properties in a class. For example, consider your mobile phone. It encapsulates a camera, display, memory cards, and several other hardware and software components. You don't have to worry about how components are wired internally.
//Abstraction. An extension to encapsulation. The idea is to hide the internal implementation logic as much as possible. For example, to take a photo with your mobile phone, all you need to do is open the camera app, point your phone to the scene that you want to capture, and click a button to capture the photo. You don't need to know how the camera app is built or how the camera hardware on your mobile phone actually works. In short, the internal mechanics of the camera app and how a mobile camera captures the photos are abstracted to let you perform the tasks that matter.
//Inheritance. Enables you to build a class upon the characteristics and behavior of other classes by establishing a parent-child relationship. For example, there are different manufacturers who produce a variety of mobile devices that run Android OS, but the UI for each of the devices is different. In other words, the manufacturers inherit the Android OS feature and build their customizations on top of it.
//Polymorphism. The word is an adaptation of the Greek root poly-, which means many, and -morphism, which means forms. Polymorphism is the ability to use different objects in a single, common way. For example, when you connect a Bluetooth speaker to your mobile phone, the phone only needs to know that there's a device that can play audio over Bluetooth. However, there are a variety of Bluetooth speakers that you can choose from and your phone doesn't need to know how to work with each of them specifically.


//2. Define a class
//A class definition starts with the class keyword, followed by a name and a set of curly braces. The part of the syntax before the opening curly brace is also referred to as the class header.
class SmartDevice {
    //empty body
}
fun main() {
}
//A class consists of three major parts:

//Properties. Variables that specify the attributes of the class's objects.
//Methods. Functions that contain the class's behaviors and actions.
//Constructors. A special member function that creates instances of the class throughout the program in which it's defined.

//3. Create an instance of a class

class SmartDevice {
    //empty body
}
fun main() {
    val smartTvDevice = SmartDevice()
}
//4. Define class methods
//Actions that the class can perform are defined as functions in the class. For example, imagine that you own a smart device, a smart TV, or a smart light, which you can switch on and off with your mobile phone. The smart device is translated to the SmartDevice class in programming, and the action to switch it on and off is represented by the turnOn() and turnOff() functions, which enable the on and off behavior.

//The syntax to define a function in a class is identical to what you learned before. The only difference is that the function is placed in the class body. When you define a function in the class body, it's referred to as a member function or a method, and it represents the behavior of the class.

class SmartDevice {
    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}
//Call a method on an object
class SmartDevice {
    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}
fun main() {
    val smartTvDevice = SmartDevice()
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}

//5. Define class properties
//While methods define the actions that a class can perform, the properties define the class's characteristics or data attributes.
//Properties are basically variables that are defined in the class body instead of the function body. This means that the syntax to define properties and variables are identical. You define an immutable property with the val keyword and a mutable property with the var keyword.

class SmartDevice {

    val name = "Android TV"
    val category = "Entertainment"
    val deviceStatus = "online"

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}
fun main() {
    val smartTvDevice = SmartDevice()
    println("Device name is: ${smartTvDevice.name}.")
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}

//GETTER + SETTER FUNCTIONS IN PROPERTIES
//Properties can do more than a variable can. For example, imagine that you create a class structure to represent a smart TV. One of the common actions that you perform is increase and decrease the volume. To represent this action in programming, you can create a property named speakerVolume, which holds the current volume level set on the TV speaker, but there's a range in which the value for volume resides. The minimum volume one can set is 0, while the maximum is 100. To ensure that the speakerVolume property never exceeds 100 or falls below 0, you can write a setter function. When you update the value of the property, you need to check whether the value is in the range of 0 to 100. As another example, imagine that there's a requirement to ensure that the name is always in uppercase. You can implement a getter function to convert the name property to uppercase.
//
//Before going deeper into how to implement these properties, you need to understand the full syntax to declare them. The full syntax to define a mutable property starts with the variable definition followed by the optional get() and set() functions.

//When you don't define the getter and setter function for a property, the Kotlin compiler internally creates the functions. For example, if use the var keyword to define a speakerVolume property and assign it a 2 value, the compiler autogenerates the getter and setter functions as you can see in this code snippet:
var speakerVolume = 2
    get() = field
    set(value) {
        field = value
    }
//You won't see these lines in your code because they're added by the compiler in the background.
//
//The full syntax for an immutable property has two differences:
//
//It starts with the val keyword.
//The variables of val type are read-only variables, so they don't have set() functions.
//Kotlin properties use a backing field to hold a value in memory. A backing field is basically a class variable defined internally in the properties. A backing field is scoped to a property, which means that you can only access it through the get() or set() property functions.
//
//To read the property value in the get() function or update the value in the set() function, you need to use the property's backing field. It's autogenerated by the Kotlin compiler and referenced with a field identifier.
//
//For example, when you want to update the property's value in the set() function, you use the set() function's parameter, which is referred to as the value parameter, and assign it to the field variable as you can see in this code snippet:

var speakerVolume = 2
    set(value) {
        field = value
    }

//Warning: Don't use the property name to get or set a value. For example, in the set() function, if you try to assign the value parameter to the speakerVolume property itself, the code enters an endless loop because the Kotlin runtime tries to update the value for the speakerVolume property, which triggers a call to the setter function repeatedly.
//For example, to ensure that the value assigned to the speakerVolume property is in the range of 0 to 100, you could implement the setter function as you can see in this code snippet:
var speakerVolume = 2
    set(value) {
        if (value in 0..100) {
            field = value
        }
    }

//6. Define a constructor
//The primary purpose of the constructor is to specify how the objects of the class are created. In other words, constructors initialize an object and make the object ready for use. You did this when you instantiated the object. The code inside the constructor executes when the object of the class is instantiated. You can define a constructor with or without parameters.

///There are two main types of constructors in Kotlin:
//
//Primary constructor. A class can have only one primary constructor, which is defined as part of the class header. A primary constructor can be a default or parameterized constructor. The primary constructor doesn't have a body. That means that it can't contain any code.
//Secondary constructor. A class can have multiple secondary constructors. You can define the secondary constructor with or without parameters. The secondary constructor can initialize the class and has a body, which can contain initialization logic. If the class has a primary constructor, each secondary constructor needs to initialize the primary constructor.

class SmartDevice(val name: String, val category: String) { //primary constructor
    var deviceStatus = "online"

    /*secondary constructor*/ constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
    ...
}

//7. Implement a relationship between classes
//Inheritance lets you build a class upon the characteristics and behavior of another class. It's a powerful mechanism that helps you write reusable code and establish relationships between classes.

//In programming terms, we say that the SmartTvDevice and SmartLightDevice classes extend the SmartDevice parent class. The parent class is also referred to as a superclass and the child class as a subclass.

//However, in Kotlin, all the classes are final by default, which means that you can't extend them, so you have to define the relationships between them.
//The open keyword informs the compiler that this class is extendable, so now other classes can extend it.
//
//The syntax to create a subclass starts with the creation of the class header as you've done so far. The constructor's closing parenthesis is followed by a space, a colon, another space, the superclass name, and a set of parentheses. If necessary, the parentheses include the parameters required by the superclass constructor.

open class SmartDevice(val name: String, val category: String) {

    val deviceStatus = "online"

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory){
    val speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    val channelNumber = 1
        set(value) {
            if(value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    val brightnessLevel = 0
        set(value) {
            if(value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
}

fun main() {
    val smartTvDevice = SmartDevice()
    println("Device name is: ${smartTvDevice.name}.")
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}

//Relationships
//IS-A relationships
//When you specify an IS-A relationship between the SmartDevice superclass and SmartTvDevice subclass, it means that whatever the SmartDevice superclass can do, the SmartTvDevice subclass can do. The relationship is unidirectional, so you can say that every smart TV is a smart device, but you can't say that every smart device is a smart TV. The code representation for an IS-A relationship is shown in this code snippet:
//
//
//// Smart TV IS-A smart device.
class SmartTvDevice : SmartDevice() {
}
//Don't use inheritance only to achieve code reusability. Before you decide, check whether the two classes are related to each other. If they exhibit some relationship, check whether they really qualify for the IS-A relationship. Ask yourself, "Can I say a subclass is a superclass?". For example, Android is an operating system.
//
//HAS-A relationships
//A HAS-A relationship is another way to specify the relationship between two classes. For example, you will probably use the smart TV in your home. In this case, there's a relationship between the smart TV and the home. The home contains a smart device or, in other words, the home has a smart device. The HAS-A relationship between two classes is also referred to as composition.
//
//So far, you created a couple of smart devices. Now, you create the SmartHome class, which contains smart devices. The SmartHome class lets you interact with the smart devices.

open class SmartDevice(val name: String, val category: String) {

    val deviceStatus = "online"

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory){
    val speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    val channelNumber = 1
        set(value) {
            if(value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    val brightnessLevel = 0
        set(value) {
            if(value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
}

class SmartHome(
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice : SmartLightDevice
) {
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

fun main() {
    val smartTvDevice = SmartDevice()
    println("Device name is: ${smartTvDevice.name}.")
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}


//Override superclass methods from subclasses
// To override means to intercept the action, typically to take manual control. When you override a method, the method in the subclass interrupts the execution of the method defined in the superclass and provides its own execution.
//The override keyword informs the Kotlin runtime to execute the code enclosed in the method defined in the subclass.


//Reuse superclass code in subclasses with the super keyword
//
//To call the overridden method in the superclass from teh subclass, you need to use the super keyword. Calling a method from the superclass is similar to calling the method from outside the class. Instead of using a . operator between the object and method, you need to use the super keyword, which informs the Kotlin compiler to call the method on the superclass instead of the subclass.
//
//The syntax to call the method from the superclass starts with a super keyword followed by the . operator, function name, and a set of parentheses. If applicable, the parentheses include the arguments.
class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    var brightnessLevel = 0
        set(value) {
            if(value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}


//8. Visibility modifiers
//Visibility modifiers play an important role to achieve encapsulation:
//
//In a class, they let you hide your properties and methods from unauthorized access outside the class.
//In a package, they let you hide the classes and interfaces from unauthorized access outside the package.
//Kotlin provides four visibility modifiers:
//
//public. Default visibility modifier. Makes the declaration accessible everywhere. The properties and methods that you want used outside the class are marked as public.
//private. Makes the declaration accessible in the same class or source file.
//There are likely some properties and methods that are only used inside the class, and that you don't necessarily want other classes to use. These properties and methods can be marked with the private visibility modifier to ensure that another class can't accidentally access them.
//
//protected. Makes the declaration accessible in subclasses. The properties and methods that you want used in the class that defines them and the subclasses are marked with the protected visibility modifier.
//internal. Makes the declaration accessible in the same module. The internal modifier is similar to private, but you can access internal properties and methods from outside the class as long as it's being accessed in the same module.

//Ideally, you should strive for strict visibility of properties and methods, so declare them with the private modifier as often as possible. If you can't keep them private, use the protected modifier. If you can't keep them protected, use the internal modifier. If you can't keep them internal, use the public modifier.


//9. Define property delegates


//FINAL CODE
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}