package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 0과 1의 수를 세서, /2한 만큼의 숫자 만큼 0을 넣고, 1을 넣으면 될 것 같다.
 *          문자의 이동이 되는 것은 아니라서, 있는 것에서 처리를 해야한다.
 *          1은 앞에서 부터 절반만큼 지우고, 0은 뒤에서 부터 절반만큼 지우면 된다.
 *
 * 시간복잡도 : N
 *
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var zeroCnt = 0
    var oneCnt = 0
    val item = br.readLine().toCharArray()
    item.forEach {
        if (it == '0') zeroCnt++
        else oneCnt++
    }
    zeroCnt /=2
    oneCnt /=2

    var i = item.lastIndex
    while (zeroCnt > 0) {
        if (item[i] == '0') {
            item[i] = ' '
            zeroCnt--
        }
        i--
    }

    var j = 0
    while (oneCnt > 0) {
        if (item[j] == '1') {
            item[j] = ' '
            oneCnt--
        }
        j++
    }

    item.forEach {
        if(it != ' ') bw.write("$it")
    }

    bw.flush()
    bw.close()
}