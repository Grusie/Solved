package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 차이들의 최대공약수의 크기마다 가로수를 놓으면 된다.
 *          최대공약수를 구해서, 각 거리에 심을 나무의 개수를 구한다. -> 최대공약수로 나눈다.
 *          최대공약수를 구하는 법은, 모든 수를 2 ~ 최소값까지 나눠가면서, 나누어 떨어지는 값들 중 최대를
 *
 * 시간복잡도 : N
 *
 * 변수 : count, 전체, 차이
 **/
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()

    val diff = IntArray(order - 1) { 0 }

    var init = br.readLine().toInt()

    repeat(order - 1) {
        val item = br.readLine().toInt()
        diff[it] = item - init
        init = item
    }

    var max = 1
    for(i in 2..diff.min()){
        var flag = true
        for(index in diff.indices) {
            if (diff[index] % i != 0) {
                flag = false
                break
            }
        }
        if(flag) max = i
    }

    var count = 0
    for(i in diff.indices){
        count += (diff[i] / max - 1)
    }

    bw.write("$count")
    bw.flush()
    bw.close()
}