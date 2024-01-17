package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.sqrt

/**
 * N <= 100만, 소수, 팰린드롬 증 가장 작은 수
 * 1. 아이디어
 * - 구현
 * - 소수 : 각 수의 제곱근으로 나누었을 때, 몫이 없는 수
 * - 팰린드롬 수 : 스택에 넣었다가 뺐을 때, 기존과 동일한 수
 *
 * 2. 시간 복잡도
 * - 소수를 구하기 위한 C   logN
 * - 팰린드롬인지 확인 C    자릿수
 * - logN
 * 3. 변수
 * - 선정한 숫자
 * - 스택
 * - 출력
 **/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var num = br.readLine().toInt() - 1
    while (true) {
        num++
        if(num == 1) continue
        val tempNum = num
        var flag = false
        for (i in 2 until sqrt(tempNum.toDouble()).toInt() + 1) {
            if (num % i == 0) {
                flag = true
                break
            }
        }
        if (flag) continue
        else {
            val stack = Stack<Char>()
            var temp =""

            num.toString().forEach {
                stack.push(it)
            }
            repeat(stack.size) {
                temp += stack.pop()
            }
            if(temp.toInt() == num){
                bw.write(temp)
                bw.flush()
                break
            }
        }
    }
}