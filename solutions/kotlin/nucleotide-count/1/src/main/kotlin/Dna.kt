class Dna(private val dna: String) {

     init {
        require(dna.all { it in setOf('A', 'C', 'G', 'T') }) {
            "DNA can only contain nucleotides A, C, G and T"
        }
    }
    
    val nucleotideCounts: Map<Char, Int>
        get() {
            var a = 0
            var c = 0
            var g = 0
            var t = 0
            
            dna.forEach { char ->                
                when (char) {
                    'A' -> a++
                    'C' -> c++
                    'G' -> g++
                    'T' -> t++
                }
            }
            return mapOf('A' to a, 'C' to c, 'G' to g, 'T' to t)
        }
}
