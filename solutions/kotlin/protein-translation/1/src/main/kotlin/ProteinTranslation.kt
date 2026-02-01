fun translate(rna: String?): List<String> {
    var input = rna ?: return emptyList()
    val proteins = mutableListOf<String>()
    
    while (input.isNotEmpty()) {
        val codon = input.take(3)
        input = input.drop(3)

        when (codon) {
            "AUG" -> proteins.add("Methionine")
            "UUU", "UUC" -> proteins.add("Phenylalanine")
            "UUA", "UUG" -> proteins.add("Leucine")
            "UCU", "UCC", "UCA", "UCG" -> proteins.add("Serine")
            "UAU", "UAC" -> proteins.add("Tyrosine")
            "UGU", "UGC" -> proteins.add("Cysteine")
            "UGG" -> proteins.add("Tryptophan")
            "UAA", "UAG", "UGA" -> break
            else -> throw IllegalArgumentException("Invalid codon")
        }
    }    

    return proteins
}
