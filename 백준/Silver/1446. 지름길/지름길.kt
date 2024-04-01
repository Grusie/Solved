package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 일정 거리를 갈 수 있는 방법들 중 최소값을 그 배열에 저장 해가며, 목적지에 다달았을 때 종료하면 될 것 같다.
 *          D만큼의 배열을 만들고, 갈 수 있는 방법들
 *           1. 그냥 간다.
 *           2. 거쳐 거쳐 간다.(이전 DP값들을 더함)
 *           3. 거쳐 간 뒤 그냥 간다. (이전 DP값과 현재에서 뺀 값을 더함)
 *          배열을 생성할 때 기본 거리들은, 현재거리와 같다. 입력을 하나씩 받을 때 마다, 비용의 최소값을 구하면 되는데,
 *          지름길의 끝지점 = 지름길의 시작지점 + 비용 이것과 최소값을 비교한다.
 *
 * 시간복잡도 : O(N)? O(1)?
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (order, goal) = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(goal + 1) { it }
    val roads = mutableListOf<Road>()

    repeat(order) {
        val (start, end, cost) = br.readLine().split(" ").map { it.toInt() }
        roads.add(Road(start, end, cost))
    }
    roads.sortBy { it.start }

    var idx = 0
    var move = 0

    while (move < goal) {
        try {
            if (idx < roads.size) {
                val road = roads[idx]
                if (move == road.start) {
                    idx++
                    array[road.end] = Math.min(array[move] + road.cost, array[road.end])
                } else {
                    array[move + 1] = Math.min(array[move + 1], array[move] + 1)
                    move++
                }
            } else {
                array[move + 1] = Math.min(array[move + 1], array[move] + 1)
                move++
            }
        } catch (e: Exception) {
            continue
        }
    }
    /*roads.forEach {
        try{
            array[it.end] = min(array[it.start] + it.cost, array[it.end])
            array[goal] = min(array[it.end] + goal - it.end , array[goal])
        }catch (e:Exception){
        }
    }*/
    bw.write("${array[goal]}")

    bw.flush()
    bw.close()
}

data class Road(
    val start: Int,
    val end: Int,
    val cost: Int
)