/**
 * 제일 높은 숫자끼리 m개 만큼씩 담아서 처리한다고 생각하면 될 듯
 * score를 sorting해서 m개씩 뽑아서 최소 값이랑 비교해서 m과 곱해서 결론 내면 됨
 */

class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        val sortedScore = score.sorted().toMutableList()

        var min = Int.MAX_VALUE
        while (sortedScore.size >= m) {
            repeat(m) {
                min = minOf(min, sortedScore.removeAt(sortedScore.lastIndex))
            }

            answer+=(min * m)
            min = Int.MAX_VALUE
        }

        return answer
    }
}