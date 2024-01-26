package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.system.exitProcess

/**
 * 아이디어 : 맨 앞에서 부터 돌았을 때, 그 사람이 먹을 수 있는 햄버거 중, 가장 앞에 있는 햄버거를 먹었을 때에
 *          가장 많은 사람이 먹을 수 있는 것 같다. 투포인터를 사용하여, 햄버거를 가리키는 포인터와, 사람을 가리키는 포인터를 나누고
 *          각각 햄버거/사람일 때 거리를 확인해서 가능하면, 햄버거+1, 사람 + 1, 불가능하면, 햄버거 + 1
 *
 * 시간복잡도 : ??
 *
 * 변수 : 햄버거/사람 배열, 포인터 두 개
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var (order, reach) = br.readLine().split(" ").map { it.toInt() }
    val table = br.readLine()

    var hamburger = -1
    var person = -1

    var count = 0

    fun printResult(){
        bw.write("$count")
        bw.flush()
        bw.close()
        exitProcess(0)
    }
    fun swiftPointer(hamburgerFlag: Boolean) {
        if (hamburgerFlag) {
            hamburger++
            try {
                while (table[hamburger] != 'H') {
                    hamburger++
                }
            }catch (e:Exception){printResult()}
        } else {
            person++
            try {
                while (table[person] != 'P') {
                    person++
                }
            }catch (e:Exception){printResult()}
        }
    }

    swiftPointer(true)
    swiftPointer(false)

    while (person != table.length) {
        if (abs(person - hamburger) <= reach) {
            count++
            swiftPointer(true)
            swiftPointer(false)
        } else {
            if (person > hamburger) {
                swiftPointer(true)
            } else swiftPointer(false)
        }
    }
    printResult()
}