import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Math.max
import java.util.*

/**
 * 아이디어 : BFS 문제이다.
 *          1로 시작하는 곳에서부터, 마지막까지의 depth를 구하는 문제이다.
 *
 *          1. 만약 토마토가 모두 익지 못하는 상황이라면 -1을 출력해야한다. ==> 0이 -1로 둘러쌓여 있을 경우
 *          2. 모든 토마토가 익어 있으면 0
 *
 * 시간복잡도 : N^2
 *
 * 변수 : 전체 배열, 방문여부 => 2로 변경하듯이 배열을 사용, depth, Queue
 *
 **/
fun main(){
    val br= BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (width, height) = br.readLine().split(" ").map { it.toInt() }
    val dx = arrayOf(-1,0,1,0)
    val dy = arrayOf(0,-1,0,1)
    val array = Array(height){Array(width){0}}

    repeat(height){y ->
        with(StringTokenizer(br.readLine())){
            repeat(width){x ->
                array[y][x] = nextToken().toInt()
            }
        }
    }

    val queue = LinkedList<Pair<Pair<Int,Int>, Int>>()
    fun bfs() : Int{
        var depth = 0

        while (queue.isNotEmpty()){
            val peek = queue.poll().let{
                depth = it.second
                it.first
            }
            repeat(4) {
                val newY = peek.second + dy[it]
                val newX = peek.first + dx[it]

                try {
                    if (array[newY][newX] == 0) {
                        queue.add(Pair(Pair(newX, newY), depth + 1))
                        array[newY][newX] = 2
                    }
                }catch (e:Exception){}
            }
        }
        return depth
    }


    repeat(height){ y->
        repeat(width){ x->
            if(array[y][x] == 1){
                queue.add(Pair(Pair(x,y), 0))
                array[y][x] =2
            }
        }
    }
    val result = bfs()

    var flag = true
    array.forEach {
        if(it.contains(0)) {
            flag = false
            return@forEach
        }
    }
    if(!flag){
        bw.write("-1")
    } else bw.write("$result")

    bw.flush()
}