package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.ceil

/**
 * 아이디어 : 굴다리의 길이만큼 boolean array를 만들고, 각 가로등 위치별로, 높이를 추가해가면서, true를 돌렸을 때,
 *          전부 true가 될 최소값을 구하면 된다.
 *
 *          2. 차이 중 젤 큰 값을 구한 뒤, 그 값 / 2 + 1 한 만큼을 출력
 *
 * 시간복잡도 :
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine().toInt()
    val order = br.readLine().toInt()
    val array = BooleanArray(size + 1){false}

    with(StringTokenizer(br.readLine())){
        repeat(order){
            array[nextToken().toInt()] = true
        }
    }

    var pre = -1
    var max = 0
    for(i in 0 .. array.lastIndex){
        if(array[i]) {
            if(pre == -1){
                max = 2 * i
            } else if(max < i - pre){
                max = i - pre
            }
            pre = i
        }
    }
    if((array.lastIndex - pre) > max){
        max = (array.lastIndex - pre) * 2
    }
    val result = if(pre == 0) size else ceil((max.toFloat() / 2)).toInt()

    bw.write("$result")

    bw.flush()
    bw.close()
}