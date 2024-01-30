package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : set을 사용하여, 미리 키워드를 담아두고, 입력 받았을 때, 지운다음에 카운트를 진행하자
 *          지우기 때문에, 다음 줄에서 키워드를 사용 했어도 지울 수 없을 것이기에 카운트는 유효할 것
 *
 * 시간복잡도 : N
 *
 * 변수 : Set
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (keywordCnt, poemCnt) = br.readLine().split(" ").map { it.toInt() }

    val keywords = mutableSetOf<String>()

    repeat(keywordCnt){
        keywords.add(br.readLine())
    }

    repeat(poemCnt){
        br.readLine().split(",").forEach {
            keywords.remove(it)
        }
        bw.write("${keywords.count()}\n")
    }

    bw.flush()
    bw.close()
}