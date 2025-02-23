import kotlin.math.ceil

/**
 * 택배상자 n위에 있는 것들을 삭제하면 되니까,
 * 택배상자 위에 몇 개가 있는지를 판단 -> 전체 줄 수를 구해서 현재 주어진 숫자가 몇 번째 줄에 있는지 판단
 * 이 때, 맨 위 상자가 해당 라인의 위에 있는지 아닌지도 판단해야함
 */

class Solution() {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 0
        val maxHeight = ceil(n.toFloat() / w).toInt()
        val array = Array(maxHeight) { Array<Int>(w) {0} }
        var number = 1
        var target :Pair<Int,Int> = Pair(0, 0)
        var last :Pair<Int,Int> = Pair(0, 0)

        for(i in 0 until maxHeight) {
            for(j in 0 until w) {
                val y = i
                val x = if(i % 2 == 0) j else w - j - 1

                array[y][x] = number
                if(number == num) {
                    target = Pair(y, x)
                }
                if(number == n) {
                    last = Pair(y, x)
                    break
                }
                number++
            }
        }

        answer = last.first - target.first
        if(maxHeight % 2 == 1) {
            if(last.second >= target.second) answer+=1
        } else {
            if(last.second <= target.second) answer+=1
        }

        return answer
    }
}