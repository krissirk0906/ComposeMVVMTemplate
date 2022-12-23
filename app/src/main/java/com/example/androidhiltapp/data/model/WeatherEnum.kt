package com.example.androidhiltapp.data.model

data class Weather(
    val location: Location? = null,
    val current: Current? = null,
    val forecast: Forecast? = null
)

data class Current(
    val lastUpdatedEpoch: Long? = null,
    val lastUpdated: String? = null,
    val tempC: Long? = null,
    val tempF: Long? = null,
    val isDay: Long? = null,
    val condition: Condition? = null,
    val windMph: Double? = null,
    val windKph: Long? = null,
    val windDegree: Long? = null,
    val windDir: String? = null,
    val pressureMB: Long? = null,
    val pressureIn: Double? = null,
    val precipMm: Long? = null,
    val precipIn: Long? = null,
    val humidity: Long? = null,
    val cloud: Long? = null,
    val feelslikeC: Double? = null,
    val feelslikeF: Double? = null,
    val visKM: Long? = null,
    val visMiles: Long? = null,
    val uv: Long? = null,
    val gustMph: Double? = null,
    val gustKph: Long? = null
)

data class Condition(
    val text: Text? = null,
    val icon: Icon? = null,
    val code: Long? = null
)

enum class Icon {
    CDNWeatherapiCOMWeather64X64Day113PNG,
    CDNWeatherapiCOMWeather64X64Day116PNG,
    CDNWeatherapiCOMWeather64X64Night113PNG,
    CDNWeatherapiCOMWeather64X64Night116PNG,
    CDNWeatherapiCOMWeather64X64Night176PNG
}

enum class Text {
    Clear,
    PartlyCloudy,
    PatchyRainPossible,
    Sunny
}

data class Forecast(
    val forecastday: List<Forecastday>? = null
)

data class Forecastday(
    val date: String? = null,
    val dateEpoch: Long? = null,
    val day: Day? = null,
    val astro: Astro? = null,
    val hour: List<Hour>? = null
)

data class Astro(
    val sunrise: String? = null,
    val sunset: String? = null,
    val moonrise: String? = null,
    val moonset: String? = null,
    val moonPhase: String? = null,
    val moonIllumination: String? = null
)

data class Day(
    val maxtempC: Double? = null,
    val maxtempF: Double? = null,
    val mintempC: Double? = null,
    val mintempF: Double? = null,
    val avgtempC: Double? = null,
    val avgtempF: Double? = null,
    val maxwindMph: Double? = null,
    val maxwindKph: Double? = null,
    val totalprecipMm: Double? = null,
    val totalprecipIn: Long? = null,
    val totalsnowCM: Long? = null,
    val avgvisKM: Long? = null,
    val avgvisMiles: Long? = null,
    val avghumidity: Long? = null,
    val dailyWillItRain: Long? = null,
    val dailyChanceOfRain: Long? = null,
    val dailyWillItSnow: Long? = null,
    val dailyChanceOfSnow: Long? = null,
    val condition: Condition? = null,
    val uv: Long? = null
)

data class Hour(
    val timeEpoch: Long? = null,
    val time: String? = null,
    val tempC: Double? = null,
    val tempF: Double? = null,
    val isDay: Long? = null,
    val condition: Condition? = null,
    val windMph: Double? = null,
    val windKph: Double? = null,
    val windDegree: Long? = null,
    val windDir: String? = null,
    val pressureMB: Long? = null,
    val pressureIn: Double? = null,
    val precipMm: Double? = null,
    val precipIn: Long? = null,
    val humidity: Long? = null,
    val cloud: Long? = null,
    val feelslikeC: Double? = null,
    val feelslikeF: Double? = null,
    val windchillC: Double? = null,
    val windchillF: Double? = null,
    val heatindexC: Double? = null,
    val heatindexF: Double? = null,
    val dewpointC: Double? = null,
    val dewpointF: Double? = null,
    val willItRain: Long? = null,
    val chanceOfRain: Long? = null,
    val willItSnow: Long? = null,
    val chanceOfSnow: Long? = null,
    val visKM: Long? = null,
    val visMiles: Long? = null,
    val gustMph: Double? = null,
    val gustKph: Double? = null,
    val uv: Long? = null
)

data class Location(
    val name: String? = null,
    val region: String? = null,
    val country: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    val tzID: String? = null,
    val localtimeEpoch: Long? = null,
    val localtime: String? = null
)
