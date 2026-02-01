import kotlin.math.ceil
data class Rectangle(val columns: Int, val rows: Int)

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val trimmedPlaintext = plaintext.lowercase().filter { it in 'a'..'z' || it in '0'..'9' }
    
        if (trimmedPlaintext.isEmpty())  {
            return ""
        }
        
        val rectangle: Rectangle = getRectangle(trimmedPlaintext.length.toDouble())
        
        val chunkedText = trimmedPlaintext.chunked(rectangle.columns)
        var turnedChunks: List<String> = emptyList()
        for (row in (1 .. rectangle.columns)) {
            turnedChunks += getCipherChunks(chunkedText, row)
        }

        return turnedChunks.joinToString(" ")
    }
    
    fun getRectangle(length: Double): Rectangle {
        var rows: Double = length
        var columns = 1.0
        var conditionMet: Boolean = checkCondition(rows, columns, length)
    
        while (!conditionMet) {
            columns++
            rows = ceil(length / columns)
            conditionMet = checkCondition(rows, columns, length)
        }
    
        return Rectangle(columns.toInt(), rows.toInt())
    }

    fun checkCondition(rows: Double, columns: Double, length: Double): Boolean {
        val condition1 = rows * columns >= length 
        val condition2 = columns >= rows 
        val condition3 = columns - rows <= 1
        return condition1 && condition2 && condition3
    }


    fun getCipherChunks(chunks: List<String>, index: Int): String {
        var string = ""
        for (chunk in chunks) {
            if (chunk.length <= index-1) {
                string += " "
            } else {
                string += chunk[index-1]
            }
        }
        return string
    }
}
