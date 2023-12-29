import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

/**
 * 아이디어 : 시작지점에서 끝 지점으로 이동할 때, 갈 수 있는 최소값을 구하는 문제이다.
 *          0,0 에서 부터 n-1, m-1의 위치까지 그래프 탐색을 하여, 그 최소 depth를 출력
 *
 * 시간 복잡도 : N^2 -> 인접 리스트의 경우 N + E
 *
 * 변수 : 큐, depth, dx, dy
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dx = arrayOf(-1,0,1,0)
    val dy = arrayOf(0,-1,0,1)

    val (height, width) = br.readLine().split(" ").map{it.toInt()}
    val array = Array(height){Array(width){false}}

    repeat(height) {
        br.readLine().forEachIndexed{index, value ->
            array[it][index] = value == '1'
        }
    }

    fun bfs(){
        val queue = LinkedList<Pair<Pair<Int,Int>, Int>>()

        queue.add(Pair(Pair(0, 0), 1))
        array[0][0] = false

        while (queue.isNotEmpty()){
            val (peek, depth) = queue.poll()

            if(peek == Pair(width - 1, height - 1)) {
                bw.write("$depth")
                break
            }

            repeat(4) {
                val newX = peek.first + dx[it]
                val newY = peek.second + dy[it]

                try {
                    if (array[newY][newX]) {
                        array[newY][newX] = false
                        queue.add(Pair(Pair(newX, newY), depth + 1))
                    }
                }catch (e:Exception){}
            }
        }
    }

    bfs()

    bw.flush()
}