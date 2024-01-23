package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger
import java.util.StringTokenizer

/**
 * 아이디어 : 처음 주유소의 가격과 비교했을 때, 그것보다 낮은 가격의 주유소가 나올 때 까지의 거리만큼만 기름을 넣고
 *          그 이후, 도착 했을 때에도 마찬가지로 비교하여 기름을 넣으면 된다.
 *
 * 시간 복잡도 : N!?
 *
 * 변수 : 각 거리를 담은 배열, 유류비를 담은 배열, 총 유류비
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val city = IntArray(order)
    val dist = IntArray(order)

    with(StringTokenizer(br.readLine())){
        repeat(order - 1){
            dist[it + 1] = nextToken().toInt()
        }
    }

    with(StringTokenizer(br.readLine())){
        repeat(order){
            city[it] = nextToken().toInt()
        }
    }

    var totalCost = BigInteger("0")
    var totalDist = 0
    var index = 0
    while(index < city.size){

        var flag = true
        var tempDist = 0
        for(i in index + 1 until city.size){
            if(city[index] > city[i]){
                flag = false
                for(j in index + 1 .. i) {
                    tempDist += dist[j]
                }

                totalCost += BigInteger.valueOf(tempDist.toLong()) * BigInteger.valueOf(city[index].toLong())
                totalDist += tempDist
                index = i
                break
            }
        }

        if(flag){
            totalCost += BigInteger.valueOf((dist.sum() - totalDist).toLong()) * BigInteger.valueOf(city[index].toLong())
            break
        }
    }

    bw.write("$totalCost")

    bw.flush()
    bw.close()
}