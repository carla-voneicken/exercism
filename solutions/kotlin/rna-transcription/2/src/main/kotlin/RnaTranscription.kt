fun transcribeToRna(dna: String): String =
    dna.map { nuc ->
        when (nuc) {
            'G' -> 'C'
            'C' -> 'G'
            'T' -> 'A'
            'A' -> 'U'
            else -> throw IllegalArgumentException("Invalid nucleotide")
        }
    }.joinToString("")
