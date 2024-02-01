package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 이번에도 백트래킹으로 해결 할 수 있을 것 같다.
 *          입력받은 값에 대해서, 배열에 넣은 뒤, +로 join해서 불러오자
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (goal, k) = br.readLine().split(" ").map { it.toInt() }
    br.close()
    val result = mutableListOf<String>()
    val array = arrayOf(1, 2, 3)

    val resultList = mutableListOf<Int>()

    fun dfs(sum: Int) {
        if (sum == goal) {
            result.add(resultList.joinToString("+"))
            return
        }

        repeat(3) {
            if (sum + array[it] <= goal) {
                resultList.add(array[it])
                dfs(sum + array[it])
                resultList.removeLast()
            }
        }
    }

    repeat(3) {
        resultList.add(array[it])
        dfs(array[it])
        resultList.removeLast()
    }

    result.sort()
    try {
        bw.write("${result[k - 1]}")
    } catch (e: Exception) {
        bw.write("-1")
    }
    bw.flush()
    bw.close()
}