package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

/**
 * 아이디어 : dfs, bfs를 돌리면 된다. 돌면서 들어온 값들을 출력 해준다.
 *          dfs를 먼저 -> visited, 재귀
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (nodeCnt, lineCnt, start) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(nodeCnt + 1){ mutableListOf<Int>() }
    val visited = BooleanArray(nodeCnt + 1)

    repeat(lineCnt){
        val item = br.readLine().split(" ").map { it.toInt() }
        array[item[0]].add(item[1])
        array[item[1]].add(item[0])
    }

    array.forEach {
        it.sort()
    }

    fun dfs(start: Int){
        visited[start] = true
        bw.write("$start ")

        array[start].forEach {
            if(!visited[it]) {
                dfs(it)
            }
        }
    }

    fun bfs(start: Int){
        val queue:Queue<Int> = LinkedList<Int>()
        queue.add(start)

        while (queue.isNotEmpty()){
            val item = queue.poll()
            if(!visited[item]) {
                visited[item] = true
                bw.write("$item ")
                array[item].forEach {
                    queue.add(it)
                }
            }
        }
    }

    dfs(start)
    visited.fill(false)
    bw.write("\n")
    bfs(start)

    bw.flush()
    bw.close()
}