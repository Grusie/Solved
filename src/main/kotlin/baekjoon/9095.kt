package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 1,2,3에 대해서, 각각을 더해서 결과값이 되는 경우를 출력
 *          백트래킹을 사용하여 가능 할 것
 *
 * 시간복잡도 : N! (10!) 가능
 *
 **/
/*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val case = br.readLine().toInt()
    val array = arrayOf(1,2,3)

    var count = 0
    fun dfs(goal: Int, sum: Int){
        if(sum == goal){
            count++
            return
        }
        array.forEach {
            if(sum + it <= goal) dfs(goal, sum + it)
        }
    }

    repeat(case){
        count = 0
        val item = br.readLine().toInt()

        array.forEach {
            dfs(item, it)
        }
        bw.write("$count\n")
    }

    bw.flush()
    bw.close()
}
*/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val array = Array(11){0}

    array[0] = 1
    array[1] = 2
    array[2] = 4

    for(j in 3 until array.size-1){
        array[j] = array[j-3] + array[j-2] + array[j-1]
    }

    for (i in 0 until br.readLine().toInt()) {
        bw.write("${array[br.readLine().toInt()-1]}\n")
    }

    br.close()
    bw.flush()
    bw.close()
}