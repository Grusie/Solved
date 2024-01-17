package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import kotlin.math.max


/**
 * 아이디어 :
 *  1. 육지로만 이동이 가능하다.
 *  2. 상하좌우로만 이동을 한다.
 *  3. 같은 곳을 지나가면 안 된다.
 *  4. 최소로 가야한다.
 *  5. 시간
 * => BFS
 * 마찬가지로 depth를 시간으로 생각하고 넘기면 되는 문제이다.
 *
 * 첫 번째, 보물에서부터, 다음 보물까지의 최단거리의 최대값이기에,
 * 모든 곳에서 출발해서, 갈 수 있는 마지막까지의 depth 중 최대값
 *
 * 시간 복잡도 : N^2 각각의 bfs를 돌것이기에 더 늘어남, 각각 50이하이기에 가능할 듯
 *
 * 변수 : 큐, depth, 최대depth, 전체 배열
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (height, width) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(height){Array(width) {false} }
    val visited = Array(height){BooleanArray(width){false} }

    val dx = arrayOf(0, 1, 0 ,-1)
    val dy = arrayOf(-1, 0, 1 ,0)
    var maxDepth = 0

    repeat(height){
        br.readLine().forEachIndexed { index, value ->
            array[it][index] = value == 'L'
        }
    }

    fun bfs(init: Pair<Int,Int>){
        val queue = LinkedList<Pair<Pair<Int,Int>, Int>>()
        var depth = 0
        queue.add(Pair(init, depth))
        visited[init.second][init.first] = true

        while (queue.isNotEmpty()){
            val top = queue.poll()
            val peek = top.first
            depth = top.second

            repeat(4) {
                val newX = peek.first + dx[it]
                val newY = peek.second + dy[it]
                try {
                    if(!visited[newY][newX] && array[newY][newX]){
                        visited[newY][newX] = true
                        queue.add(Pair(Pair(newX,newY), depth + 1))
                    }
                }catch (e:Exception){}
            }
        }
        maxDepth = max(maxDepth, depth)
    }

    for(i in array.indices) {
        for(j in array[i].indices){
            if(array[i][j]) {
                bfs(Pair(j, i))
                visited.forEach {
                    it.fill(false)
                }
            }
        }
    }

    bw.write("$maxDepth")

    bw.flush()
}