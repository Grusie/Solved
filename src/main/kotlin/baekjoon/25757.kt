package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 본인 포함이므로 게임인원수 - 1, 중복을 피하기 위해 set을 쓴 뒤, 그 set의 수 / (게임인원수 - 1) 출력
 *
 * 시간복잡도 : N
 *
 * 변수 : Set, 게임인원수, 게임종류
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val gamePeople = mapOf<Char, Int>('Y' to 1, 'F' to 2, 'O' to 3)
    val set = mutableSetOf<String>()

    val (order, game) = br.readLine().split(" ")

    val people = gamePeople[game[0]]!!

    repeat(order.toInt()){
        set.add(br.readLine())
    }

    bw.write("${set.size / people}")

    bw.flush()
    bw.close()
}