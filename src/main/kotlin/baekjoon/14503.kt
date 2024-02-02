package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 아이디어 :
 *   1.현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다.
 *   2.주변 4칸이 전부 청소되어 있다면, 바라보는 방향을 유지한 채, 한 칸 후진하고, 1번으로 돌아간다.
 *   3.뒤에가 벽이라 후진 할 수 없다면 작동을 멈춘다.
 *   4.주변 4칸 중 빈칸이 있는경우, 반시계 방향으로 90도 회전한다.
 *   5.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸의 경우 한 칸 전진한다. 1번으로 돌아간다.
 * */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (height, width) = br.readLine().split(" ").map { it.toInt() }

    var (y, x, dir) = br.readLine().split(" ").map { it.toInt() }


    val dx = arrayOf(0, 1, 0, -1)       //북동남서
    val dy = arrayOf(-1, 0, 1, 0)          //dir --

    val array = Array(height) { IntArray(width) }
    repeat(height) { y ->
        with(StringTokenizer(br.readLine())) {
            repeat(width) { x ->
                array[y][x] = nextToken().toInt()
            }
        }
    }

    var count = 0

    while (true) {
        if (array[y][x] == 0) {
            array[y][x] = 2
            count++
        }

        var flag = true
        for (it in 1..4) {
            dir = (dir+3) % 4
            if (y+dy[dir] in 0 until height && x +dx[dir] in 0 until width && array[y + dy[dir]][x + dx[dir]] == 0) {
                    y += dy[dir]
                    x += dx[dir]
                    flag = false
                    break
                }
        }
        if (flag) {
            y += dy[(dir + 2) % 4]
            x += dx[(dir + 2) % 4]

            if (y in 0 until height && x in 0 until width && array[y][x] != 1) continue else break
        }
    }

    bw.write("$count")

    bw.flush()
    bw.close()
}