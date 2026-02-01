fun transcribeToRna(dna: String): String {
    var rna = ""
    dna.forEach { nuc ->
        when (nuc) {
            'G' -> rna += 'C'
            'C' -> rna += 'G'
            'T' -> rna += 'A'
            'A' -> rna += 'U'
        }
    }
    return rna
}
