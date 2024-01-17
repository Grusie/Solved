package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 순회하다가 비어있는 칸이 발견되면 거기서 부터, 가로 2칸 이상인지 비교, 맞으면 다음 줄로 넘어가고,
 *          아니면, 그 줄에서 더 찾아봄
 *          가로 세로 반복 총 2초
 * 시간복잡도 : 순회 N^2 이며, 두 번 반복하니까 2N^2 -> N^2 가능
 * 변수 : 전체배열, 순회 할 변수, 가로 카운트, 세로 카운트
 **/
fun main (){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    var array = Array(order){ CharArray(order) }
    var rowCount = 0
    var columnCount = 0

    repeat(order) {column ->
        val line = br.readLine()
        repeat(order) {row ->
            array[column][row] = line[row]
        }
    }

    for(i in array.indices){
        var _rowCount = 0
        var _columnCount = 0
        for(j in array[i].indices){
            if(array[i][j] == '.') {
                _rowCount += 1
                if(_rowCount == 2) {
                    rowCount++
                }
            } else _rowCount = 0
        }
        for(j in array[i].indices){
            if(array[j][i] == '.') {
                _columnCount += 1
                if(_columnCount == 2) {
                    columnCount++
                }
            } else _columnCount = 0
        }
    }

    bw.write("$rowCount $columnCount")
    bw.flush()
}