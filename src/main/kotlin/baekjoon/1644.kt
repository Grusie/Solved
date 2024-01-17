package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt
import kotlin.system.exitProcess

/**
 * 아이디어 : 입력받은 수 보다 작은 소수들을 구해 배열에 넣고, 백트래킹 진행 각 수를 더해가며, 해당 수가 되면 종료
 *
 * 시간복잡도 : N(소수구하기) * (소수)!(백트래킹)
 *
 * 변수 : 소수들을 담을 배열
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()

    if(order < 2){
        bw.write("0")
        bw.flush()
        bw.close()
        exitProcess(0)
    }
    var count = 0
    val array = mutableListOf<Int>()

    for(i in 2 .. order){
        var flag = true
        for(j in 2 until sqrt(i.toFloat()).toInt() + 1){
            if((i % j) == 0){
                flag = false
                break
            }
        }
        if(flag)
            array.add(i)
    }

    for(i in array.indices){
        var sum = array[i]
        if(sum == order) {
            count++
            continue
        }
        for(j in i+1 until array.size){
            sum += array[j]
            if(sum == order) {
                count++
                break
            }
            else if(sum > order) break
        }
    }

    bw.write("$count")
    bw.flush()
    bw.close()
}