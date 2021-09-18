package a133

/**
 * @author yueqiuhong
 * @date 2020-08-12 0:29
 */
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

class Solution {

    val map = mutableMapOf<Int, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }
        val n0 = map[node.`val`]
        if (n0 != null) {
            return n0
        }
        val nodeCopy = Node(node.`val`)
        map[node.`val`] = nodeCopy
        for (neighbor in node.neighbors) {
            nodeCopy.neighbors.add(cloneGraph(neighbor))
        }
        return nodeCopy
    }
}

fun main() {
    val n1 = Node(1)
    val n2 = Node(2)
    val n3 = Node(3)
    val n4 = Node(4)
    n1.neighbors = arrayListOf(n2, n4)
    n2.neighbors = arrayListOf(n1, n3)
    n3.neighbors = arrayListOf(n2, n4)
    n4.neighbors = arrayListOf(n1, n3)
    val cloneGraph = Solution().cloneGraph(n1)
    println(cloneGraph)
}