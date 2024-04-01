package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

/**
 * 아이디어 : R, B 두 번 실행하여 최소값을 구할 것이고, 우선 양쪽 맨 끝으로 이동시킬 것이다.
 *          총 4번의 반복을 한다고 봐도 무방할 것 같다.
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val map = br.readLine().map { it == 'R' }

    var min = Int.MAX_VALUE
    var count = 0
    var flag = false
    for (i in 0 until order) {
        if (!map[i]) flag = true
        if (flag && map[i]) count++
    }
    min = min(min, count)
    flag = false
    count = 0

    for (i in order - 1 downTo 0) {
        if (!map[i]) flag = true
        if (flag && map[i]) count++
    }
    min = min(min, count)
    flag = false
    count = 0

    for (i in 0 until order) {
        if (map[i]) flag = true
        if (flag && !map[i]) count++
    }
    min = min(min, count)
    flag = false
    count = 0
    for (i in order - 1 downTo 0) {
        if (map[i]) flag = true
        if (flag && !map[i]) count++
    }

    min = min(min, count)

    bw.write("$min")

    bw.flush()
    bw.close()
}