class Allergies(private val storedScore: Int) {
    
    fun getList(): List<Allergen> {
        val allergensList = mutableListOf<Allergen>()

        Allergen.values().forEach { allergen ->
            if (isAllergicTo(allergen)) {
                allergensList.add(allergen)
            }
        }

        return allergensList
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        /* Bitwise AND compares bits pairwise:
        for each bit position it compares the bit in the first value and the second value and then sets that bit in the result like this:
        - 1 and 1 = 1
        - 1 and 0 = 0
        - 0 and 1 = 0
        - 0 and 0 = 0
        value1.and(value2) is a bitwise operation -> is the bit of value2 set in value1
        Example:
                     34 = 100010
                      2 = 000010
             34.and(2) -> 000010 = 2
                     34 = 100010
                     32 = 100000
            34.and(32) -> 100000 = 32
                     34 = 100010
                     1. = 000001
             34.and(1) -> 000000 = 0
        */
        return storedScore.and(allergen.score) != 0
    }
}

/*enum class Allergen(val score: Int) {
    EGGS(1),
    PEANUTS(2),
    SHELLFISH(4),
    STRAWBERRIES(8),
    TOMATOES(16),
    CHOCOLATE(32),
    POLLEN(64),
    CATS(128)
}*/
