class ZebraPuzzle() {

    private val houses: List<House> by lazy {
        solvePuzzle().single().toHouses()
    }


    fun drinksWater(): String = houses.first { it.drink == Drink.WATER }.nation.displayName
  
    fun ownsZebra(): String = houses.first { it.pet == Pet.ZEBRA }.nation.displayName
       
    fun solvePuzzle(): List<State> {
        
        val colorPermutations = permutations(Color.values().toList())
        val validColorPermutations = colorPermutations.filter { colors ->
            val green = colors.indexOf(Color.GREEN)
            val ivory = colors.indexOf(Color.IVORY)
            // # 6: The green house is immediately to the right of the ivory house
            green == ivory + 1
        }

        val drinkPermutations = permutations(Drink.values().toList())
        val validDrinkPermutations = drinkPermutations.filter { drink ->
            // # 9: The person in the middle house drinks milk
            drink.indexOf(Drink.MILK) == 2
        }

        val nationalityPermutations = permutations(Nation.values().toList())
        val validNationalityPermutations = nationalityPermutations.filter { nation ->
            // # 10: The Norwegian lives in the first house
            nation.indexOf(Nation.NORWEGIAN) == 0
        }

        /* .flatMap produces a list for each element and then flattens those lists into one big list
            e.g. listOf(1,2).flatMap{ n -> listOf(n, n*10)} 
            result: [1, 10, 2, 20]

            .map transforms each element of a list into something else
            e.g. listOf(1, 2).map { n -> listOf(n, n*10)}
            result: [[1,10], [2, 20]]

            Here: 
            - get the valid color permutations we have so far
            - get the valid nationality permutations we have so far
            - filter the nationality permutations so that they conform to two conditions:
                1. index of the Englishman must be the same as index of reified
                2. index of the Norwegian must be next to (so + or - 1) of index of Blue
            - map the filteres nationality permutations to the color permutations -> 
            if filter list contained: [nations1, nations2], the result would be: 
                    [(colors, nations1), (colors, nations2)]
            - flatten those lists into one: [colors, nations1, colors, nations2]

            Example: 
            - colors1 produces 3 valid nation assignments
            - colors2 produces 1
            - colors3 produces 0
            Result:
            [(c1,n1), (c1,n2), (c1,n3),(c2,n4)]
        */
        
        val colorNationPairs: List<State> = validColorPermutations.flatMap { colors ->
                validNationalityPermutations
                .filter { nations ->
                    // # 2: The Englishman lives in the red house
                    nations.indexOf(Nation.ENGLISHMAN) == colors.indexOf(Color.RED) &&
                    // # 15: The Norwegian lives next to the blue house
                    isNextTo(nations.indexOf(Nation.NORWEGIAN), colors.indexOf(Color.BLUE))
                }
                .map { nations -> State(colors = colors, nations = nations) }
            }

        val colorDrinkNationState: List<State> = colorNationPairs.flatMap { state ->
            val colors = state.colors
            val nations = state.nations
            
            validDrinkPermutations
                .filter { drinks ->
                    // # 4: The person in the green house drinks coffee
                    drinks.indexOf(Drink.COFFEE) == colors.indexOf(Color.GREEN) &&
                    // # 5: The Ukrainian drinks tea
                    drinks.indexOf(Drink.TEA) == nations.indexOf(Nation.UKRAINIAN)
                }
                .map { drinks -> State(colors = colors, nations = nations, drinks = drinks) }
        }

        val petPermutations = permutations(Pet.values().toList())
        val colorDrinkNationPetState = colorDrinkNationState.flatMap { state ->
            val colors = state.colors
            val nations = state.nations
            val drinks = state.drinks
            
            petPermutations
                .filter { pets ->
                    // # 3: The Spaniard owns the dog
                    pets.indexOf(Pet.DOG) == nations.indexOf(Nation.SPANIARD)
                }
                .map { pets -> State(colors = colors, nations = nations, drinks = drinks, pets = pets) }
        }

        val hobbyPermutations = permutations(Hobby.values().toList())
        val colorDrinkNationPetHobbyState = colorDrinkNationPetState.flatMap { state ->
            val colors = state.colors
            val nations = state.nations
            val drinks = requireNotNull(state.drinks)
			val pets = requireNotNull(state.pets)

            hobbyPermutations 
                .filter { hobbies ->
                    // # 7: The snail owner likes to go dancing
                    hobbies.indexOf(Hobby.DANCING) == pets.indexOf(Pet.SNAILS) &&
                    // # 8: The person in the yellow house is a painter
                    hobbies.indexOf(Hobby.PAINTING) == colors.indexOf(Color.YELLOW) &&
                    // # 11: The person who enjoys reading lives in the house next to the person with the fox
                    isNextTo(hobbies.indexOf(Hobby.READING), pets.indexOf(Pet.FOX)) &&
                    // # 12: The painter's house is next to the house with the horse
                    isNextTo(hobbies.indexOf(Hobby.PAINTING), pets.indexOf(Pet.HORSE)) &&
                    // # 13: The person who plays football drinks orange juice
                    hobbies.indexOf(Hobby.FOOTBALL) == drinks.indexOf(Drink.ORANGE_JUICE) &&
                    // # 14: The Japanese person plays chess
                    hobbies.indexOf(Hobby.CHESS) == nations.indexOf(Nation.JAPANESE)
                }
                .map { hobbies -> State(colors, nations, drinks, pets, hobbies) }
        }
		
        return colorDrinkNationPetHobbyState   
    }

    // Checks if an index a is next to an index b
    fun isNextTo(a: Int, b: Int) = a - b == 1 || a - b == -1

    // Gets all permutations (different orders) for a list of items (120 lists for 5 different items)
    fun <T> permutations(items: List<T>): List<List<T>> {
        if (items.size == 1) return listOf(items)
    
        val result = mutableListOf<List<T>>()
    
        for (i in items.indices) {
            val current = items[i]
            val remaining = items.take(i) + items.drop(i + 1)
    
            for (perm in permutations(remaining)) {
                result.add(listOf(current) + perm)
            }
        }
        return result
    }

    // Maps a single state (containing the correctly ordered lists of colors, nations, drinks, pets and hobbies) into a list of five houses
    fun State.toHouses(): List<House> {
        return colors.indices.map { i ->
            House(
                position = i + 1,
                color = colors[i],
                nation = nations[i],
                drink = drinks!![i],
                pet = pets!![i],
                hobby = hobbies!![i]
            )
        }
    }
}

enum class Color { RED, GREEN, IVORY, YELLOW, BLUE }
enum class Nation(val displayName: String) { 
    ENGLISHMAN("Englishman"), 
    SPANIARD("Spaniard"), 
    UKRAINIAN("Ukrainian"), 
    NORWEGIAN("Norwegian"), 
    JAPANESE("Japanese") 
}
enum class Drink { COFFEE, TEA, MILK, ORANGE_JUICE, WATER }
enum class Pet { DOG, SNAILS, FOX, HORSE, ZEBRA }
enum class Hobby { DANCING, PAINTING, READING, FOOTBALL, CHESS }

data class State(
    val colors: List<Color>,
    val nations: List<Nation>,
    val drinks: List<Drink>? = null,
    val pets: List<Pet>? = null,
    val hobbies: List<Hobby>? = null
)

data class House(
    val position: Int,
    val color: Color,
    val nation: Nation,
    val drink: Drink,
    val pet: Pet,
    val hobby: Hobby
)