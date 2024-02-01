package baekjoon
import java.io.*
import java.util.*

/**
 * 아이디어 : 방법의 수는 dp로 점화식을 세웠을 때, A[n] = A[n-3] + A[n-2] + A[n-1]이다(N >=4)
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val case = br.readLine().toInt()
    val array = LongArray(1000001)
    array[1] = 1
    array[2] = 2
    array[3] = 4

    for(i in 4 until array.size){
        array[i] = (array[i-3] + array[i-2] + array[i-1]) % 1000000009
    }

    repeat(case){
        bw.write("${array[br.readLine().toInt()]}\n")
    }

    bw.flush()
    bw.close()
}