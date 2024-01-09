import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * 아이디어 : 백트래킹으로 0~9까지 돌면서, 1번째부터, 부등호와 비교를 해 값을 채워 나가고(방문표시도)
 *           depth가 부등호의 개수가 되면, max, min 비교
 *
 * 시간복잡도 : (10 *) N^2
 *
 * 변수 : 전체가 MaxInt보다 크니 Long, 결과값 변수 , max, min, 방문표시 visited
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = CharArray(order)
    val visited = BooleanArray(10){false}

    with(StringTokenizer(br.readLine())){
        repeat(order) {
            array[it] = nextToken()[0]
        }
    }

    var min = "9999999999"
    var max = "0"

    fun dfs(init:Int, depth: Int, result: String){
        if(depth == order){
            val tempResult = result.toLong()
            if(min.toLong() > tempResult) min = result
            if(max.toLong() < tempResult) max = result
            return
        }

        for(i in 0 until 10) {
            if (!visited[i]){
                if(array[depth] == '<'){
                    if(init < i){
                        visited[i] = true
                        dfs(i, depth + 1, result + "$i")
                        visited[i] = false
                    }
                } else {
                    if(init > i){
                        visited[i] = true
                        dfs(i, depth + 1, result + "$i")
                        visited[i] = false
                    }
                }
            }
        }
    }

    for(i in 0 until 10){
        visited[i] = true
        dfs(i, 0,"$i")
        visited[i] = false
    }

    bw.write("$max\n$min")
    bw.flush()
}