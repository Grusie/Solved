package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 홀수라면 시작한 사람이 이긴다.
 *          그게 아니라면, 다음 사람이 이김
 *
 * 시간복잡도 : N
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    bw.write("${if( br.readLine().toInt() % 2 == 1) "SK" else "CY"}")

    bw.flush()
    bw.close()
}