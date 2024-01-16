import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.max

/**
 * 아이디어 : 마찬가지로 DP 문제인 것 같다. 시작 위치에서부터 갈 수 있는 위치의 값 중 최대값으로 더해가면 될 것 같다.
 *          조건으로는, 하나 더할 때 마다, 연속 값을 증가시키며, 연속되지 않을 경우 새로 0으로 다시 초기화 하면 될 것 같다.
 *
 * 시간 복잡도 : N
 *
 * 변수 : 연속 count, 점수를 담을 배열
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw= BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val score = Array(30001){0}
    val steps = Array(30001){0}

    repeat(order){
        steps[it + 1] = br.readLine().toInt()
    }

    score[1] = steps[1]
    score[2] = steps[1] + steps[2]

    for(i in 3..order){
        score[i] = max(score[i - 3] + steps[i - 1], score[i - 2]) + steps[i]
    }
    bw.write("${score[order]}")

    bw.flush()
    bw.close()
}