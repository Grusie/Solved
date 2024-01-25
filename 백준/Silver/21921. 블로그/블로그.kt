package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * 아이디어 : 그리디 문제로서, 처음부터 days만큼 더하고, 그 뒤에 값을 더하고 빼고 반복하며 최대값을 구하면 될 듯.
 *          max가 0이라면 SAD 출력, 여러번일 수도 있으니, max 해시맵을 변경해가면서 할 것
 *
 * 시간복잡도 : N
 *
 * 변수 : max - hashmap, sum
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (order, days) = br.readLine().split(" ").map{it.toInt()}

    val array = IntArray(order)

    with(StringTokenizer(br.readLine())){
        repeat(order){
            array[it] = nextToken().toInt()
        }
    }

    var sum = 0

    repeat(days){
        sum += array[it]
    }

    var max = sum
    var count = 1

    for(i in days until array.size){
        sum += array[i]
        sum -= array[i - days]

        if(sum > max){
            count = 1
            max = sum
        } else if(sum == max){
            count++
        }
    }

    if(max == 0) bw.write("SAD") else bw.write("$max\n$count")

    bw.flush()
    bw.close()
}