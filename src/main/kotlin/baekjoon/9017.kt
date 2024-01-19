package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


/**
 * 아이디어 :
 *  1. 팀 인원이 6명보다 작으면 점수를 받지못함
 *  2. 점수가 동점인 팀들이 있다면, 5번째로 들어온 선수의 점수가 더 낮은 곳이 이긴다.
 *  5번째 점수, 팀원수, 총점수
 *  들어오는대로 배열을 만든 뒤, 6명 미만이면 빼고, 점수를 부여, 점수를 계산하다가, 점수가 동일하다면 각 점수의 5번째 값을 비교
 *
 *  시간복잡도 : N
 *
 *  변수 : 팀별 클래스, cnt
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val testcase = br.readLine().toInt()

    repeat(testcase){
        val order = br.readLine().toInt()
        val array = IntArray(order)
        val result = HashMap<Int, Int>()

        with(StringTokenizer(br.readLine())){
            repeat(order){
                val item = nextToken().toInt()
                result[item] = result.getOrDefault(item, 0) + 1
                array[it] = item
            }
        }

        val fifthGoal = IntArray(result.size + 1)
        val scoreMap = HashMap<Int,Int>()
        var score = 1

        val tempMap = HashMap<Int,Int>()
        for (element in array) {
            if (result[element]!! >= 6) {
                tempMap[element] = tempMap.getOrDefault(element, 0) + 1
                if (tempMap[element]!! <= 4) {
                    scoreMap[element] = scoreMap.getOrDefault(element, 0) + score
                }
                if (tempMap[element] == 5) {
                    fifthGoal[element] = score
                }
                score++
            }
        }

        val keyData = scoreMap.keys

        val resultData = keyData.sortedWith(Comparator { x, y ->
            if (Objects.equals(scoreMap[x], scoreMap[y])) {
                fifthGoal[x] - fifthGoal[y]
            } else {
                scoreMap[x]!! - scoreMap[y]!!
            }
        })

        bw.write("${resultData[0]}\n")
    }

    bw.flush()
    bw.close()
}