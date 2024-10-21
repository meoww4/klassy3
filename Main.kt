import kotlin.math.sqrt

data class Point(val x: Double, val y: Double) {
    fun distanceTo(other: Point): Double {
        return sqrt((other.x - this.x) * (other.x - this.x) + (other.y - this.y) * (other.y - this.y))
    }
}

fun safeInputInt(prompt: String): Int {
    while (true) {
        try {
            print(prompt)
            val input = readLine()?.toInt() ?: throw NumberFormatException()
            if (input > 2) return input else throw IllegalArgumentException("Количество точек должно быть больше двух.")
        } catch (e: Exception) {
            println("Ошибка: Введите корректное целое число больше двух.")
        }
    }
}

fun safeInputDouble(prompt: String): Double {
    while (true) {
        try {
            print(prompt)
            return readLine()?.toDouble() ?: throw NumberFormatException()
        } catch (e: NumberFormatException) {
            println("Ошибка: Введите корректное число.")
        }
    }
}

fun main() {
    val n = safeInputInt("Введите количество точек: ")

    val points = mutableListOf<Point>()

    for (i in 1..n) {
        println("Введите координаты для точки $i:")
        val x = safeInputDouble("x: ")
        val y = safeInputDouble("y: ")
        points.add(Point(x, y))
    }

    var minDistance = Double.MAX_VALUE
    var maxDistance = Double.MIN_VALUE

    for (i in 0 until points.size - 1) {
        for (j in i + 1 until points.size) {
            val distance = points[i].distanceTo(points[j])
            if (distance < minDistance) minDistance = distance
            if (distance > maxDistance) maxDistance = distance
        }
    }

    println("Минимальное расстояние между точками: $minDistance")
    println("Максимальное расстояние между точками: $maxDistance")
}
