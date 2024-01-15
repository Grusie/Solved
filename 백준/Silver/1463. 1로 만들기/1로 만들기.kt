import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Collections.min

/**
 * 아이디어 : 소인수분해같은 느낌인데, 큰 수를 사용하는 것이 무조건 적게 나올테니,
 *          3으로나눌 수 없을 떄 까지 나누고, 2도 마찬가지, 그 이후로 1을 빼서 1을만든다.
 *
 * 문제 이해 다시 : 백트래킹을 사용해야겠다.
 *
 * 시간복잡도 : log3^N + log2^N , N!
 *
 * 변수 : 처음 값, temp값, count
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val dp = Array(order + 1){0}

    for(i in 2 .. order){
        dp[i] = dp[i - 1] + 1

        if(i % 3 == 0){
            dp[i] = kotlin.math.min(dp[i], dp[i/3] + 1)
        }
        if(i %2 == 0){
            dp[i] = kotlin.math.min(dp[i], dp[i/2] + 1)
        }
    }

    bw.write("${dp[order]}")
    bw.flush()
    bw.close()
}