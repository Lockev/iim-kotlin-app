package com.example.iim_a3_s1_1

// 5. Methodes

// Unit = void = any
fun helloESGI(x: Int = 1) : Unit{
    println("Hello World")
}

// Alt + enter permet de réduire la methode
fun timesFive(x: Int = 1) : Int = x*5
// Single-expression functions et Unit-returning functions


fun foo(name: String, number: Int? = null, toUpperCase: Boolean? = null) : String {
    if (toUpperCase != null){
        name.toUpperCase()
    }
    return name + number.toString()
}

fun useFoo() = listOf(
    foo(name = "a"),
    foo(name = "b", number = 1),
    foo(name = "c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

fun factorielle(n: Int) : Int{
    if (n > 1){
        return n * factorielle(n-1)
    } else {
        return 1
    }
}
