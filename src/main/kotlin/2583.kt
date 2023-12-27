import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer


/**
 * 아이디어 : 직사각형 안에 있는 부분들을 false로 해두고 true인 부분들끼리만, 그래프 탐색
 *          마찬가지로 BFS로 탐색을 해볼 예정, BFS탐색 시, 깊이와, BFS 카운트를 출력
 *
 * 시간복잡도 : N^2
 *
 * 변수 : 전체 배열(직사각형 false, 나머지 true), visited 배열 -> 돌면서 false로 바꾸면 되므로 필요X,
 *       (공간 count) -> depth의 개수로 처리하면 됨, 넓이 depth
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    val (height, width, order) = with(StringTokenizer(br.readLine())){
        arrayOf(nextToken().toInt(), nextToken().toInt(), nextToken().toInt())
    }

    val array = Array(height){Array(width){true} }
    val depth = mutableListOf<Int>()

    repeat(order){
        with(StringTokenizer(br.readLine())){
            val leftX = nextToken().toInt()
            val leftY = nextToken().toInt()
            val rightX = nextToken().toInt()
            val rightY = nextToken().toInt()

            for(x in leftX until rightX){
                for(y in height - rightY..<height - leftY)
                    array[y][x] = false
            }
        }
    }

    val queue : Queue<Pair<Int, Int>> =  LinkedList()
    fun bfs(init :Pair<Int,Int>){
        queue.add(init)
        array[init.second][init.first] = false

            while(queue.isNotEmpty()) {
                val top = queue.poll()

                repeat(4){
                    val x = top.first + dx[it]
                    val y = top.second + dy[it]

                    try {
                        if (array[y][x]) {
                            array[y][x] = false
                            depth[depth.size - 1]++
                            queue.add(Pair(x, y))
                        }
                    }catch (e:Exception){}
                }
            }
    }

    repeat(height){y ->
        repeat(width){x ->
            if(array[y][x]){
                depth.add(1)
                bfs(Pair(x,y))
            }
        }
    }


    bw.write("${depth.size}\n")
    bw.write(depth.sorted().joinToString(" "))
    bw.flush()
}