import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

private var length = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    length = br.readLine().toInt()

    dfs(0, "")
}

private fun dfs(depth: Int, num: String){
    if(depth == length){
        print(num)
        exitProcess(0)
    }

    for(i in 1..3) {
        if(check(num+i))
            dfs(depth + 1, num + i)
    }
}

private fun check(value: String) :Boolean{
    for(i in 1..value.length/2){
        if(value.substring(value.length-i*2 ,value.length -i) == value.substring(value.length - i, value.length))
            return false
    }
    return true
}
