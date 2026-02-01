object Darts {

    fun score(x: Number, y: Number): Int {

        val dx = x.toDouble()
        val dy = y.toDouble()
        val square = dx*dx + dy*dy    

        return when {
            square <= 1.0 -> 10
            square <= 25.0 -> 5
            square <= 100.0 -> 1
            else -> 0
        }
    }
}
