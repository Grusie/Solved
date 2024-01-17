package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.system.exitProcess

/**
 * 아이디어 : 백트래킹 문제이다, 전체를 순회하면서, 들어갈 수 있는 값들을 넣고 넣어서 진행한다.
 *          값이 0일 때에만 진행(빈칸), 1~9까지 가로 비교(x), 세로 비교(y),
 *          현재 값이 들어있는 사각형의 첫번째 칸을 얻은 뒤, 사각형에 들어있는 값 비교
 *          x,y
 *
 *
 * 시간복잡도 : N^2
 *
 * 배열 : 전체를 담고있는 이차원 배열
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val array = Array(9) { IntArray(9) }

    repeat(9) { y ->
        with(StringTokenizer(br.readLine())) {
            repeat(9) { x ->
                array[y][x] = nextToken().toInt()
            }
        }
    }

    fun check(x:Int, y:Int, item:Int): Boolean{
        repeat(9){
            if(array[it][x] == item)
                return false
        }
        repeat(9){
            if(array[y][it] == item)
                return false
        }

        val tempY = (y / 3) * 3
        val tempX = (x / 3) * 3

        for(i in tempY until tempY + 3){
            for(j in tempX until tempX + 3){
                if(array[i][j] == item)
                    return false
            }
        }
        return true
    }

    fun dfs(x: Int, y: Int) {
        if(x == 9){
            dfs(0, y + 1)
            return
        }
        if(y == 9){
            repeat(9){y ->
                repeat(9){x->
                    bw.write("${array[y][x]} ")
                }
                bw.write("\n")
            }

            bw.flush()
            bw.close()
            exitProcess(0)
        }

        if(array[y][x] == 0) {
            for (i in 1..9) {
                if (check(x, y, i)) {
                    array[y][x] = i
                    dfs(x + 1, y)
                }
            }
            array[y][x] = 0
            return
        }
        dfs(x + 1, y)
    }

    dfs(0, 0)
}