package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 아이디어 : 맨 앞에서부터 순차적으로 넣는다고 하면, 앞에 빈공간이 몇 개 있는지를 비교해서 넣을 수 있겠다.
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = IntArray(order + 1) { 0 }

    with(StringTokenizer(br.readLine())) {
        repeat(order) {
            var count = 0
            val left = nextToken().toInt()

            for (i in 1 until array.size) {
                if (array[i] == 0) count++
                if (count - 1 == left) {
                    array[i] = it + 1
                    break
                }
            }
        }
    }
    for (i in 1 until array.size) {
        bw.write("${array[i]} ")
    }
    bw.flush()
    bw.close()
}