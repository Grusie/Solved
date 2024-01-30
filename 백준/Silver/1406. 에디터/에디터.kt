import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st : StringTokenizer
    var result = br.readLine()
    val stackL = Stack<Char>()
    val stackR = Stack<Char>()
    result.forEach {
        stackL.add(it)
    }

    for( i in 0 until br.readLine().toInt()) {
        st = StringTokenizer(br.readLine())
        try {
            when (st.nextToken()) {
                "P" -> {
                    stackL.add(st.nextToken().toCharArray()[0])
                }
                "D" ->
                    stackL.add(stackR.pop())
                "L" ->
                    stackR.add(stackL.pop())
                "B" ->
                    stackL.pop()
            }
        } catch (e: java.lang.Exception) {
        }
    }
    bw.write(stackL.toCharArray() + stackR.toCharArray().reversed())
    br.close()
    bw.flush()
    bw.close()
}