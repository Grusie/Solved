package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 단어가 자주나올수록, 길이가 길수록, 사전순으로 앞일수록
 *          단어의 길이가 m보다 긴 단어만 적을 것, Hashmap을 사용하여, 각 단어와 수를 저장할 것
 *
 * 시간복잡도 : N^2
 *
 * 변수 : HashMap
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (order, length) = br.readLine().split(" ").map { it.toInt() }
    val hashMap = HashMap<String,Int>()

    repeat(order){
        val key = br.readLine()
        if(key.length >= length)
            hashMap[key] = hashMap.getOrDefault(key, 0) + 1
    }

    val map = hashMap.entries.sortedWith(kotlin.Comparator { o1, o2 ->
        when {
            o1.value != o2.value -> {
                o2.value.compareTo(o1.value)
            }
            o1.key.length != o2.key.length -> {
                o2.key.length - o1.key.length
            }
            else -> {
                o1.key.compareTo(o2.key)
            }
        }
    })

    map.forEach{
        bw.write("${it.key}\n")
    }

    bw.flush()
    bw.close()
}