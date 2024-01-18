package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * 아이디어 : 주어진 연산을 각각 구현해서 출력해주면 될 것 같다.
 *          1~20이 있냐 없냐 구분하는 형태의 문제들이기에, boolean배열로 할 수 있을 것 같다.
 *
 * 시간복잡도 : N
 *
 * 변수 : array
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()

    val array = BooleanArray(21){false}

    repeat(order){
        with(StringTokenizer(br.readLine())){
            when (nextToken()) {
                "add" -> {
                    array[nextToken().toInt()] = true
                }
                "check" -> {
                    bw.write("${if(array[nextToken().toInt()]) 1 else 0}\n")
                }
                "remove" -> {
                    array[nextToken().toInt()] = false
                }
                "toggle" -> {
                    val index = nextToken().toInt()
                    array[index] = !array[index]
                }
                "all" -> {
                    array.fill(true)
                }
                else -> {
                    array.fill(false)
                }
            }
        }
    }

    bw.flush()
    bw.close()
}