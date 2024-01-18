package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * 아이디어 : 금, 은, 동 메달 개수에 따라 등수를 나누며, 주의해야 할 점은
 *          동점일 경우, 같은 등수이며, 그 다음 나라는 동점인 나라의 수 이후의 등수이다.
 *          전부 아이디를 가진 데이터클래스에 넣고, 금,은,동을 기준으로 sort해준 뒤 index를 구하면 된다.
 *
 * 시간복잡도 : NLogN?
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val rateArray = mutableListOf<Info>()

    val (order, goal) = br.readLine().split(" ").map { it.toInt() }

    repeat(order){
        with(StringTokenizer(br.readLine())){
            rateArray.add(Info(nextToken().toInt(),nextToken().toInt(),nextToken().toInt(),nextToken().toInt()))
        }
    }

    rateArray.sortBy { it.id }

    var rate = 1
    rateArray.forEach {
        val target = rateArray[goal - 1]
        if(it.id != goal){
            if(it.gold > target.gold)
                rate++
            else if (it.gold == target.gold){
                if(it.silver > target.silver)
                    rate++
                else if(it.silver == target.silver){
                    if(it.bronze > target.bronze)
                        rate++
                }
            }
        }
    }
    bw.write("$rate")

    bw.flush()
    bw.close()
}

data class Info(
    val id: Int = 0,
    val gold: Int = 0,
    val silver: Int = 0,
    val bronze: Int = 0
)