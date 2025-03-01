/**
 * 구현으로 생각하고 주어진 문장대로 구현해보자
 * 현재 index, 같은 갯수 다른갯수 변수 하나씩
 * 같아질 때 +1 or 같지 않은데, 마지막 일 때 +1
 */

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var currentItem:Char = s[0]
        var (sameCount, diffCount) = Pair(0,0)

        s.forEachIndexed { index, it ->
            if(sameCount == 0 && diffCount == 0) currentItem = it

            if(currentItem == it ) sameCount++ else diffCount++
            if(sameCount == diffCount) {
                answer++
                sameCount = 0
                diffCount = 0
            } else if(index == s.length - 1) {
                answer++
            }
        }

        return answer
    }
}