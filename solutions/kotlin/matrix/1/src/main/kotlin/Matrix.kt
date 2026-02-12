class Matrix(private val matrixAsString: String) {
    // convert matrixAsString into a two dimensional list of integers
    private val rows: List<List<Int>> = matrixAsString
    // split into a list of row strings
        .split("\n")
        // split each row into a list of substrings
        .map { rowString ->
    		rowString
                .split(" ")
                // convert all substrings to integers
                .map { it.toInt() }
    	}
    
    fun column(colNr: Int): List<Int> {
        // map over the rows an always just take the item with the right index
        return rows.map { row ->
        	row[colNr - 1]
        }
    }

    fun row(rowNr: Int): List<Int> {
        // return the row with the correct index
        return rows[rowNr - 1]
    }
}
