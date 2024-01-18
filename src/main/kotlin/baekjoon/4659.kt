package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 :
 * 1. 모음을 하나 이상은 꼭 포함해야 한다.
 * 2. 단어에서 같은 글자가, 두 개가 연달아 오면 안 된다. (단, ee와 oo는 가능)
 * 3. 모음 or 자음이 3개 연속으로 오면 안 된다.
 *
 * 시간복잡도 : TN
 *
 * 변수 : 전체 array, 모음 배열, 같은글자 확인(이전 글자), 모음 or 자음 카운트
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val vowels = arrayOf('a','e','i','o','u')

    fun isVowels(c:Char): Boolean{
        return vowels.contains(c)
    }

    fun writeResult(sentence: String, possible: Boolean){
        if(possible) bw.write("<$sentence> is acceptable.\n") else bw.write("<$sentence> is not acceptable.\n")
    }

    while(true){
        val sentence = br.readLine()
        if(sentence == "end") break

        var pre = ' '
        var flag = true
        for(it in vowels) {
            if(sentence.contains(it))  {
                flag = false
                break
            }
        }
        if(flag) {
            writeResult(sentence, false)
            continue
        }

        var vowelsFlag = false
        var cnt = 0

        loop@ run {
            sentence.forEach {
                if (pre != 'e' && pre != 'o' && pre == it) {
                    writeResult(sentence, false)
                    return@run
                }
                pre = it
                if(vowelsFlag == isVowels(it))
                    cnt++
                else {
                    vowelsFlag = !vowelsFlag
                    cnt = 1
                }

                if(cnt >=3){
                    writeResult(sentence, false)
                    return@run
                }
            }
            writeResult(sentence, true)
        }
    }

    bw.flush()
    bw.close()
}