package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 맨 윗 줄 부터 찾아보면서, *이 나오면 그 곳이 머리, 심장의 위치는 그 아래이므로 y+1 (좌표가 1,1부터이므로 +1씩)
 *          줄을 내려갔을 때, 심장위치까지 있는 게 왼쪽 팔, 그 이후가 오른쪽 팔
 *          그 밑으로는 허리, 허리의 y 좌표를 기억해뒀다가, 그 y랑 다른 곳이 나오면, 허리 카운트 끝
 *          허리보다 작은 x값이면 왼쪽다리 반대면 오른쪽 다리를 각각 더해준다.
 *
 * 시간복잡도 : N^2
 *
 * 변수 : 전체 배열, 구해야 할 값들 배열(5), cnt, y값 저장
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()

    val array = Array(order) { BooleanArray(order) }
    repeat(order) {
        array[it] = br.readLine().map { c -> c == '*' }.toBooleanArray()
    }

    val resultArray = arrayOf(-1, -1, 0, 0, 0, 0, 0)

    for (y in array.indices) {
        for (x in array.indices) {
            if(array[y][x]) {
                if (resultArray[0] == -1) {
                    resultArray[0] = y + 1
                    resultArray[1] = x
                } else if (y == resultArray[0]) {
                    if (x < resultArray[1]) resultArray[2]++
                    else if(x > resultArray[1]) resultArray[3]++
                } else if (x == resultArray[1]) {
                    resultArray[4]++
                } else {
                    if( x < resultArray[1]) resultArray[5]++
                    else resultArray[6]++
                }
            }
        }
    }
    bw.write("${resultArray[0] + 1} ${resultArray[1] + 1}\n")
    bw.write("${resultArray[2]} ${resultArray[3]} ${resultArray[4]} ${resultArray[5]} ${resultArray[6]}")

    bw.flush()
    bw.close()
}