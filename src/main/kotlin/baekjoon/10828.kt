package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 아이디어 : 스택 구현, 만약 스택에 없는데 pop을 할 경우 -1 출력
 * top도 만약 없다면, -1출력
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val order = br.readLine().toInt()
    val stack = Stack<Int>()

    repeat(order) {
        with(StringTokenizer(br.readLine())) {
            when (nextToken()) {
                "push" -> stack.push(nextToken().toInt())
                "top" -> bw.write("${if (stack.isNotEmpty()) stack.peek() else -1}\n")
                "size" -> bw.write("${stack.size}\n")
                "empty" -> bw.write("${if (stack.isEmpty()) 1 else 0}\n")
                else -> bw.write("${if (stack.isNotEmpty()) stack.pop() else -1}\n")
            }
        }
    }

    bw.flush()
    bw.close()
}