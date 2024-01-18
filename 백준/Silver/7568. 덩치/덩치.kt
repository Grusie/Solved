package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : (몸무게, 키) 둘 다 큰 경우가 존재할 때에만 rate + cnt
 *
 * 시간 복잡도 : N^2
 *
 * 변수 : rate
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = Array(order){Pair(0,0)}

    repeat(order){
        val (weight, height) = br.readLine().split(" ").map { it.toInt() }
        array[it] = Pair(weight,height)
    }

    array.forEach {item ->
        bw.write("${array.count{ it.first > item.first && it.second > item.second} + 1} ")
    }

    bw.flush()
    bw.close()
}