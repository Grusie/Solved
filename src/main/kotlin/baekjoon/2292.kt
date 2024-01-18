package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.ceil

/**
 * 아이디어 : 우선 최대 10억개가 들어오기에, 이중포문 이상은 시간초과가 날 것
 *          피보나치처럼 각 수들의 관계를 살펴봐야 할 것 같다. 각 depth마다 같은 최소 값을 가진다.
 *
 * 시간복잡도 : N
 *
 * 변수 : count
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val goal = br.readLine().toInt()
    var count = 1
    var range = 2

    if(goal == 1){
        bw.write("1")
    } else {
        while (range <= goal){
            range += (6 * count)
            count++
        }
        bw.write("$count")
    }

    bw.flush()
    bw.close()
}