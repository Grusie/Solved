package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 아이디어 : bfs로 해결합시다. 2에서 부터 출발하면 될 듯
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (height, width) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(height){IntArray(width)}

    var goal = Pair(-1,-1)

    repeat(height){y ->
        with(StringTokenizer(br.readLine())) {
            repeat(width) { x ->
                val item = nextToken().toInt()
                if(item == 2) goal = Pair(x,y)
                array[y][x] = item
            }
        }
    }
    val dx = arrayOf(-1,0,1,0)
    val dy = arrayOf(0,1,0,-1)
    val visited = Array(height){BooleanArray(width)}

    fun bfs(x:Int, y:Int){
        val queue: Queue<Pair<Int,Int>> = LinkedList()
        queue.add(Pair(x, y))
        visited[y][x] = true
        array[y][x] = 0

        while (queue.isNotEmpty()){
            val item = queue.poll()

            repeat(4){
                val newX = item.first + dx[it]
                val newY = item.second + dy[it]

                try {
                    if (!visited[newY][newX] && array[newY][newX] != 0) {
                        array[newY][newX] = array[item.second][item.first] + 1
                        visited[newY][newX] = true
                        queue.add(Pair(newX, newY))
                    }
                }catch (e:Exception){}
            }
        }
    }

    bfs(goal.first, goal.second)

    repeat(height){ y ->
        repeat(width){x ->
            if(!visited[y][x] && array[y][x] != 0) bw.write("-1 ")
            else bw.write("${array[y][x]} ")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}