import kotlin.math.sqrt

/**
 * 약수의 갯수를 구한 뒤 limit과 비교하고, 그 이상이면 power를 더하면 됨
 * 약수의 갯수는 루트와 같을 때를 제외하고는 2개씩 존재
 */

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 1

        for(i in 2 .. number) {
            var divisor = 0
            val sqrt = sqrt(i.toDouble())
            for(j in 1..sqrt.toInt()) {
                if(i % j == 0){
                    divisor += if(sqrt == j.toDouble()) 1 else 2
                }
            }

            answer += if(divisor > limit) power else divisor
        }
        return answer
    }
}