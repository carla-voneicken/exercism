object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start < 1) {
            throw IllegalArgumentException("Start must be a positive integer")
        } else if (start == 1) {
            return 0
        } else if (start % 2 == 0) {
            return computeStepCount(start / 2) + 1
        } else {
            return computeStepCount((start * 3) + 1) + 1
        }    
    }
}
