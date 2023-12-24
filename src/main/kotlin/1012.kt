import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 입력 : 첫째줄 - 테스트 케이스 개수, 둘 째 줄 - 배추 가로길이, 세로길이, 배추 위치의 개수
 * 아이디어 : 11724문제와 동일하게, 연결 요소의 수를 계산하면 되는 문제인 것 같다.
 *          그래프 탐색 중 이번에는 BFS를 활용하여 문제를 풀어봐야겠다.
 * 시간 복잡도 : N^2
 * 변수 : BFS이므로 큐를 활용, 전체 배열, 테스트 케이스에 따른 결과값 수, (visited 배열 없이 될지도)
 **/

private lateinit var array : Array<Array<Boolean>>
private val dx = arrayOf(-1, 0, 0, 1)
private val dy = arrayOf(0, -1, 1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val case = br.readLine().toInt()

    repeat(case) {
        val (width, height, order) = with(StringTokenizer(br.readLine())) {
            arrayOf(nextToken().toInt(), nextToken().toInt(), nextToken().toInt())
        }
        array = Array(height) { Array(width) { false } }

        var count = 0
        repeat(order) {
            with(StringTokenizer(br.readLine())) {
                val x = nextToken().toInt()
                val y = nextToken().toInt()
                array[y][x] = true
            }
        }

        repeat(array.size){y ->
            repeat(array[y].size) {x ->
                if(array[y][x]) {
                    bfs(y, x)
                    count++
                }
            }
        }

        bw.write("$count\n")
    }

    bw.flush()
}

fun bfs(y: Int, x: Int) {
    val queue = LinkedList<Pair<Int,Int>>()
    queue.add(Pair(y,x))
    while (queue.isNotEmpty()){
        val (tempY,tempX) = queue.poll()

        if(!array[tempY][tempX]) continue
        array[tempY][tempX] = false

        repeat(4) {
            try {
                if (array[tempY + dy[it]][tempX + dx[it]]) {
                    queue.add(Pair(tempY + dy[it], tempX + dx[it]))
                }
            }catch (e:Exception){}
        }
    }
}