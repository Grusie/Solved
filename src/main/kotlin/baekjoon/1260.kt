package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import javax.sound.sampled.Line

/**
 * 아이디어 : 그래프를 DFS, BFS를 순회하며 순회한 순서대로 출력하는 코드를 작성하는 것
 *          DFS를 이번에는 Stack을 사용하여 한 번 풀어보도록 하자
 *          반복문 돌 때, 현재 노드를 담아두는 변수에 넣고 마지막에 출력
 *
 * 시간 복잡도 : 2N^2
 *
 * 변수 : 스택, 큐, 노드를 담을 변수,
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (nums, lines, start) = with(StringTokenizer(br.readLine())){
        arrayOf(nextToken().toInt(), nextToken().toInt(), nextToken().toInt())
    }

    val array = Array(nums + 1){ mutableListOf<Int>() }
    val visited = Array(nums + 1){false}

    repeat(lines){
        with(StringTokenizer(br.readLine())){
            val a = nextToken().toInt()
            val b = nextToken().toInt()

            array[a].add(b)
            array[b].add(a)
        }
    }

    fun dfs(init:Int){
        val stack = Stack<Int>()
        var count = 0
        array.forEach {
            it.sortDescending()
        }

        stack.push(init)

        while (stack.isNotEmpty()){
            if(count == nums) break
            val peek = stack.pop()

            if(!visited[peek]) {
                count++
                visited[peek] = true
                bw.write("$peek ")
            }

            array[peek].forEach {item ->
                if(!visited[item]) {
                    stack.push(item)
                }
            }
        }
    }

    fun bfs(init:Int){
        array.forEach {
            it.sort()
        }
        val queue :Queue<Int> = LinkedList()

        queue.add(init)
        visited[init] = true

        while(queue.isNotEmpty()){
            val peek = queue.poll()
            bw.write("$peek ")

            array[peek].forEach {
                if(!visited[it]){
                    visited[it] = true
                    queue.add(it)
                }
            }
        }
    }


    dfs(start)
    bw.write("\n")
    visited.fill(false)
    bfs(start)

    bw.flush()
}