import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

/**
 * 아이디어 :
 *  1. 같은 수의 갯수와 해당 수를 Pair로 가져오기 -> 10자리 숫자 인덱스 배열에 개수를 담음
 *  2. 색상은 같을 경우(전부) -> true false
 *  3. 연속적인 수(전부) -> max 개수 1일 것이며, for문으로 뒤에 4개가 전부 1이여야 한다.
 * 시간복잡도 : 많아도 5개 뿐이라, 시간복잡도는 신경X
 * 변수 : 색상, 숫자 담을 변수 2개, 같은 숫자 개수와, 해당 숫자 Pair, 점수
 **/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var color = ""
    var number = Array(10) { 0 }
    var colorFlag = true

    repeat(5) {
        val line = br.readLine().split(" ")

        if (it == 0) color = line[0]

        if (it != 0 && colorFlag) {
            if (color != line[0])
                colorFlag = false
        }

        number[line[1].toInt()] += 1
    }



    bw.write("${calcScore(colorFlag, number)}")
    bw.flush()
}

fun calcScore(colorFlag: Boolean, number: Array<Int>): Int {
    var continueAll = true
    var score = 0

    //숫자가 전부 연속
    if(number.max() == 1) {
        for (i in number.indices) {
            if (number[i] == 1) {
                for(j in 1 until 5){
                    if(number[i+j] != 1){
                        continueAll = false
                        break
                    }
                }
                break
            }
        }
    } else continueAll = false

    val maxIndex = number.lastIndexOf(number.max())
    val second = number.indexOfFirst { it == 2 && number.indexOf(it) != maxIndex }
    //val second = secondMap[0]

    if(number.indexOf(2) != maxIndex) number.indexOf(2) else -1

    if (colorFlag) {  //모두 같은 색
        if (continueAll) return maxIndex + 900
        else score = maxIndex + 600
    }

    if(continueAll){
        score = max(score, maxIndex + 500)
    }

    return when (number.max()) {
        4 -> max(score,maxIndex + 800)
        3 -> {
            if(second != -1) max(score,maxIndex*10 + second + 700)
            else max(score,maxIndex + 400)
        }
        2 -> {
            if(second != -1){
                max(score,max(maxIndex, second) * 10 + min(maxIndex, second) + 300)
            } else max(score,maxIndex + 200)
        }

        else -> max(score,maxIndex + 100)
    }
}