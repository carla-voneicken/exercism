object Bob {
    fun hey(input: String): String {

        val s = input.trim()
        var containsLetter: Boolean = s.any { it.isLetter() }           
        var isQuestion: Boolean = s.takeLast(1) == "?"
        var isShouting: Boolean = s.toUpperCase() == s && containsLetter

        if(s == "") {
            return "Fine. Be that way!"
        } else if (isQuestion) {
            if (isShouting) {
                return "Calm down, I know what I'm doing!"
            } else {
                return "Sure."
            }
        } else if (isShouting) {
            return "Whoa, chill out!"
        } else {
            return "Whatever."
        }
    }
}
