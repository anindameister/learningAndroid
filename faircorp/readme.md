# Search Kotlin PlayGround

- code
```
fun main() {
    println("Hello, world!!!")
}
```
- output
```
Hello, world!!!
```
- OldCode
```
fun main(args: Array<String>) {
    val name = "Guillaume"
    println("Hello EMSE I am $name")
}
```
- removingComplications
```
fun main() {
    val name = "Guillaume"
    println("Hello EMSE I am $name")
}
```
- output
```
Hello EMSE I am Guillaume
```
- Moving on, check out the below code
```
fun printMessage(message: String): Unit {                               // 1
    println(message)
}


fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {                                          // 3
    return x + y
}

fun multiply(x: Int, y: Int) = x * y                                    // 4

fun main() {
    printMessage("Hello")                                               // 5                    
    printMessageWithPrefix("Hello", "Log")                              // 6
    printMessageWithPrefix("Hello")                                     // 7
    printMessageWithPrefix(prefix = "Log", message = "Hello")           // 8
    println(sum(1, 2))                                                  // 9
    println(multiply(2, 4))                                             // 10
}
```
1. A simple function that takes a parameter of type String and returns Unit (i.e., no return value).
2. A function that takes a second optional parameter with default value Info. The return type is omitted, meaning that it's actually Unit.
3. A function that returns an integer.
4. A single-expression function that returns an integer (inferred).
5. Calls the first function with the argument Hello.
6. Calls the function with two parameters, passing values for both of them.
7. Calls the same function omitting the second one. **The default value Info is used.**
8. Calls the same function using named arguments and changing the order of the arguments.
9. Prints the result of the sum function call.
10. Prints the result of the multiply function call.