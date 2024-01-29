package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 주어진대로 행하면 될 것 같다. 문자열과, 점수를 Pair로 입력받고,
 *          각 점수들을 판단해서 넣으면 될 것. 전투력 상한값의 비내림차순이라고 하였으니, indexFirst를 사용해서 표현..
 *          하기에는 시간 초과가 날 것 같다. 10의 9승까지 그냥 값을 입력하고, 배열에서 꺼내는 식으로 해보자
 *          -> 런타임에러가 발생한다. 이유는 모르겠다... 원래 이분탐색으로 하려다가 배열로 하려고 한건데....
 *          이분탐색으로 다시 해보자
 *
 * 시간복잡도 : N
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    val (nameCnt, score) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(nameCnt) { Pair("", 0) }

    repeat(nameCnt) {
        val item = br.readLine().split(" ")
        array[it] = Pair(item[0], item[1].toInt())
    }

    repeat(score) {
        val num = br.readLine().toInt()

        var left = 0
        var right = nameCnt - 1
        
        while (left <= right) {
            val mid = (left + right) / 2

            val max = array[mid].second

            if (max < num){
                left = mid + 1
            } else right = mid - 1
        }
        bw.write("${array[left].first}\n")
    }

    bw.flush()
    bw.close()
}