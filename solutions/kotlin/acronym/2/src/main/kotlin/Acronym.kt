object Acronym {
    fun generate(phrase: String) : String {
        var acronym: String = ""
        var splitPhrase = phrase.split("-", " ", "_")
        
        for (word in splitPhrase){
            if (word != "") {
                acronym += word[0].uppercaseChar()
            }
        }
        return acronym
    }
}
