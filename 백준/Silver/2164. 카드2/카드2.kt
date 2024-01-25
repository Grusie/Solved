package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

/**
 * 아이디어 : 큐 문제, 주어진 방식대로 N번 반복
 *
 * 시간복잡도 : N
 *
 * 변수 : 큐
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    val queue: Queue<Int> = LinkedList()
    val order = br.readLine().toInt()

    repeat(order){
        queue.add(it + 1)
    }

    while(queue.size > 1){
        queue.poll()
        queue.add(queue.poll())
    }

    bw.write("${queue.poll()}")

    bw.flush()
    bw.close()
}