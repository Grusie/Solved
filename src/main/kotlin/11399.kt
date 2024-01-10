import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import java.util.StringTokenizer

/**
 * 아이디어 : 그리디문제, 그냥 시간이 낮은 순서대로 sort한 뒤, 이전까지 값의 합을 더하면 되는 것 같다.
 *          이전값을 계속 추가하지말고, 더한 값을 따로 저장해둔 뒤 최신것만 더해가면서 결과를 출력해주자
 *
 * 시간복잡도 : NLogN (sort)
 *
 * 변수 : result, array
 **/

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = PriorityQueue<Int>()

    with(StringTokenizer(br.readLine())){
        repeat(order){
            array.add(nextToken().toInt())
        }
    }

    var result = 0
    var pre = 0
    repeat(order){
        val item = array.poll()
        result += pre + item
        pre += item
    }

    bw.write("$result")

    bw.flush()
    bw.close()
}