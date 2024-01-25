package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 아이디어 : 남자는 스위치 번호의 배수를 바꿔주면 되고, 여자는 기준점을 기준으로 다를 때 까지 바꿔주면 된다.
 *          출력 : 한 줄에 20개씩 출력을 한다.
 *
 * 시간복잡도 : T * (N + N)
 *
 * 변수 : 받은 수, 성별, 전체 배열
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = BooleanArray(order + 1)

    with(StringTokenizer(br.readLine())) {
        repeat(order) {
            array[it + 1] = nextToken() == "1"
        }
    }

    val testcase = br.readLine().toInt()

    repeat(testcase) {
        val (gender, number) = br.readLine().split(" ").map { it.toInt() }

        if (gender == 1) {
            var i = 1
            while (number * i < array.size) {
                array[number * i] = !array[number * i]
                i++
            }
        } else {
            var j = 1
            try {
                array[number] = !array[number]
                while (array[number - j] == array[number + j]) {
                    if(number - j >= 1) {
                        array[number - j] = !array[number - j]
                        array[number + j] = !array[number + j]
                    }
                    j++
                }
            }catch (e:Exception){}
        }
    }

    for (i in 1 until array.size) {
        bw.write("${if (array[i]) 1 else 0} ")
        if ((i) % 20 == 0) bw.write("\n")
    }
    bw.flush()
    bw.close()
}