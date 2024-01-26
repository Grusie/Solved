package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.min

/**
 * 아이디어 : 갈 수 있는 방향은 3가지이며, 이전에 갔던 방향을 가지는 못한다.
 *          최소값을 구한다. 1.그리디 알고리즘으로 현재에서 갈 수 있는 가장 작은 값들을 더한다. -> 조건에 의해 dp로 해야함
 *          2.dfs로, 가장 작은 값을 구한다.
 *          시작을 선택하는 여러가지 중, 갈 수 있는 하위값들을 더해서 결과로 출력
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (height, width) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(height){IntArray(width)}

    repeat(height){y ->
        with(StringTokenizer(br.readLine())){
            repeat(width){x ->
                array[y][x] = nextToken().toInt()
            }
        }
    }
    val visited = Array(height){BooleanArray(width){false} }

    val dy = arrayOf(1,1,1)
    val dx = arrayOf(-1,0,1)

    var totalCost = Int.MAX_VALUE

    fun dfs(x:Int, y:Int, cost:Int, direction:Int){
        if(y == height - 1){
            totalCost = min(totalCost, cost)
            return
        }

        repeat(3){
            try{
                if(direction != it){
                    if(!visited[y + dy[it]][x + dx[it]]){
                        visited[y + dy[it]][x + dx[it]] = true
                        dfs(x + dx[it], y+dy[it], cost + array[y+dy[it]][x+dx[it]], it)
                        visited[y + dy[it]][x + dx[it]] = false
                    }
                }
            }catch (e:Exception){}
        }
    }


    repeat(width){x ->
        dfs(x, 0, array[0][x],-1)
    }

    bw.write("$totalCost")

    bw.flush()
    bw.close()
}