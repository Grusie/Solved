package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 아이디어 : 처음 입장한 플레이어 -10 ~ +10 입장 가능, 정원이 찰 때까지 대기
 *          갈 수 있는 방이 여러개라면, 먼저 생성된 방에 입장, 방에 정원이 다 차면 게임 시작
 *          레벨을 받아서, 만약 이미 있는 방에서 레벨이 맞지 않으면 새로운 방을 만든다.
 *          방의 data class를 작성하자(방 순서, 레벨 범위, 시작상태, 레벨 - 유저 닉네임)
 *
 * 시간복잡도 : 전체넣기(N), 유저 닉네임 소팅 logN
 *
 * 변수 : dataClass(방순서Int, 레벨 범위(최소Int,최대Int), 시작상태(Boolean), 레벨 - 유저 닉네임Map<String,Int>)
 **/
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (userCnt, maxCnt) = br.readLine().split(" ").map { it.toInt() }

    val roomArray = mutableListOf<Room>()

    repeat(userCnt){
        val item = br.readLine().split(" ")
        val level = item[0].toInt()
        val name = item[1]

        var flag = true
        for(room in roomArray) {
            if(!room.start) {
                if (level in (room.min..room.max)) {
                    flag = false
                    room.array[name] = level
                    if (room.array.size == maxCnt) {
                        room.start = true
                    }
                    break
                }
            }
        }
        if(flag){
            roomArray.add(Room(order = roomArray.size, max = level + 10, min = level - 10).apply {
                array[name] = level
                if (maxCnt == 1) {
                    start = true
                }
            })
        }
    }

    roomArray.forEach {room ->
        val result = room.array.toList().sortedBy { it.first }
        bw.write("${if(room.start) "Started!" else "Waiting!"}\n")
        result.forEach{ info ->
            bw.write("${info.second} ${info.first}\n")
        }
    }
    bw.flush()
    bw.close()
}

data class Room(
    val order: Int = 0,
    val min: Int = 0,
    val max: Int = 0,
    var start: Boolean = false,
    val array: HashMap<String, Int> = HashMap()
)