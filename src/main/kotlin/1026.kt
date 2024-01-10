import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.max

/**
 * 아이디어 : 마찬가지로 그리드 문제로서, 젤 큰 수가 있는 곳에, 젤 작은 수와 곱하면 된다.
 *          B를 재배치 하는 것이 안 되기에, A를 낮은순부터 정렬하고 B의 max값을 구하고,
 *          이미 지나간 B를 0으로 바꾸면 하면 될 것 같다.
 *
 * 시간복잡도 : NLogN
 *
 * 변수 : result, A, B
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val A = PriorityQueue<Int>()
    val B = IntArray(order)

    repeat(2) {target ->
        with(StringTokenizer(br.readLine())) {
            repeat(order) {
                if(target == 0) A.add(nextToken().toInt())
                else B[it] = nextToken().toInt()
            }
        }
    }

    var result = 0
    repeat(order){
        var max = 0
        var index = 0
        for(i in B.indices) {
            if(max < B[i]){
                max = B[i]
                index = i
            }
        }
        result += max * A.poll()
        B[index] = 0
    }
    bw.write("$result")

    bw.flush()
    bw.close()
}