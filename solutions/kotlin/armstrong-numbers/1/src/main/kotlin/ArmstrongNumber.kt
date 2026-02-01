import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        var number = input
        var digitsList: List<Int> = emptyList()
        var digits = 0
        var armstrongNumber = 0.0
    
        while (number > 0) {
            digitsList += number % 10
            number /= 10
            digits++
        }
    
        for (digit in digitsList) {
            armstrongNumber += digit.toDouble().pow(digits)
        }
    
        return input == armstrongNumber.toInt()
    }

}
