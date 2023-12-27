import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


/**
 * 아이디어 :
 * 1. BFS를 돌면서, 처음에 뽑은 색상과 같은 색상끼리 그룹을 지어 그 그룹의 개수를 출력한다,.
 * 2. 적록색약일 경우에서, R 혹은 G일 경우, 경우는 같은 걸로 묶는다.
 *
 * 시간 복잡도 : N^2
 *
 * 변수 : 총 배열, 뽑았던 색상 변수(임의), 적록색약 일때와 아닐 경우 각각 출력 값, visited
 * */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = Array(order) { CharArray(order) }
    val visited = Array(order) { Array(order) { false } }

    var count = 0

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(-1, 0, 1, 0)

    repeat(order) {
        br.readLine().forEachIndexed { index, value ->
            array[it][index] = value
        }
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    fun bfs(index: Pair<Int, Int>, blind: Boolean = false) {
        count++
        val initColor = array[index.first][index.second]
        visited[index.first][index.second] = true
        queue.add(index)

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            repeat(4) {
                val y = current.first + dy[it]
                val x = current.second + dx[it]
                try {
                    if (!visited[y][x]) {
                        if (array[y][x] == initColor) {
                            visited[y][x] = true
                            queue.add(Pair(y, x))
                        } else if (blind && initColor != 'B') {
                            if (array[y][x] != 'B') {
                                visited[y][x] = true
                                queue.add(Pair(y, x))
                            }
                        }
                    }
                } catch (e: Exception) {
                }
            }
        }
    }

    for (i in array.indices) {
        for (j in array[i].indices) {
            if (!visited[i][j]) bfs(Pair(i, j))
        }
    }

    bw.write("$count ")
    count = 0

    repeat(order) { it1 ->
        repeat(order) { it2 ->
            visited[it1][it2] = false
        }
    }

    for (i in array.indices) {
        for (j in array[i].indices) {
            if (!visited[i][j]) bfs(Pair(i, j), true)
        }
    }
    bw.write("$count")

    bw.flush()
}