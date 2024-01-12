import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 :
 *  1. 피보나치 수열을 구하는 함수를 구현하고, 들어올 때 마다 + 1
 *  2. 피보나치 수열 함수를 돌린 것 처럼, 0과 1의 count를 배열로 넣어두고 결과값 출력
 *  3. 그리디처럼, 전값과 그 전값을 가지고 더하는 형태
 *
 *  시간복잡도 :
 *  1. N!
 *
 *  변수 : 0,1의 카운트 배열, 두 수의 합
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val array = mutableListOf<Pair<Int,Int>>()

    val count0 = Pair(1,0)
    val count1 = Pair(0,1)
    array.add(count0)
    array.add(count1)

    for(i in 2 .. 40){
        array.add(Pair(array[i - 2].first + array[i - 1].first, array[i - 2].second + array[i - 1].second))
    }

    val order = br.readLine().toInt()
    repeat(order) {
        val value = array[br.readLine().toInt()]
        bw.write("${value.first} ${value.second}\n")
    }

    bw.flush()
    bw.close()
}