object EliudsEggs {

    fun eggCount(number: Int): Int{
        val binaryString = Integer.toBinaryString(number)
        var eggs = 0

        binaryString.forEach { char ->
            if(char == '1') {
                eggs++
            }
        }
        return eggs
    }
}
