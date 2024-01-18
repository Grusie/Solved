package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 최대값보다 남은 두 수의 합이 작으면 삼각형이 안 됨, 그게 아닐경우, 두 변의 합이 같으면 이등변
 *          전부 같으면 정삼각형, 아니면 그냥 삼각형
 *
 *
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while(true){
        val input = br.readLine()
        if(input == "0 0 0") break

        val array = input.split(" ").map { it.toInt() }

        if(array.sum() - array.max() <= array.max()){
            bw.write("Invalid\n")
            continue
        }

        when(array.count { it == array[0] }){
            1 -> {
                if(array.count { it == array[1] } == 2)
                    bw.write("Isosceles\n")
                else
                    bw.write("Scalene\n")
                continue
            }
            2 -> {
                bw.write("Isosceles\n")
                continue
            }
            3 -> {
                bw.write("Equilateral\n")
                continue
            }
        }
    }
    bw.flush()
    bw.close()
}