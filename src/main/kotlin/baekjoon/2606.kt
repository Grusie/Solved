package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * 입력 : 첫쨰 줄 - 컴퓨터의 수, 둘째 줄 - 네트워크 상에서 연결되어 있는 쌍의 수
 * 아이디어 : 이전 문제와 동일하게 ,dfs를 통해, 이번에는 파고 들어갈 떄 마다 + 1을 해주면 될 것 같다.
 * 시간 복잡도 : N^2
 * 변수 : 카운트, visited배열, 전체 배열(양측), 노드 수, 간선 수
 **/

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val number = br.readLine().toInt()
    val order = br.readLine().toInt()

    val array = Array(number){ArrayList<Int>()}
    val visited = Array(number){false}
    var count = 0

    repeat(order){
        with(StringTokenizer(br.readLine())){
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            array[a].add(b)
            array[b].add(a)
        }
    }


    fun dfs(index:Int){
        visited[index] = true
        if(index != 0) count++
        array[index].forEach {
            if(!visited[it]) dfs(it)
        }
    }
    dfs(0)
    bw.write("$count")

    bw.flush()
}