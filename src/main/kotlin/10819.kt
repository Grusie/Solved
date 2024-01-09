import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs


/**
 * 아이디어 : 각 두 수의 차이를 최대로 만드는 문제이다.
 *          각 숫자 별로, 차이가 가장 큰 값들을 구한 뒤, 주어진 식에 맞게 계산을 하면 될 것 같다.
 *          포문을 돌면서, visited를 비교하여 차이가 가장 큰 값을 구하자
 *
 * 시간복잡도 : N^2
 *
 * 변수 : 전체 차이, visited배열, 전체 배열
 *
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val array = IntArray(order)
    val visited = BooleanArray(order) { false }

    with(StringTokenizer(br.readLine())) {
        repeat(order) {
            array[it] = nextToken().toInt()
        }
    }

    var result = 0
    val tempArray = IntArray(order)

    fun dfs(depth: Int = 0) {
        if (depth == order) {
            var sum = 0

            repeat(order - 1) {
                sum += abs(tempArray[it] - tempArray[it + 1])
            }
            result = result.coerceAtLeast(sum)
        }

        repeat(order) {
            if (!visited[it]) {
                visited[it] = true
                tempArray[depth] = array[it]
                dfs(depth + 1)
                visited[it] = false
            }
        }
    }

    repeat(order) {
        dfs()
    }

    bw.write("$result")
    bw.flush()
}