object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        var multiples = mutableListOf<Int>()
    
        factors.forEach { factor ->
            if (factor == 0) return@forEach
            var multiplier = 1
    
            while ((factor * multiplier) < limit) {
                multiples.add((factor * multiplier))
                multiplier++
            }
        }
    
        return multiples.distinct().sum()
    }
}
