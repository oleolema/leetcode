# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def isBalanced(self, root: TreeNode) -> bool:
        return self.dfs(root) != -1

    def dfs(self, root: TreeNode) -> int:
        if root is None:
            return 0
        left_floor = self.dfs(root.left)
        right_floor = self.dfs(root.right)
        print(left_floor, right_floor)
        if abs(left_floor - right_floor) > 1 or left_floor == -1 or right_floor == -1:
            return -1
        return max(left_floor, right_floor) + 1
