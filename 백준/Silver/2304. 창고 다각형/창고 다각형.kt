package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

/**
 * 아이디어 : 맨 앞에서부터, 뒤에 그것보다 큰 기둥이 있다면, 맨 앞 높이로 가다가 큰 기둥을 마주 했을 때 위로 올리고
 *          큰 기둥이 없다면, 그 자리에서 다음으로 가장 큰 기둥까지 낮춰서 진행한다.
 *
 * 시간복잡도 : (N-1) ^ 2
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val array = IntArray(1001)

    val order = br.readLine().toInt()
    repeat(order) {
        val item = br.readLine().split(" ").map { it.toInt() }
        array[item[0]] = item[1]
    }

    var index = array.indexOfFirst { it > 0 }
    var lastIndex = array.indexOfLast { it > 0 }
    var total = 0
    var maxIndex = 0

    for(i in index..lastIndex){
        if(array[maxIndex] < array[i])
            maxIndex = i
    }

    for(i in index..maxIndex){
        if(array[i] >= array[index]){
            total += array[index] * (i - index)
            index = i
        }
    }

    for(i in lastIndex downTo maxIndex){
        if(array[i] >= array[lastIndex]){
            total += array[lastIndex] * (lastIndex - i)
            lastIndex = i
        }
    }

    total += array[index]

    bw.write("$total")

    bw.flush()
    bw.close()
}