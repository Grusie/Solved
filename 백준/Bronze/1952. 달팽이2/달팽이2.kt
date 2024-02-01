package baekjoon
import java.util.*
import java.io.*
import kotlin.system.exitProcess

/**
 * 아이디어 : 4방향을 가지고, 벽이나, 이미 지나온 곳을 만나면 방향을 바꿔준다.
 *          방향을 바꿨는데에도 벽이나 이미 지나온 곳이면, 끝을 낸다.
 *          뱡향을 바꿀 때 마다 count 증가
 * */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (height, width) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(height){Array(width){false} }

    val dx = arrayOf(1,0,-1,0)
    val dy = arrayOf(0,1,0,-1)

    var direction = 0
    var count = 0

    var x = 0
    var y = 0
    array[0][0] = true
    var sum = 1

    while (true) {
        if(sum == height * width) break
        try {
            if(!array[y + dy[direction]][x + dx[direction]]){
                y += dy[direction]
                x += dx[direction]
                array[y][x] = true
                sum++
            } else {
                direction = (direction + 1) % 4
                count++
            }
        }catch (e:Exception){
            direction = (direction + 1) % 4
            count++
        }
    }

    bw.write("$count")
    bw.flush()
    bw.close()
}