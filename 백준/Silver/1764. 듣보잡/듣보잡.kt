import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.HashSet
import java.util.PriorityQueue

/**
 * 아이디어 : 스트링 입출력 기본 문제인 것 같다
 *          들어오는대로 배열에 저장하고, N+2 번째 줄부터, contains로 비교하여, 결과배열에 넣는다.
 *          결과배열은 priority list로 하면 좋을 듯 하다
 *
 * 시간복잡도 : contains를 사용하기에, N*M -> 250,000,000,000 <- 시간복잡도 초과
 *
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val hashSet = HashSet<String>()
    repeat(N){
        hashSet.add(br.readLine())
    }

    val result = ArrayList<String>()

    repeat(M){
        val item = br.readLine()
        if(hashSet.contains(item))
            result.add(item)
    }

    result.sort()

    bw.write("${result.size}\n")
    result.forEach {
        bw.write("$it\n")
    }
    bw.flush()

    bw.close()
}