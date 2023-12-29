import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.StringTokenizer

/**
 * 입력 : 테스트 케이스, 체스판의 크기, 현재 위치, 도달 위치
 *
 * 아이디어 : 마찬가지로, 그래프탐색 문제이다. 최소 depth를 구하는 것도 같으니, BFS를 이용하면 금방 푼다.
 *          현재위치에서 이동할 수 있는 좌표들을 다음으로 넘기는 형태로 진행하면서, depth를 출력하면 될 듯 하다.
 *
 * 시간 복잡도 : BFS -> N^2 인접 리스트의 경우 N + E
 *
 * 변수 : 전체 배열 Boolean[], depth, dx, dy, queue
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val testCase = br.readLine().toInt()

    val dx = arrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
    val dy = arrayOf(-1, 1, -2, 2, -2, 2, -1, 1)


    repeat(testCase){
        val size = br.readLine().toInt()
        val current = with(StringTokenizer(br.readLine())){
                Pair(nextToken().toInt(), nextToken().toInt())
            }
        val goal = with(StringTokenizer(br.readLine())){
            Pair(nextToken().toInt(), nextToken().toInt())
        }

        val array = Array(size){Array(size){false}}

        fun bfs(){
            val queue = LinkedList<Pair<Pair<Int,Int>, Int>>()

            queue.add(Pair(current, 0))
            array[current.second][current.first] = true

            while (queue.isNotEmpty()){
                val (peek, depth) = queue.poll()

                if(peek == goal){
                    bw.write("$depth\n")
                    break
                }

                repeat(8) {
                    val newX = peek.first + dx[it]
                    val newY = peek.second + dy[it]

                    try{
                        if(!array[newY][newX]){
                            array[newY][newX] = true
                            queue.add(Pair(Pair(newX,newY), depth + 1))
                        }
                    }catch (e:Exception){}
                }

            }
        }

        bfs()
    }

    bw.flush()
}