class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {

        var posStamp = getTimeStamp(pos)
        val startStamp = getTimeStamp(op_start)
        val endStamp = getTimeStamp(op_end)
        val videoLenStamp = getTimeStamp(video_len)

        posStamp = skipOpen(posStamp, startStamp, endStamp)
        commands.forEach {
            if(it == "next") {
                posStamp = if(videoLenStamp - posStamp > 10) posStamp + 10
                else videoLenStamp
            }
            if(it == "prev") {
                posStamp = if(posStamp > 10) posStamp - 10
                else 0
            }
            posStamp = skipOpen(posStamp, startStamp, endStamp)
        }

        return String.format("%02d:%02d", posStamp / 60, posStamp % 60)
    }

    private fun getTimeStamp(time: String): Int {
        return time.split(":").let {
            it[0].toInt() * 60 + it[1].toInt()
        }
    }

    private fun skipOpen(posStamp:Int, startStamp: Int, endStamp: Int): Int {
        return if(posStamp in startStamp..endStamp) endStamp else posStamp
    }
}