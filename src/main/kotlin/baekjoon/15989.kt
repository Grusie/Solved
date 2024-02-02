package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : a[n]의 값들은 K : 1 ~ 3 일때 a[n-k] + k의 값들이다. 하지만 중복을 없애야하기에,
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val case = br.readLine().toInt()
    val array = Array(10001){ IntArray(4) }

    array[1][1] = 1
    array[2][1] = 1
    array[2][2] = 1
    array[3][1] = 1
    array[3][2] = 1
    array[3][3] = 1

    for(i in 4 until array.size){
        array[i][1] = array[i-1][1]
        array[i][2] = array[i-2][1] + array[i-2][2]
        array[i][3] = array[i-3][1] + array[i-3][2] + array[i-3][3]
    }

    repeat(case){
        val goal = br.readLine().toInt()
        bw.write("${array[goal][1] + array[goal][2] +array[goal][3]}\n")
    }

    bw.flush()
    bw.close()
}