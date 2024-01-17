package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

/**
 * 아이디어 : 소수들을 미리 만들어 두고, 두개의 합에 해당하는 수의 미만인 값들 중에서, 두 수의 합이 같은지 판단한다.
 *          맨 왼쪽과 오른쪽을 차례로 진행하면서 값보다 크면, 오른쪽을 한 칸 줄이고, 작으면 왼쪽을 늘리는 식으로 하면 될 것 같다.
 *
 * 시간복잡도 : T(테스트케이스) * N(최대 A,B값) * 2 + 소수 구하기(2024)
 *
 * 변수 : 좌우 포인터, 소수들, 두 수의 합(A+B), 두 소수의 합
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = BooleanArray(2000000 + 1){false}

    for(i in 2 until numbers.size){
        val sqrt = sqrt(i.toFloat()).toInt()
        var flag = true
        for(j in 2 .. sqrt){
            if(i % j == 0){
                flag = false
                break
            }
        }
        if(flag) numbers[i] = true
    }

    val order = br.readLine().toInt()
    repeat(order){
        val (a,b) = br.readLine().split(' ').map { it.toLong() }
        val goal = a + b

        val start = 4L

        var sqrtStart = sqrt(start.toDouble()).toInt()
        var sqrtEnd = sqrt(goal.toDouble()).toInt() - 1

        while(sqrtStart < sqrtEnd){

            if(!numbers[sqrtStart]) sqrtStart++
            if(!numbers[sqrtEnd]) sqrtEnd--

            if(numbers[sqrtStart] && numbers[sqrtEnd]){
                if(sqrtStart + sqrtEnd > goal){
                    sqrtEnd--
                }
                else if(sqrtStart + sqrtEnd < goal){
                    sqrtStart++
                }
                else {
                    bw.write("YES \n")
                    bw.flush()
                    return@repeat
                }
            }
        }
        bw.write("NO \n")
        bw.flush()
    }

    bw.close()
}