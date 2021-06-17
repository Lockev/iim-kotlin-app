fun main(args: Array<String>) {
    print(Weather1(12f, "Paris").city)

    val localWeather = LocalWeather(20f, "New York")

    // A ne pas utiliser
    val weather = object : LocalWeather(20f, "New York") {

        override fun isHot(): Boolean {
            return temp > 4
        }

    }

    // a faire
    object : Callback {
        override fun onItemClicked(position: Int) {
            TODO("Not yet implemented")
        }
    }

}

interface Callback {

    fun onItemClicked(position: Int)

}



class Weather(val temp: Float, val city: String) {

    constructor(weather: Weather): this(
        temp = weather.temp,
        city = weather.city
    )

}

open class Weather1 {

    companion object {

        private const val MIN_TEMP = 0f
        private const val MAX_TEMP = 25f

    }

    private val localCity: String
    val temp: Float

    val city: String
        get() = "Lieu : $localCity"

    constructor(temp: Float, city: String) {
        this.localCity = city
        this.temp = temp
    }

    constructor(weather: Weather): this(
        temp = weather.temp,
        city = weather.city
    )

    override fun toString(): String {
        return "Température de $localCity : $temp"
    }

    fun isCold() = temp < MIN_TEMP
    open fun isHot() = temp > MAX_TEMP
}

open class LocalWeather(localTemp: Float, localCity: String) : Weather1(localTemp, localCity) {

    companion object {
        private const val MAX_TEMP_LOCAL = 32
    }

    constructor(weather: LocalWeather): this(
        localTemp = weather.temp,
        localCity = weather.city
    )

    override fun isHot() = temp > MAX_TEMP_LOCAL

}