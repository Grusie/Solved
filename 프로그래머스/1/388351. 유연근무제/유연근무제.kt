/**
 * 스케쥴 예상 직원들의 개수만큼 돌면서, timelogs가 그 내부에 해당하는지 확인
 * 주말을 제외하고 모든 평일에 지각을 하지 않았다면 상품을 줄 것 all로 처리 할 수 있을 듯
 * 주말이라는 것은? 이벤트 시작 날짜를 기준으로 하여, 6, 7 일 경우 주말
 */

class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0

        schedules.forEachIndexed { index, schedule ->
            var day = startday - 1
            if(timelogs[index].all {
                    day += 1
                    if(day == 8) day = 1
                    
                    if(day <= 5) {     //평일 일때에만 연산
                        var hour = schedule / 100
                        var minute = schedule % (hour*100)

                        hour += (minute + 10) / 60       //지각 최대 시간
                        minute = (minute + 10) % 60     //지각 최대 분
                        it <= hour * 100 + minute
                    } else {
                        true
                    }
            }) {
                answer += 1
            }
        }
        return answer
    }
}