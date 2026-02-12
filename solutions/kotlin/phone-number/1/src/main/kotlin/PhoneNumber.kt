class PhoneNumber(input: String) {
    
    val number: String? = convertPhoneNumber(input)

    fun convertPhoneNumber(input: String): String? {
    var convertedNumber = ""

    input.forEach { char ->
        if (char.isDigit()) {
            convertedNumber = convertedNumber.plus(char)
        }
    }

    if (convertedNumber.startsWith("1")) {
        convertedNumber = convertedNumber.drop(1)
    }
    
    if (convertedNumber.length != 10) {
        throw IllegalArgumentException("Phone number must have exactly 10 digits")
    }
    if (convertedNumber[0].digitToInt() < 2 || convertedNumber[3].digitToInt() < 2) {
        throw IllegalArgumentException("Area code and exchange code cannot start with 0 or 1")
    }
    
    return convertedNumber
    
}
}
