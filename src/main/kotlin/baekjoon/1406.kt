package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 아이디어 : 주어진 방법대로 처리 해두도록하차, 커서는 index, 값은 삽입 삭제가 간편해야 하므로
 *          mutableList로 구현해보자 리스트는 삽입 삭제 시간 때문에 시간초과가 난다.
 *          스택을 이용해서 풀어야 한다고 한다.
 *
 * 시간복잡도 : N
 *
 * */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val leftStack = Stack<Char>()
    val rightStack = Stack<Char>()

    br.readLine().forEach {
        leftStack.push(it)
    }

    val order = br.readLine().toInt()

    repeat(order){
        with(StringTokenizer(br.readLine())) {
            when (nextToken()) {
                "L" -> {
                    if(leftStack.isNotEmpty()) rightStack.push(leftStack.pop())
                }

                "D" -> {
                    if(rightStack.isNotEmpty()) leftStack.push(rightStack.pop())
                }

                "B" -> {
                    if(leftStack.isNotEmpty()) leftStack.pop()
                }

                "P" -> {
                    leftStack.push(nextToken()[0])
                }
            }
        }
    }

    leftStack.forEach {
        bw.write("$it")
    }
    repeat(rightStack.size){
        bw.write("${rightStack.pop()}")
    }


    bw.flush()
    bw.close()
}