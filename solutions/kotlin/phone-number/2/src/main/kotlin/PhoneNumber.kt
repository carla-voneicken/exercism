class PhoneNumber(input: String) {
    val number: String = input.filter { it.isDigit() }
        .removePrefix("1")
        .also { cleaned ->
            require(cleaned.length == 10) { 
                "Phone number must have exactly 10 digits" 
            }
            require(cleaned[0].digitToInt() >= 2) { 
                "Area code cannot start with 0 or 1" 
            }
            require(cleaned[3].digitToInt() >= 2) { 
                "Exchange code cannot start with 0 or 1" 
            }
        }
}
