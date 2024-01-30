package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

/**
 * 아이디어 : 최소힙 문제라고는 하나, 우선순위 큐를 이용해서 풀 수 있을 것으로 예상된다.
 *          0이 들어오면 맨 앞에 값 지우면서 출력, 없으면 0 출력
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val queue = PriorityQueue<Int>()

    val order = br.readLine().toInt()

    repeat(order){
        val item = br.readLine().toInt()
        if(item == 0){
            val result = if(queue.isNotEmpty()) queue.poll()
            else 0
            bw.write("$result\n")
        } else queue.add(item)
    }

    bw.flush()
    bw.close()
}