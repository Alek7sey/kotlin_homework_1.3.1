fun main() {
    println(agoToText(30))
    println(agoToText(69))
    println(agoToText(359))
    println(agoToText(1330))
    println(agoToText(3601))
    println(agoToText(7200))
    println(agoToText(19000))
    println(agoToText(191000))
    println(agoToText(1910000))
}

fun agoToText(seconds: Int): String {
    val time = when (seconds) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> {
            val minutes = secondsToMinutes(seconds)
            "$minutes назад"
        }

        in 60 * 60 + 1..24 * 60 * 60 -> {
            val hours = secondsToHours(seconds)
            "$hours назад"
        }

        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "вчера"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
    return "был(а) в сети $time"
}

fun secondsToMinutes(seconds: Int): String {
    val minutes = (seconds / 60)
    val result = when (minutes % 10) {
        1 -> "$minutes минуту"
        in 2..4 -> "$minutes минуты"
        else -> "$minutes минут"
    }
    return result
}

fun secondsToHours(seconds: Int): String {
    val hours = seconds / (60 * 60)
    val result = when (hours % 10) {
        1 -> "$hours час"
        in 2..4 -> "$hours часа"
        else -> "$hours часов"
    }
    return result
}