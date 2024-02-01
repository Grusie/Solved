import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var sum = 0
    var array = Array(11){0}

    array[0] = 1
    array[1] = 2
    array[2] = 4

    for (i in 0 until br.readLine().toInt()) {
        sum = br.readLine().toInt()
        for(i in 3 until array.size-1){
            array[i] = array[i-3] + array[i-2] + array[i-1]
        }
        bw.write("${array[sum-1]}\n")
    }
    br.close()
    bw.flush()
    bw.close()
}

