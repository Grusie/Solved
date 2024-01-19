package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.system.exitProcess

/**
 * 아이디어 : (랭킹에 점수 개수, 태수의 점수, 랭킹에 최대 개수 P)
 *          1. 점수가 랭킹 마지막 보다 낮으면서, 랭킹이 꽉 차 있을 때 -1
 *          2. 랭킹의 마지막 점수보다 높으면, 점수를 원하는 적당한 위치에 넣고, index 출력
 *              -> 만약 같은 점수인 사람이 있을 경우, 같은 등수로 넣는다.
 *
 * 시간복잡도 : N ^ 2
 *
 * 변수 : 전체 배열
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, score, maxRanking) = br.readLine().split(" ").map { it.toInt() }

    fun writeResult(print: String) {
        bw.write(print)
        bw.flush()
        bw.close()
        exitProcess(0)
    }
    if (N == 0) {
        writeResult("1")
    }

    val array = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    if(array.size == maxRanking && array.last() >= score){
        writeResult("-1")
    } else {
        array.add(score)
        array.sortDescending()
        writeResult("${array.indexOfFirst { it == score } + 1}")
    }
}