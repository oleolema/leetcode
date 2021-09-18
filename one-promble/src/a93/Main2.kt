package a93

/**
 * @author yueqiuhong
 * @date 2020-08-08 18:38
 */


class Solution {

    private val SEG_COUNT = 4
    lateinit var s: String
    var set: MutableSet<String> = mutableSetOf()
    var list = Array(SEG_COUNT) { "0" }

    private fun notIp(s: String): Boolean {
        if (s.length > 3 || s.isEmpty()) return true
        val a = s.toInt()
        return a > 255 || (s.length > 1 && s[0] == '0')
    }

    fun restoreIpAddresses(s: String): List<String> {
        this.s = s
        dfs(0, 0)
        return set.toList()
    }


    fun dfs(start: Int, seg: Int) {
        if (seg == SEG_COUNT - 1) {
            val s4 = s.substring(start)
            if (notIp(s4)) return
            list[seg] = s4
            set.add(list.joinToString("."))
            return
        }
        for (end in start + 1..start + 3) {
            if (end > s.length) break
            var str = s.substring(start, end)
            if (notIp(str)) break
            list[seg] = str;
            dfs(end, seg + 1)
        }
    }

}

/**
1 2 3 456
1 2 34 56
1 2 345 6
1 23 4 56
1 23 45 6
12 3 4 56
12 3 45 6
 */
fun main() {

    val restoreIpAddresses = Solution().restoreIpAddresses("1111")
    println(restoreIpAddresses)
}