import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 이번엔 dfs를 활용하여 문제를 풀어보려고 한다.
 *          마찬가지로 visited는 필요 없고, 단지 수와, 단지 내 집을 오름차순으로 정렬해서 출력할 것
 *
 * 시간 복잡도 : N^2
 *
 * 변수 : 전체 배열, 단지 내 집 수, 우선순위 큐
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = Array(order) { Array(order) { false } }

    val dx = arrayOf(0, -1, 0, 1)
    val dy = arrayOf(1, 0, -1, 0)

    repeat(order) {
        br.readLine().forEachIndexed { index, value ->
            array[it][index] = value != '0'
        }
    }
    val count = mutableListOf<Int>()

    fun dfs(x: Int, y: Int) {
        count[count.size - 1]++
        array[y][x] = false
        repeat(4) {
            val newX = x + dx[it]
            val newY = y + dy[it]
            try{
                if (array[newY][newX]) dfs(newX, newY)
            } catch (e: Exception) {  }
        }
    }

    repeat(order) { y ->
        repeat(order) { x ->
            if (array[y][x]) {
                count.add(0)
                dfs(x, y)
            }
        }
    }


    bw.write("${count.size}\n")
    count.sort()
    count.forEach {
        bw.write("${it}\n")
    }
    bw.flush()
}