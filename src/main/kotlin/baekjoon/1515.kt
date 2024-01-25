package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 해당 숫자와 같거나 다음 숫자들 중, n이 속해 있는지를 비교하는데, 예를 들어 두자리 수 일 때, 그 수의 0번째~1번째까지 비교하며,
 *          같은 수일 때에도 다음 꺼에서 다음을 비교해서 마지막까지 되었을 때의 최소값을 구한다.
 *
 * 시간복잡도 : ??
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val string = br.readLine()

    var total = 0

    var pre = 1
    var index = 0

    string.forEach {
        while (true) {
            val tempPre = pre.toString()
            var flag = false
            for (i in index until tempPre.length) {
                if (tempPre[i] == it) {
                    index = i + 1
                    flag = true
                    break
                }
            }
            if (flag) break
            pre++
            index = 0
        }
        total = pre
    }

    bw.write("$total")

    bw.flush()
    bw.close()
}