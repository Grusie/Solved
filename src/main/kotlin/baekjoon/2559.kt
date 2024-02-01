package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.max

/**
 * 아이디어 : 전체 온도의 개수와, 연속된 날짜가 주어지고, 온도 배열이 주어질 때,
 *          연속된 날짜의 합의 최대값을 구하는 것. 투포인터로 처리하는 형태가 되겠다.
 *          이전 합의 맨 앞에 수를 - 해주고 다음 수를 + 해주는 형태로 가는것
 *          sum[n] = a[n] + a[n + 1] .. a[n+r] -> sum[n+1] = a[n+1] ~~ a[n+r+1]
 *
 * 시간복잡도 : N
 *
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (order, size) = br.readLine().split(" ").map{ it.toInt() }

    val array = IntArray(order)
    with(StringTokenizer(br.readLine())){
        repeat(order){
            array[it] = nextToken().toInt()
        }
    }

    var preSum = 0

    repeat(size){
        preSum += array[it]
    }
    var max = preSum

    for(i in 1 .. order - size){
        preSum = preSum - array[i - 1] + array[i + size - 1]

        max = max(max, preSum)
    }

    bw.write("$max")

    bw.flush()
    bw.close()
}