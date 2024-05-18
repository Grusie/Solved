/**
문제
1. 선물을 주고받은 기록이 있으면, 더 많이 준 사람이 받는다.
2. 기록이 없거나 기록이 같으면, 선물지수를 비교한다.
3. 선물지수란, 보낸선물 - 받은선물이고, 높은 사람이 받는다.
4. 만약 전부 같다면 주고받지 않는다.

변수
friends 친구들의 이름을 담음(2<= <=50)
gifts 선물 기록을 담음(1<= <=10000)
- (선물 준, 선물 받은)


가장 많이 받은 사람의 수를 리턴하기 위해, 각각 최대를 담아둔다.
이름 별로 몇 번의 선물을 받을 수 있는지 비교한다.
여러 번 도는 것은 좋지 않으니, friends의 개수 만큼 배열을 만들고, count를 증가시킨 후
그 안에서 젤 많은 개수를 출력해보자
 */
class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val hashMaps = HashMap<String, HashMap<String, Int>>()
        
        friends.forEach {
            hashMaps[it] = HashMap()
        }

        val giveHm = HashMap<String, Int>()
        val takeHm = HashMap<String, Int>()

        for(gift in gifts) {
            val split = gift.split(" ")
            val give = split[0]
            val take = split[1]

            hashMaps.get(give)!!.put(take, hashMaps.get(give)!!.getOrDefault(take, 0) + 1)

            giveHm[give] = giveHm.getOrDefault(give, 0) + 1
            takeHm[take] = takeHm.getOrDefault(take, 0) + 1
        }

        val resultHashMap = HashMap<String, Int>()

        for(i in friends.indices) {
            for(j in 0 until i) {
                val friend1 = friends[i]
                val friend2 = friends[j]

                val number1 = hashMaps[friend1]!!.getOrDefault(friend2,0)
                val number2 = hashMaps[friend2]!!.getOrDefault(friend1,0)

                if(number1 > number2) {
                    setHash(resultHashMap, friend1)
                } else if (number1 < number2){
                    setHash(resultHashMap, friend2)
                } else {
                    val score1 = giveHm.getOrDefault(friend1, 0) - takeHm.getOrDefault(friend1, 0)
                    val score2 = giveHm.getOrDefault(friend2, 0) - takeHm.getOrDefault(friend2, 0)

                    if (score1 > score2) {
                        setHash(resultHashMap, friend1)
                    } else if (score1 < score2) {
                        setHash(resultHashMap, friend2)
                    }
                }
            }
        }

        return resultHashMap.values.maxOrNull() ?: 0
    }

    private fun setHash(hash: HashMap<String, Int>, target: String){
        hash[target] = hash.getOrDefault(target,0) + 1
    }
}