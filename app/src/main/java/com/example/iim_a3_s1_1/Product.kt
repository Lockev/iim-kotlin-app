package com.g123k.ilv

data class Product(
    val name: String,
    val brand: String,
    val nutriscore: Nutriscore,
    val barcode: String,
    val thumbnail: String,
    val quantity: String,
    val countries: List<String>,
    val ingredients: List<String>,
    val allergens: List<String>,
    val additives: List<String>,
)

enum class Nutriscore(val label: String) {
    A("A"), B("B"), C("C"), D("D"), E("E")
}

fun generateFakeProduct() = Product(
    name = "Petits pois et carottes",
    brand = "Cassegrain",
    nutriscore = Nutriscore.A,
    barcode = "3083680085304",
    thumbnail = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg\n",
    quantity = "400g",
    countries = listOf("France", "Japon", "Suisse"),
    ingredients = listOf(
        "Petits pois 66%",
        "eau",
        "garniture 2,8% (salade, oignon grelot)",
        "sucre",
        "sel",
        "arôme naturel"
    ),
    allergens = emptyList(),
    additives = emptyList(),
)