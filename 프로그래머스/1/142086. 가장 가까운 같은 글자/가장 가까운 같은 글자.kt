/**
 * 같은 사이즈의 -1로 초기값을 가진 배열을 마련해두고
 * Map 을 가지고 각 아이템의 마지막 위치를 저장해서 문자열을 돌면서 현재 위치와 비교
 */

class Solution {
    fun solution(s: String): Array<Int> {
        var answer = Array(s.length){-1}
        val map: MutableMap<Char, Int> = mutableMapOf()

        s.forEachIndexed { index, c ->
            val prevIndex = map.getOrDefault(c, -1)

            if(prevIndex != -1) {
                answer[index] = index - prevIndex
            }

            map[c] = index
        }
        return answer
    }
}