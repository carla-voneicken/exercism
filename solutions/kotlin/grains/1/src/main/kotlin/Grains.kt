import java.math.BigInteger
import kotlin.math.pow

/* BigInteger is NOT a primitive number but a class -> it needs to be converted or constructed
    Common ways to construct a BigInteger:
        BigInteger.ZERO ->0
        BigInteger.ONE -> 1
        BigInteger.valueOf(2L) -> 2
        BigInteger("12345") -> 12345
*/

object Board {
    fun getGrainCountForSquare(number: Int): BigInteger {
        require(number in 1..64)
        // equals 2 to the power of number-1
        return BigInteger.valueOf(2L).pow(number-1)
    }

    fun getTotalGrainCount(): BigInteger {
        var totalCount = BigInteger.ZERO
        for (i in 1..64) {
            totalCount += getGrainCountForSquare(i)
        }
        return totalCount
    }
}
