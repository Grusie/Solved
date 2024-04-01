package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 대각선까지, 지뢰가 놓여져 있는 갯수를 표시한다. 만약 지뢰가 있는 곳이 x라면, 지뢰가 있는 모든 칸이 *로 표시되어야 한다.
 * */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = Array(order) { CharArray(order) }    //맵
    val answer = Array(order) { CharArray(order) }   //결과값

    val dx = arrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = arrayOf(-1, 0, 1, 1, -1, 1, 0, -1)

    repeat(order) {
        array[it] = br.readLine().toCharArray()
    }

    repeat(order) {
        answer[it] = br.readLine().toCharArray()
    }

    var flag = false
    for(y in 0 until order){
        for(x in 0 until order){
            var count = 0
            if(answer[y][x] == 'x') {
                if(array[y][x] == '*'){
                    flag = true
                } else {
                    repeat(8) {
                        try {
                            if (array[y + dy[it]][x + dx[it]] == '*') {
                                count++
                            }
                        } catch (_: Exception) {
                        }
                    }
                    answer[y][x] = count.toChar() + '0'.code
                }
            }
        }
    }

    if(flag){
        for(y in 0 until order) {
            for (x in 0 until order) {
                if(array[y][x] == '*'){
                    answer[y][x] = '*'
                }
            }
        }
    }

        answer.forEach {
            it.forEach {c->
                bw.write("$c")
            }
            bw.write("\n")
        }
    bw.flush()
    bw.close()
}