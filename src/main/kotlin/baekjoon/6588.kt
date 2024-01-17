package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 주어진 짝수보다 작은 홀수 소수들을 구한 뒤, 두 수의 합이 주어진 수와 같으면 출력
 *          b-a가 젤 크려면, b는 젤 뒤, a는 맨 앞이여야 하므로, 투 포인터로 접근
 *          만약 없다면, Goldbach's conjecture is wrong. 출력
 *
 * 시간복잡도 : (소수 구하기), 투포인터로 값 구하기 N^2 (최악)
 *
 * 변수 : 포인터 두개, 홀수 소수 배열, 합
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val array = BooleanArray(1000001) { true }
    for(i in 2 until array.size){
        if(array[i]){
            for(j in i * 2 until array.size step i)
                array[j] = false
        }
    }

    while (true) {
        val order = br.readLine().toInt()
        if(order == 0) break

        var left = 3
        var right = order - 3
        while (left <= right) {
            if (array[left] && array[right]) {
                bw.write("$order = $left + $right\n")
                bw.flush()
                break
            }
            left += 2
            right -= 2
        }
    }
    bw.close()
}