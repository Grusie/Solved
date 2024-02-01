package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 이번에도 백트래킹으로 해결 할 수 있을 것 같다.
 *          입력받은 값에 대해서, 배열에 넣은 뒤, +로 join해서 불러오자
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (goal, k) = br.readLine().split(" ").map { it.toInt() }
    br.close()
    val array = ArrayList<MutableList<String>>()

    repeat(goal + 3){
        array.add(mutableListOf())
    }

    array[1].add("1")
    array[2].add("1+1")
    array[2].add("2")
    array[3].add("1+1+1")
    array[3].add("1+2")
    array[3].add("2+1")
    array[3].add("3")

    for(i in 4..goal){
        for(j in 1..3){
            array[i-j].forEach {
                array[i].add("$it+$j")
            }
        }
    }

    if(array[goal].size < k){
        bw.write("-1")
    } else {
        array[goal].sort()
        bw.write("${array[goal][k-1]}")
    }

    bw.flush()
    bw.close()
}