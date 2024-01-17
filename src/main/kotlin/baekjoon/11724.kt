package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer


/**
 * 연결 요소의 개수를 구하는 프로그램 작성
 * 연결 요소 : 떨어져 있는 그래프의 개수
 * 입력 : 노드의 수, 간선의 수
 * 아이디어 : 각 번호 당 연결 되어 있는 노드를 배열로 저장(2차원 배열)
 *          저장된 노드들에 대해서 그 노드들에 연결된 다른 노드들을 확인
 *          간선으로 연결 되어 있기 떄문에, 양 쪽 배열에 서로 추가해주어야 함
 *          그 노드에서 연결 되지 않은 노드가 있으면, 숫자를 비교해서 다시 탐색의 반복
 *          다시 탐색 할 떄마다 + 1
 *          한 번 방문 한 곳은 visited 뺴기
 * 시간 복잡도 : N^2
 * 변수 : 노드들을 담을 2차원 배열, 연결 요소의 수, 전체 수, visited
 **/
private lateinit var visited : Array<Boolean>
private lateinit var array : Array<ArrayList<Int>>
private var count = 0

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (number, order) = with(StringTokenizer(readLine())){
        Pair(nextToken().toInt(),nextToken().toInt())
    }

    visited = Array(number){false}
    array = Array(number){ArrayList()}

    repeat(order){
        with(StringTokenizer(br.readLine())){
            val a = nextToken().toInt() - 1
            val b = nextToken().toInt() - 1
            array[a].add(b)
            array[b].add(a)
        }
    }

    repeat(array.size){
        if(!visited[it]){
            dfs(it)
            count++
        }
    }


    bw.write("$count")
    bw.flush()
}

fun dfs(index: Int){
    if (!visited[index]) {
        visited[index] = true
        array[index].forEach {
            dfs(it)
        }
    }
}