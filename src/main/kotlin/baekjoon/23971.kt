package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * 아이디어 : 행과 열에 맨 첫번째 칸에 앉아있을 때가 그나마 젤 큰 값이다. 맨 앞에 앉히고, 그 이후의 수를 세어보자
 *          배열에 값을 넣으며 수를 세기 보단, n칸 떨어져 있는 만큼이니, 나누기로 계산을 해보는 게 좋을 것 같다.
 *
 * 시간 복잡도 : 최대 N*M
 *
 * 변수 : 개수, 너비, 높이, 간격 2
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (height,width, N, M) = with(StringTokenizer(br.readLine())){
        arrayOf(nextToken().toInt(), nextToken().toInt(),nextToken().toInt(),nextToken().toInt())
    }

    //한줄 * 전체 줄 수
    bw.write("${(1 + (width - 1) / (M + 1)) * (1 + (height - 1) / (N + 1))}")

    bw.flush()
    bw.close()
}