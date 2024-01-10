import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 입력 : line1 : 테스트케이스 수, line2 : 전화번호 수, lineN : 전화번호들
 *
 * 아이디어 : 각 전화번호에 겹치는 전화번호들이 들어있는지 판단하는 것
 *          전화번호의 길이는 길어야 10이기에, 백트래킹을 생각해볼 수 있을 것 같다.
 *          짧은 길이의 전화번호를 긴 길이의 전화번호에 속하는지 contains로도 문제해결이 가능 할 것 같은데..
 *          array sortBy로 사이즈로 sort를 하고 들어있는지 비교해보면 가능할 듯 하다
 *          contains는 포함하고 있냐이기에, 맨 앞부터 확인해야해서 루푸를 도는 게 맞을 거 같다.
 *
 * 아이디어2 : 그냥 string정렬로 하고, 그럼 비슷한 애들끼리 붙어있을테니, 바로 뒤에 자리만 판단하면 된다.
 *
 * 시간 복잡도 : 정렬 NLogN, testCase : 50, N(전화번호 수) : 10000, 최대 10자리, N!
 *
 * 변수 : 전체 array, 테스트케이스, 전화번호 수,
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val case = br.readLine().toInt()

    repeat(case){
        val order = br.readLine().toInt()
        val array = Array(order){ br.readLine() }

        array.sort()

        var flag = false
        for(i in array.indices){
            if(i == array.lastIndex)
                break

            if(array[i + 1].startsWith(array[i])) {
                flag = true
                break
            }
        }
        if(!flag){
            bw.write("YES\n")
        } else bw.write("NO\n")
    }

    bw.flush()
    bw.close()
}