import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 인덱스와, 배열을 가지고 처리
 *          배열을 변경하면서, KBS1, KBS2가 1,2 번째가 되면 종료
 *          2,3을 안 하고, 1,4만 이용해서도 풀 수 있을 것 같아 그렇게 했다.
 * 시간복잡도 : C
 * 변수 : 채널 배열, swap 위한 temp배열, 커서
 **/

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
fun main(){
    val order = br.readLine().toInt()
    val array = Array(order){""}

    repeat(order){
        array[it] = br.readLine()
    }

        val index1 = array.indexOf("KBS1")
        val index2 = array.indexOf("KBS2")
        moveCh(index1, false)
        if(index1 > index2)
            moveCh(index2 + 1) else moveCh(index2)

    bw.flush()
}

fun moveCh(channel: Int, second:Boolean = true){

    if (channel > 0) {
        repeat(channel) {
            bw.write("1")
        }
        repeat(if (second) channel - 1 else channel) {
            bw.write("4")
        }
    }
}