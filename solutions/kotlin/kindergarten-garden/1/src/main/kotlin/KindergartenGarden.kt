class KindergartenGarden(private val diagram: String) {
    private val children = listOf("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")
    private val charToString = mapOf(
            'C' to "clover", 
            'G' to "grass",
            'R' to "radishes",
            'V' to "violets"
        )
    private val rows = diagram.split("\n")
    
    fun getPlantsOfStudent(student: String): List<String> {
        val index = children.indexOf(student) * 2 // because each child has two plants in a row
        return listOf(
            charToString.getValue(rows[0][index]),
            charToString.getValue(rows[0][index+1]),
            charToString.getValue(rows[1][index]),
            charToString.getValue(rows[1][index+1])
        )
    }
}
