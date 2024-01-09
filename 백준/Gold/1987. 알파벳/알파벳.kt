import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : dfs를 돌면서, 한번 지나간 알파벳들을, 배열에 저장하고, 마지막에 count를 해주는 형태로 진행
 *          비교할 때, visted와, 배열에 있는지 비교해야함
 *
 * 시간복잡도 : 백트래킹 4N^2 -> N^2
 *
 * 변수 : 전체 배열, 지나온 알파벳 배열, dx, dy, (visited)
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (height, width) = br.readLine().split(" ").map{it.toInt()}
    val array = Array(height){IntArray(width)}

    val dx = arrayOf(0, -1, 1, 0)
    val dy = arrayOf(-1, 0, 0, 1)

    var maxDepth = 0
    val visited = BooleanArray(26){false}

    repeat(height){y ->
        br.readLine().forEachIndexed { x, value ->
            array[y][x] = value - 'A'
        }
    }

    fun dfs(init: Pair<Int,Int> = Pair(0,0), depth:Int = 1){
        if(maxDepth < depth) maxDepth = depth

        repeat(4) {
            try {
                val newX = init.first + dx[it]
                val newY = init.second + dy[it]

                if(!visited[array[newY][newX]]){
                    visited[array[newY][newX]] = true
                    dfs(Pair(init.first + dx[it], init.second + dy[it]), depth + 1)
                    visited[array[newY][newX]] = false
                }

            }catch (e:Exception){}
        }
    }

    visited[array[0][0]] = true
    dfs()

    bw.write("$maxDepth")

    bw.flush()
}