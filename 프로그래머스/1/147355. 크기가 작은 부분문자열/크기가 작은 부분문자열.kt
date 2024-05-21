/**
 * 문제 : p의 갯수와 같은 갯수를 가진 t의 숫자 중, p보다 작거나 같은 수의 개수
 *
 * 변수 : 1<= p의 길이 <=19 P의 길이 <= T의 길이 <= 10,000
 **/
class Solution {
    fun solution(t: String, p: String): Int {
        var count: Int = 0

        var start = 0
        var end = p.length

        while(end <= t.length){
            val value = t.substring(start, end).toBigInteger()
            if(value <= p.toBigInteger()){
                count++
            }
            start++
            end++
        }

        return count
    }
}