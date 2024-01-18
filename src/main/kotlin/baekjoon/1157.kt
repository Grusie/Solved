package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : uppcase와 lowercase의 개수를 센다. max값을 빼고, 두번 째 max를 구했을 때 같으면, ?출력, 다르면 처음 꺼 출력
 *
 * 시간복잡도 : N
 *
 * 변수 : a~z 배열(26), max
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val array = Array(26){0}
    br.readLine().forEach {
        array[it.uppercase()[0] - 'A']++
    }

    var index = 0
    var max = 0
    for(i in array.indices){
        if(max < array[i]){
            index = i
            max = array[i]
        }
    }

    array[index] = 0

    if(array.max() == max) bw.write("?")
    else bw.write("${'A' + index}")

    bw.flush()
    bw.close()
}