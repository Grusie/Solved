package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.max

/**
 * 아이디어 : 한 사람의 성적을, 다른 사람의 성적들과 비교했을 때 더 높은 사람이 있다면, 그 사람의 다른성적과 비교를 한다.
 *          둘 다 다른 사람이 높다면, 최대값 -1
 *          처음에 sort를 하고 계산을 하면 한 번 지나간 곳은 다시 계산 안 해도 되니 시간이 줄어들 것
 *
 * 해결법을 본 뒤 : array에 넣은 뒤, 1부터, maxRank를 비교하여, maxRank보다 작으면 뽑을 수 있는 직원이므로 +1 후, maxRank수정
 *
 * 시간복잡도 : (테스트케이스) * N(N-1) * 2 -> N^2 얼추 괜찮을수도... 해보고 안 되면, 백트래킹 고민
 * 시간복잡도2 : (테스트케이스) * N
 *
 * 변수 : 전체 사원수, 사원의 성적들을 담을 Pair리스트, for문을 돌면서 안 뽑을 사람을 판별할 flag
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val case = br.readLine().toInt()
    repeat(case) {
        val order = br.readLine().toInt()
        val array = Array(order + 1){0}
        var count = 0

        repeat(order) {
            with(StringTokenizer(br.readLine())){
                array[nextToken().toInt()] = nextToken().toInt()
            }
        }

        var maxRank = Int.MAX_VALUE
        for(i in 1 until array.size){
            if(maxRank > array[i]){
                count++
                maxRank = array[i]
            }
        }

        bw.write("$count\n")
    }

    bw.flush()
}