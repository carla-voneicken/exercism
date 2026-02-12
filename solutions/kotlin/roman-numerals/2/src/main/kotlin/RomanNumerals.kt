object RomanNumerals {

    fun value(n: Int): String {
        val string = n.toString().padStart(4, '0')
        val thousands = string[0].digitToInt() ?: 0
        val hundreds = string[1].digitToInt() ?: 0
        val tens = string[2].digitToInt() ?: 0 
        val ones = string[3].digitToInt() ?: 0
        
        var romanNumber = ""

        if (thousands < 4){
            repeat(thousands) {
                romanNumber += "M"
            } 
        } else { 
            return "Invalid number"
        }
        
        if (hundreds == 9) {
            romanNumber += "CM"
        } else if (hundreds > 4) {
            romanNumber += "D"
            repeat(hundreds - 5) {
                romanNumber += "C"
            }
        } else if (hundreds == 4) {
            romanNumber += "CD"
        } else {
            repeat(hundreds) {
                romanNumber += "C"
            }
        }

        if (tens == 9) {
            romanNumber += "XC"
        } else if (tens > 4) {
            romanNumber += "L"
            repeat(tens - 5) {
                romanNumber += "X"
            }
        } else if (tens == 4) {
            romanNumber += "XL"
        } else {
            repeat(tens) {
                romanNumber += "X"
            }
        }

        if (ones == 9) {
            romanNumber += "IX"
        } else if (ones > 4) {
            romanNumber += "V"
            repeat(ones - 5) {
                romanNumber += "I"
            }
        } else if (ones == 4) {
            romanNumber += "IV"
        } else {
            repeat(ones) {
                romanNumber += "I"
            }
        }
        
        return romanNumber
    }
}
