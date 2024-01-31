package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.max

/**
 * 아이디어 : 처음부터, 각 아이템 별로 배열에 첫 번째 인덱스, cnt를 추가, 카운트 넣으면서 끝까지 가는 것을 반복,
 *          만약 이전 값이 N개 이상 나온다면 종료, 첫번째로 들어갔을 때의 값 이후에 부터 다시 반복
 *
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (order, next) = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(order + 1)
    val result = IntArray(100001)

    with(StringTokenizer(br.readLine())) {
        repeat(order){
            array[it + 1] = nextToken().toInt()
        }
    }

    var max = 0
    var index = 0

    for(i in 1..order){
        result[array[i - 1]]--

        while (index + 1 <= order && result[array[index + 1]] < next){
            index++
            result[array[index]]++
        }

        max = max(max, index - i + 1)
    }

    bw.write("$max")

    bw.flush()
    bw.close()
}