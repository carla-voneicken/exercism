object RomanNumerals {

    fun value(n: Int): String {
        val string = n.toString().padStart(4, '0')
        val thousands = string[0].digitToInt() ?: 0
        val hundreds = string[1].digitToInt() ?: 0
        val tens = string[2].digitToInt() ?: 0 
        val ones = string[3].digitToInt() ?: 0
        
        var romanNumber = ""
        
        romanNumber += when(thousands) {
            3 -> "MMM"
            2 -> "MM"
            1 -> "M"
            else -> ""
        }
        
        romanNumber += when(hundreds) {
            9 -> "CM"
            8 -> "DCCC"
            7 -> "DCC"
            6 -> "DC"
            5 -> "D"
            4 -> "CD"
            3 -> "CCC"
            2 -> "CC"
            1 -> "C"
            else -> ""
        }
        
        romanNumber += when(tens) {
            9 -> "XC"
            8 -> "LXXX"
            7 -> "LXX"
            6 -> "LX"
            5 -> "L"
            4 -> "XL"
            3 -> "XXX"
            2 -> "XX"
            1 -> "X"
            else -> ""
        }
        
        romanNumber += when(ones) {
            9 -> "IX"
            8 -> "VIII"
            7 -> "VII"
            6 -> "VI"
            5 -> "V"
            4 -> "IV"
            3 -> "III"
            2 -> "II"
            1 -> "I"
            else -> ""
        }
        return romanNumber
    }
}
