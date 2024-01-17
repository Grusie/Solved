package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.system.exitProcess

/**
 * 아이디어 : (전체 수의 절반까지) 임의의 수만큼 잘랐을 때, 그 뒷부분과 같냐를 구별하면 된다.
 *          전체를 돌면서 같은 게 없으면 좋은 수열, 하나라도 있으면 break 나쁜수열
 *          개수 C(1~N/2), 숫자 i : (i<= ~ <i+N), 비교할 숫자 k : (i+N<= ~ <i+N+N)
 *          비교
 *          1,2,3 중에 가장 작은 걸
 *          1. 선택 하지만 한 번 선택한 걸 바로는 선택 못함
 *          2. 선택한 값을 result에 합쳤을 때 위에 조건을 만족하지 않아야 함
 *
 *
 * 시간복잡도 : C : 1 ~ N/2까지 반복, C만큼 반복해서, 숫자와 비교할 숫자 구함
 *            N/2 * N/2 -> N^2
 *
 * 변수 : 숫자C, 배열, flag
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()

    fun check(numbers:String):Boolean{
        for(i in 1 .. (numbers.length/2)) {
            if (numbers.substring(numbers.length -i, numbers.length) == numbers.substring(numbers.length - 2* i ,numbers.length - i))
                return false
        }
        return true

    }

    fun dfs(init:String, depth: Int){
        if(depth == order){
            bw.write(init)
            bw.flush()
            bw.close()
            exitProcess(0)
        }

        for(i in 1 ..3){
            if(check(init + i))
            dfs(init + i, depth + 1)
        }
    }

    dfs("", 0)
}