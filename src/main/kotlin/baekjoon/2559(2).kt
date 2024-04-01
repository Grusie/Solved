package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (size, order) = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(size + 1)
    val sum = IntArray(size + 1)        //이전 인덱스의 값에 값을 더해서 넣어야하기에 + 1

    with(StringTokenizer(br.readLine())) {
        repeat(size) {
            array[it + 1] = nextToken().toInt()     //각 온도
            sum[it + 1] = sum[it] + array[it + 1]   //온도들의 합
        }
    }

    var max = Int.MIN_VALUE     //음수일 수도 있기에 MIN_VALUE로 처리
    for(i in order .. size) {
        max = max.coerceAtLeast(sum[i] - sum[i - order])
    }


    bw.write("$max")
    bw.flush()
    bw.close()
}