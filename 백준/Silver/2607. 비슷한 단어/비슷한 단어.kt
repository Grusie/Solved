package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 :
 *  1.두 개의 단어가 같은 종류의 문자로 이루어져 있다.
 *  2.같은 문자의 수는 같다.
 *  3.같은 종류의 문자로 이루어져 있으나, 수의 차이가 1개이면 비슷한 단어로 처리한다.
 *  HashMap에 문자와 수를 입력한다. 비교해가면서 처리했을 때
 *  만약 남거나, 사이즈도, 문자의 수도 1개라면 비슷한 단어로 처리
 *
 * 시간복잡도 : N
 *
 * 변수 : HashMap
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val goal = br.readLine()
    val words = Array(order - 1) { "" }

    val goalArray = Array(26) { 0 }
    goal.forEach {
        goalArray[it - 'A']++
    }

    repeat(order - 1) {
        words[it] = br.readLine()
    }

    var count = 0

    words.forEach { word ->
        val array = Array(26) { 0 }

        word.forEach {
            array[it - 'A']++
        }

        goalArray.forEachIndexed { index, value ->
            array[index] -= value
        }

        val result = array.filter { it != 0 }
        when{
            result.isEmpty()||
            result.size == 1 && result[0] in arrayOf(-1, 1)||
            result.size == 2 && result[0] in arrayOf(-1, 1) &&
                    result[1] in arrayOf(-1, 1) && result[0] == result[1] * (-1) -> { count++ }
        }
    }

    bw.write("$count")

    bw.flush()
    bw.close()
}