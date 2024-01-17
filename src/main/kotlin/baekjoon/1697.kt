package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 아이디어 :
 * 1. 거리가 2X+-1보다 멀면, 그거보다 작아질 때 까지 반복, 시간초 + 1
 * 2. 2X+-1 보다 작으면 X +- 1
 *
 * 알고리즘 분류를 본 뒤
 * -> BFS를 활용하는 것 같다.
 * 3가지 경우의 수를 각각 계산해서, BFS를 활용 해보자자
 *
 * 시간복잡도 : N ^ 2
 *
 * 변수 : 시간, 거리, 현재위치
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var (start, end) = with(StringTokenizer(br.readLine())) {
        Pair(nextToken().toInt(), nextToken().toInt())
    }

    var visited = Array(100001) { false }

    fun bfs(init: Int) {
        val queue: Queue<Pair<Int,Int>> = LinkedList()
        queue.add(Pair(init, 0))
        visited[init] = true
        while (queue.isNotEmpty()) {
            val (peek, time) = queue.poll()
            if (peek == end) {
                bw.write("$time")
                break
            }

            try {
                if (!visited[peek * 2]) {
                    visited[peek * 2] = true
                    queue.add(Pair(peek * 2, time +1))
                }
            } catch (e: Exception) {
            }

            try {
                if (!visited[peek - 1]) {
                    visited[peek - 1] = true
                    queue.add(Pair(peek - 1,time+1))
                }
            } catch (e: Exception) {
            }
            try {
                if (!visited[peek + 1]) {
                    visited[peek + 1] = true
                    queue.add(Pair(peek + 1, time+1))
                }
            } catch (e: Exception) {
            }
        }
    }

    bfs(start)

    bw.flush()
}