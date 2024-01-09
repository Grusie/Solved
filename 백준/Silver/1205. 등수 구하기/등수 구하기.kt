import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.system.exitProcess

/**
 * 입력 : 점수의 갯수, 태수의 점수, 랭킹 인원
 *
 * 아이디어 : 마찬가지로 그리디 알고리즘인 것 같다. 배열에, mutableList를 넣은 뒤, 각 점수마다 등수를 넣을 건데,
 *          등수는, 앞에 있던 배열들의 총 합 + 1과 같다.
 * 아이디어2 : 그냥 배열 하나에 insert 다 때리고, sort후, 돌면서, count 해주는 방식
 *
 * 시간 복잡도 : N
 *
 * 변수 : 점수 mutableList를 가진 등수 Array, 전체 count
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    with(StringTokenizer(br.readLine())) {
        val order = nextToken().toInt()
        if (order == 0) {
            bw.write("1")
            bw.flush()
            exitProcess(0)
        }
        val score = nextToken().toInt()
        val people = nextToken().toInt()

        val list = mutableListOf<Int>()
        var count = 1

        with(StringTokenizer(br.readLine())) {
            repeat(order) {
                val item = nextToken().toInt()
                list.add(item)
            }
        }
        list.add(score)

        list.sortDescending()

        if(order == people && score <= list.last()){
            bw.write("-1")
        } else {
            for (i in list.indices) {
                if (score < list[i]) {
                    count++
                } else {
                    break
                }
            }
            bw.write("$count")
        }
    }

    bw.flush()
}