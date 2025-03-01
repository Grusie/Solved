import java.util.PriorityQueue

/**
 * K일 까지는 들어온 값 그대로이면서, 마지막 값을 넣으면 된다고 함
 * PriorityQueue를 사용하면 될 것으로 예상 K 번쨰만큼만 납두고 remove하고 마지막 껄 리턴
 */

class Solution {
    fun solution(k: Int, score: IntArray): ArrayList<Int> {
        val answer: ArrayList<Int> = arrayListOf()
        val queue: PriorityQueue<Int> = PriorityQueue()

        score.forEach {
            queue.add(it)

            if(queue.size > k) queue.poll()
            answer.add(queue.peek())
        }
        return answer
    }
}