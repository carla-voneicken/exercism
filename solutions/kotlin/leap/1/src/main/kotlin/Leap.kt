data class Year(val year: Int) {

    val isLeap: Boolean
        get() {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        return true    
                    } else {
                        return false
                    }
                } else {
                    return true
                }
            } else {
                return false
            }
        }
}
