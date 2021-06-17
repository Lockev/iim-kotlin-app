package com.example.iim_a3_s1_1

fun main(args: Array<String>) {
    val list = listOf(1,2,3,8,9)

    var total = list.sum()
    var total2 = list.sumBy { it * 2 }

    println(total)
    println(total2)

    // -------------------

    val list2 = listOf("bonjour", "le", "Monde", "je", "m'appelle", "Toto", "j'habite", "en", "Bretagne")

    println(list2.groupBy { it.first().uppercase() })

    // -------------------

    //val array = Array<Int?>(5) {1; null; 0; 42; 3; 26}
    val array = arrayOf<Int?>(1, null, 0, 42, 3, 26)
    array.filter { x: Int? -> x != null }
    // array.sortByDescending {  }()

    /*for (item in array){
        if(item != null){
            println(item)
        }
    }*/
}