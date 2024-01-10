import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 그래프탐색을 활용해서 풀 수 있을 것 같다.
 *          시작, 끝나는 시간과 depth를 가지고 최대의 개수를 구한다
 *
 * 알고리즘 분류를 보고난 후 : 그리디 알고리즘, 정렬로 푸는 것
 *                         회의수가 가장 많으려면, end가 중요하므로, end를 기준으로 정렬을 먼저 한뒤,
 *                         같은 시간에 끝나는데, 회의시간이 0인게 있으면, 그것을 무조건 나중에해야한다.
 *                         그렇기에 start를 기준으로 한 번 더 정렬해야한다.
 * 시간복잡도 : N!
 *
 * 변수 : visited, Pair, depth, max, array
 *
 * */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = mutableListOf<Pair<Int,Int>>()

    repeat(order){
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        array.add(Pair(start,end))
    }

    array.sortBy { it.first }
    array.sortBy{ it.second}

    var count = 1
    var end = array[0].second
    for(i in 1 until array.size){
        if(array[i].first >= end){
            count++
            end = array[i].second
        }
    }
    bw.write("$count")

    bw.flush()
    bw.close()
}