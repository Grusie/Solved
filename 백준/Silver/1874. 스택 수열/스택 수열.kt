package baekjoon

import java.util.*
import java.io.*
import kotlin.system.exitProcess

/**
 * 아이디어 : order까지의 배열을 만들어두고, 해당 값까지 넣으면서 배열의 boolean값을 변경해줌, push를 하려는데, 해당 값이 false이면
 *          NO출력 아니면 여태 한 것들 저장
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val stack = Stack<Int>()
    val result = mutableListOf<Boolean>()

    var start = 0

    repeat(order){
        val item = br.readLine().toInt()

        if(item > start){
            for(i in start + 1 .. item){
                stack.push(i)
                result.add(true)
            }
            start = item
        } else {
            if(stack.peek() != item) {
                bw.write("NO")
                bw.flush()
                bw.close()
                exitProcess(0)
            }
        }

        stack.pop()
        result.add(false)

    }
    result.forEach {
        bw.write(if(it) "+\n" else "-\n")
    }

    bw.flush()
    bw.close()
}