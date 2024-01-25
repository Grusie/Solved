package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Collections
import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.max

/**
 * 아이디어 : 1. 모든 요청이 배정될 수 있는 경우는 그대로 배정
 *          2. 그렇지 않은 경우, 정수 상한액을 계산
 *          예산 요청과, 전체 금액이 배정되었을 때, 합이 최대가 되는 방법에서 최댓값인 정수를 출력한다.
 *          값의 합 계산 후 비교, 배정 될 수 있으면 바로 최대값 출력, 아니라면, 1/n해서 나온 값보다 작은 것들을 더한 뒤 전체에서 빼고,
 *          나머지를 n/2해서 출력
 *          입력받을 때 최대값을 계속 넣는 형태로 해서 시간복잡도를 줄일 수 있음
 *
 * 시간복잡도 : N(1,000,000,000)
 *
 * 변수 : max, sum
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())

    var max = 0
    var sum = 0
    with(StringTokenizer(br.readLine())) {
        repeat(order){
            val item = nextToken().toInt()
            priorityQueue.add(item)
            sum += item
            if(max < item) max = item
        }
    }

    val total = br.readLine().toInt()

    if(sum > total) {
        max = 0
        var left = 0
        var right = priorityQueue.peek()
        while (left <= right) {
            val mid = (left + right) / 2
            var temp = 0
            for (i in priorityQueue) {
                if (i >= mid) temp += mid
                else temp += i
            }
            if (temp > total) {
                right = mid - 1
            } else {
                left = mid + 1
                max = max(max, mid)
            }
        }
    }

    bw.write("$max")

    bw.flush()
    bw.close()
}