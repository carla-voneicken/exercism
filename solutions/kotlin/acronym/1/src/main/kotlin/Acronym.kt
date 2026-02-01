object Acronym {
    fun generate(phrase: String) : String {
        var acronym: String = ""
        var splitPhrase = phrase.split("-", " ")
        
        for (word in splitPhrase){
            var trimmedWord = word.replace("_", "")
            trimmedWord = trimmedWord.replace(",", "")
            trimmedWord = trimmedWord.replace(".", "")
            
            if (trimmedWord != "") {
                acronym += trimmedWord[0].uppercaseChar()
            }
        }
        return acronym
    }
}
