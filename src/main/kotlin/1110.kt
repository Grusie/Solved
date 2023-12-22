import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 처음 들어온 값의 자리수를 더한 뒤, 그 더한 값의 마지막 숫자와, 새로운 수의 마지막 숫자를 더하는 것에 반복
 *          처음 숫자로 돌아왔을 때의 카운트 출력
 *          스트링으로 처리해도 될 거 같고, 100보다 작으니 10으로 나누어서 Int로 할 수도 있음 -> 10보다 작을 때에도 있으니, 10으로 나눠서 사용
 * 시간 복잡도 : C
 * 변수 : 처음 값 저장 변수, 양쪽을 더한 값 저장변수, 새로 만든 값의 합 저장 변수, 카운트
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val init = br.readLine()
    var count = 0

    var copyNumber = init

    while (true) {
        var calcNumber = copyNumber.toInt() / 10 + copyNumber.toInt() % 10
        copyNumber = "${copyNumber.toInt() % 10}${calcNumber % 10}"


        count++

        if(copyNumber.toInt() == init.toInt())
            break
    }

    bw.write("$count")
    bw.flush()
}