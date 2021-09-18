package a93

/**
 * @author yueqiuhong
 * @date 2020-08-08 18:38
 */


class Solution1 {

    private fun notIp(s: String): Boolean {
        if (s.length > 3) return true
        val a = s.toInt()
        return a > 255 || a.toString() != s
    }

    fun restoreIpAddresses(s: String): List<String> {
        val set = mutableSetOf<String>()
        for (i in 0..s.length - 3) {
            val a = s.substring(0, i + 1)
            if (notIp(a)) break
            for (j in i + 1 until s.length - 2) {
                val b = s.substring(i + 1, j + 1)
                if (notIp(b)) break
                for (k in j + 1..s.length - 1) {
                    val c = s.substring(j + 1, k + 1)
                    if (notIp(c) || k == s.length - 1) break
                    val d = s.substring(k + 1, s.length)
                    if (notIp(d)) continue
                    set.add("$a.$b.$c.$d")
                }
            }
        }
        return set.toList()
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

    val restoreIpAddresses = Solution1().restoreIpAddresses("00011")
    println(restoreIpAddresses)
}