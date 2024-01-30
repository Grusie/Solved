package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.max

/**
 * 아이디어 :
 *  1. 주식 하나를 산다.
 *  2. 주식을 원하는 만큼 가지고 있는 주식을 판다.
 *  3. 아무것도 안 한다.
 * 주식을 하나만 산다는 거에 주의 할 필요가 있을 것 같다.
 * 최대값일 때 까지 다 사고, 최대값이 되면 팔아버리는 형태로 가는 게 제일 이득일 것 같다.
 * 최대값 이후부터도, 그 이후의 최대값 까지 계속 반복
 *
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val case = br.readLine().toInt()

    repeat(case){
        val order = br.readLine().toInt()
        val array = IntArray(order)

        with(StringTokenizer(br.readLine())){
            repeat(order){
                array[it] = nextToken().toInt()
            }
        }

        var max = array.last()
        var total = 0L

        for(i in array.lastIndex downTo 0){
            if(array[i] <= max)
                total += max - array[i]
            else max = array[i]
        }

        bw.write("$total\n")
    }
    bw.flush()
    bw.close()
}