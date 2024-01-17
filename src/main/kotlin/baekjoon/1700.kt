package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.system.exitProcess

/**
 * 아이디어 : 멀티탭 구멍의 개수, 기구개수가 입력으로 주어진다.
 *          처음엔 멀티탭 구멍만큼 넣고, 총 사용횟수가 될 때 까지, 반복
 *          또 백트래킹 문제입니다. 일단 구멍개수만큼 먼저 넣고 난 뒤에,
 *          dfs를 돌면서 만약 멀티탭에 없으면, count+1, depth+1, 있으면 depth만 +1
 *          depth가 총 사용횟수가 될 경우 min 비교, 마지막에 출력
 *
 * 풀이를 본 후 : 멀티탭에 꽂혀 있지 않은 값들 중, 다음 플러그들을 검사하면서 리스트에 넣고,
 *              현재 꽂혀있는 것 중에, 리스트에 없는 게 있으면, 그걸 뽑아준다.
 *              만약 전부 다 다시 나온다면, 마지막의 플러그를 제거해준다.
 *
 * 시간 복잡도 : 한번 지나간 것도 지나가기에, N * K
 *
 * 변수 : min, 플러그 array, 사용할 기구 array
 *
 **/

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (size, order) = br.readLine().split(" ").map { it.toInt() }

    val plugArray = BooleanArray(order + 1){false}
    val ftArray = Array(order){0}

/*    var min = Int.MAX_VALUE*/

    with(StringTokenizer(br.readLine())){
        repeat(order){
/*            val item = nextToken().toInt()
            if(it < size){
                plugArray[item] = true
            }*/
            ftArray[it] = nextToken().toInt()
        }
    }

    /*fun dfs(count: Int, depth: Int){
        if(depth == order){
            min = min.coerceAtMost(count)
            return
        }

            repeat(size){
                if(!plugArray[ftArray[depth]]){
                    plugArray[ftArray[depth]] = true
                    dfs(count + 1, depth + 1)
                    plugArray[ftArray[depth]] = false
                }
                else {
                    dfs(count, depth + 1)
                }
            }
        }

    dfs(0, size)*/
    var count = 0

    for((index,function) in ftArray.withIndex()){
        if(plugArray[function]) continue
        if(plugArray.count{it} < size) {
            plugArray[function] = true
        }
        else {
            val list = mutableListOf<Int>()
            for(item in index+1 until order){
                if(plugArray[ftArray[item]] && !list.contains(ftArray[item])) list.add(ftArray[item])
            }

            if(list.size != size){
                for(i in plugArray.indices){
                    if(plugArray[i] && !list.contains(i)) {
                        plugArray[i] = false
                        break
                    }
                }
            } else {
                plugArray[list.last()] = false
            }

            plugArray[function] = true
            count+=1
        }
    }
    bw.write("$count")

    bw.flush()
}