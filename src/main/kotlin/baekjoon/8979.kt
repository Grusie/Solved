package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


/**
 * 입력 : 참가한 국가의 수  |  등수를 알고싶은 국가
 *       한 줄 당, 국가 번호와 금,은,동의 개수
 * 아이디어 : 금은동 개수를 비교, 각각 많은 국가 수를 더해주고, 같을 경우 비교, 동점자도 비교해야함.
 *          어차피 이전 사람들의 동점자는 등수에 영향을 미치지 못하니, 현재 동점자일 경우를 비교해야한다?
 *          그러나 동점자여도 똑같은 등수이므로, 신경 안 써도 될 듯
 * 시간 복잡도 : 금, 은, 동 각각 계산하므로, 최대 3N -> N 문제없음
 * 변수 : 금,은,동 각각 배열(3개), 알고싶은 국가의 국가코드, 등 수 rate
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var rate = 1

    val list = br.readLine().split(" ")
    val order = list[0].toInt()
    val goal = list[1].toInt()

    val gold = Array(order + 1){0}
    val silver = Array(order + 1){0}
    val bronze = Array(order + 1){0}

    repeat(order){
        val line = br.readLine().split(" ").map { it.toInt() }
        gold[line[0]] = line[1]
        silver[line[0]] = line[2]
        bronze[line[0]] = line[3]
    }

    gold.forEachIndexed { index, value ->
        if(value > gold[goal])
            rate++
        else if(value == gold[goal]){
            if(silver[index] > silver[goal]){
                rate++
            }else if(silver[index] == silver[goal]){
                if(bronze[index] > bronze[goal]) rate++
            }
        }
    }

    if(rate == 0) rate = 1

    bw.write("$rate")
    bw.flush()
}