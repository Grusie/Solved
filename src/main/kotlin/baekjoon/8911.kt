package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * 아이디어 :
 *  F:눈금 앞으로
 *  B:눈금 뒤로
 *  L:왼쪽으로 회전
 *  R:오른쪽으로 회전
 *  지나간 영역의, 최대 최소 x*y 를 해서 출력하면 된다.
 *
 *  주의 : 한 줄로만 쭉 간다면, 넓이는 0이 된다.
 *
 *  시간복잡도 : N
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    val case = br.readLine().toInt()

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(-1, 0, 1, 0)

    repeat(case){
        var maxX = 0
        var minX = 0
        var maxY = 0
        var minY = 0
        var x = 0
        var y = 0
        var dir = 0
        br.readLine().forEach {
            when(it){
                'F' ->{
                    x += dx[dir]
                    y += dy[dir]
                    maxX = max(maxX, x)
                    maxY = max(maxY,y)
                    minX = min(minX, x)
                    minY = min(minY,y)
                }
                'L' ->{
                    dir = (dir + 3) % 4
                }
                'R' -> {
                    dir = (dir + 1) % 4
                }
                'B' -> {
                    x += dx[(dir + 2) % 4]
                    y += dy[(dir + 2) % 4]
                    maxX = max(maxX, x)
                    maxY = max(maxY,y)
                    minX = min(minX, x)
                    minY = min(minY,y)
                }
            }
        }
        bw.write("${abs((maxX - minX) * (maxY - minY))}\n")
    }

    bw.flush()
    bw.close()
}