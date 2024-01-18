package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * 아이디어 : 리스트에 맨 앞에 부터 넣으면서, 지금 넣을 수의 값보다 큰 수의 개수를 더해 주면 될 것 같다.
 *
 * 시간복잡도 : T (* 20)
 *
 * 변수 : count, 전체 배열
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()){
        val array = mutableListOf<Int>()
        with(StringTokenizer(br.readLine())){
            val order = nextToken()
            var count = 0
            repeat(20) {
                val item = nextToken().toInt()
                count += array.count { it > item }
                array.add(item)
            }
            bw.write("$order $count\n")
        }
    }

    bw.flush()
    bw.close()
}