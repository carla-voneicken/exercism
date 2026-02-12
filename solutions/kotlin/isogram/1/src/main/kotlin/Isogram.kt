object Isogram {

    fun isIsogram(input: String): Boolean {
        val lowercaseInput = input.toLowerCase()
        var usedCharacters: String = ""

        lowercaseInput.forEach { char -> 
            if (usedCharacters.contains(char)) {
                return false
            }
            if (char != ' ' && char != '-') {
                usedCharacters += char
            }
        }

        return true
    }
}
