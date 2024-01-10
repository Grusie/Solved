import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


/**
 * 입력 : line1: 구멍의 너비, line2: 레고 조각의 수, 레고의 수 만큼 레고의 크기
 *
 * 아이디어 : 구멍이 두 개 이므로, 한 개를 고르고, 다른 것들 중 합이 구멍의 너비와 같은 걸 구하고
 *          만약 같다면, 저장해뒀다가, 여러개일 때, 차이를 구해서 출력
 *          정렬을 한 뒤에, 맨위와 맨 아래에서부터 합을 구하다 보면 조금 더 빨리 할 수 있을 것 같다.
 *
 * 맞는 것 같은데 계속 틀렸대서 답을 보고, 투포인터로 해본다.
 *
 * 시간 복잡도 : N^2, 시간복잡도가 많이 나와 고민해본 결과, 정렬을 한 뒤, 이분 탐색을 진행하면 시간 복잡도가 작게 나올 듯 하다
 *
 * 변수 : 구멍의 너비, 레고 조각의 수, 레고의 크기를 담을 배열, 답을 담을 배열(Int로 하고 너비에서 - 해서 나머지를 해보자)
 **/


//뭐가 틀린지 모르겠다. 똑같이했는데
/*fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var line0 :String? = null
    while(br.readLine().also { line0 = it } != null) {
        val goal = line0!!.toInt() * 10000000
        val order = br.readLine().toInt()

        val array = IntArray(order)
        for(i in 0 until order){
            array[i] = br.readLine().toInt()
        }

        array.sort()

        var start = 0
        var end = order - 1

        var flag = false
        while(start < end){
            val sum  = array[start] + array[end]

            if(sum == goal) {
                bw.write("yes ${array[start]} ${array[end]}\n")
                flag = true
                break
            }
            if(sum > goal)
                end--
            else start++
        }

        if(!flag) {
            bw.write("danger")
        }
        line0 = null
    }
    bw.close()
}*/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var s: String? = null
    while (br.readLine().also { s = it } != null) {
        val size = s!!.toInt() * 10000000
        val n = br.readLine().toInt()
        val list = IntArray(n)
        for (i in 0 until n) {
            list[i] = br.readLine().toInt()
        }
        list.sort()
        var left = 0
        var right = n - 1
        var flag = false
        while (left < right) {
            val sum = list[left] + list[right]
            if (sum == size) {
                System.out.printf("yes %d %d\n", list[left], list[right])
                flag = true
                break
            } else if (sum > size) {
                right--
            } else {
                left++
            }
        }
        if (!flag) {
            println("danger")
        }
        s = null
    }
}