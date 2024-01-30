package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Collections
import java.util.PriorityQueue
import java.util.StringTokenizer

/**
 * 아이디어 : 표에 적힌 수가 -10억 ~ 10억이기에 시간이 중요할 것, N번째 큰수를 찾는 것이기에..
 *          일단 Priority큐로 한 번 해보자
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val queue = PriorityQueue<Int>(Collections.reverseOrder())

    val order = br.readLine().toInt()
    repeat(order) {
        with(StringTokenizer(br.readLine())){
            repeat(order) {
                queue.add(nextToken().toInt())
            }
        }
    }

    repeat(order){
        if(it == order - 1) bw.write("${queue.poll()}") else queue.poll()
    }
    bw.flush()
    bw.close()
}