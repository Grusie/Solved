import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer


/**
 * 아이디어 : 일단 위치가 순서대로 오지 않을 것이라는 생각에 sort를 진행해주고,
 *          양쪽으로 0.5만큼씩이기에, 제일 작은 값에 -0.5(A) ~ A+size 까지 테이프를 붙히고,
 *          A+size 보다 큰 부분을 다시 처리하면 될 것 같다.(무조건 0.5단위로 붙히고, 자연수 기준이기에)
 *
 * 시간복잡도 : NLogN(sort)
 *
 * 변수 : 테이프의 마지막 붙힌 값, count, array, 테이프 사이즈
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (order, size) = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(order)
    with(StringTokenizer(br.readLine())){
        repeat(order){
            array[it] = nextToken().toInt()
        }
    }

    array.sort()
    var tape = 0
    var count = 0
    for(i in array.indices){
        if(tape < array[i]){
            count++
            tape = array[i] + size - 1
        }
    }

    bw.write("$count")

    bw.flush()
    bw.close()
}