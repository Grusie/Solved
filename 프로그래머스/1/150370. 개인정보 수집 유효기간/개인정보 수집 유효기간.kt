
import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * 문제 : 1 ~ N번으로 분류되는 개인정보 N개
 *      각 약관 별로, 보관 유효기간이 있음
 *      모든 달은 28일까지 있다고 가정
 *
 * 변수 : today -> 오늘 날짜(YYYY.MM.DD), terms -> 약관별 유효기간 ["A 6","B 12"..],
 *       privacies -> 약관 동의날짜와 약관 타입 ["2019.01.01 D", "2019.11.15 Z"]
 *       리턴 -> (파기할 약관들의 인덱스 번호 + 1)의 오름차순
 **/
class Solution {

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): ArrayList<Int> {
        val currentCal = Calendar.getInstance()
        val format = SimpleDateFormat("yyyy.MM.dd")
        currentCal.time = format.parse(today)

        val termsMap = HashMap<String, Int>()
        terms.forEach {
            val termsList = it.split(" ")
            val term = termsList[0]
            val period = termsList[1].toInt()

            termsMap[term] = period
        }
        val result = ArrayList<Int>()

        privacies.forEachIndexed { index, it ->
            val termsList = it.split(" ")
            val date = termsList[0].split(".")
            val term = termsList[1]

            var compareYear = date[0].toInt()
            var compareMonth = date[1].toInt()
            var compareDay = date[2].toInt()

            compareDay -= 1
            if (compareDay == 0) {
                compareMonth -= 1
                if (compareMonth == 0) {
                    compareYear -= 1
                    compareMonth = 12
                }
                compareDay = 28
            }

            compareYear += (compareMonth + termsMap[term]!!) / 12
            compareMonth = (compareMonth + termsMap[term]!!) % 12

            val compareCal = Calendar.getInstance()
            compareCal.set(Calendar.YEAR, compareYear)
            compareCal.set(Calendar.MONTH, compareMonth - 1)
            compareCal.set(Calendar.DAY_OF_MONTH, compareDay)
            compareCal.set(Calendar.HOUR, 0)
            compareCal.set(Calendar.MINUTE, 0)
            compareCal.set(Calendar.SECOND, 0)
            compareCal.set(Calendar.MILLISECOND, 0)

            println("${currentCal.time}, ${compareCal.time}")
            if (currentCal > compareCal) {
                result.add(index + 1)
            }
        }
        return result
    }
}