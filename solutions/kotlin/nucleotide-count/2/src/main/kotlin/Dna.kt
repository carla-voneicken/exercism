class Dna(private val dna: String) {

     init {
        require(dna.all { it in setOf('A', 'C', 'G', 'T') }) {
            "DNA can only contain nucleotides A, C, G and T"
        }
    }
    
    val nucleotideCounts: Map<Char, Int>
        get() {
            val counts = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
            
            dna.forEach { char ->                
                counts[char] = counts[char]!! + 1
            }
            return counts
        }
}
