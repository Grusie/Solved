package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.max

/**
 * 아이디어 :
 *   1.총 점수가 본인 팀보다 높은 팀 + 1순위
 *   2.총 점수가 같다면, 제출 횟수가 적은 팀이 위
 *   3.제출 횟수도 같다면, 마지막 문제를 빨리 제출한 팀이 높다.
 * 각 팀별로, 총 점수와, 마지막 문제의 제출 순서(라인 수), 제출 카운트를 저장해주어야한다.
 *
 * 입력 : line1 : 테스트 케이스, line2 : 팀개수, 문제개수, 팀아이디, 로그 개수
 *       그 이후 : 팀아이디, 문제번호, 점수
 *
 * 시간 복잡도 : 저장 후 sort
 *
 * 변수 : 아이디, 총 점수, 순서, 제출 카운트를 담은 객체
 *
 **/

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val case = br.readLine().toInt()

    repeat(case){
        val (teamCnt, problemCnt,teamId,logCnt) = br.readLine().split(" ").map { it.toInt() }

        val hashMap = HashMap<Int, Team>()
        var count = 0
        repeat(logCnt){
            count++
            val item = br.readLine().split(" ").map { it.toInt() }
            hashMap[item[0]] = hashMap.getOrDefault(item[0], Team()).apply {
                scoreMap[item[1]] = max(scoreMap.getOrDefault(item[1], 0), item[2])
                last = count
                applyCount += 1
            }
        }

        val result = hashMap.entries.sortedWith(compareBy({-it.value.scoreMap.values.sum()}, {it.value.applyCount}, {it.value.last}))
        bw.write("${result.indexOfFirst { it.key == teamId} + 1}\n")
    }

    bw.flush()
    bw.close()
}

data class Team(
    var scoreMap: HashMap<Int, Int> = HashMap(),
    var applyCount: Int = 0,
    var last: Int = 0,
)