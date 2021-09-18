# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    a = []

    def sortedListToBST(self, head: ListNode) -> TreeNode:
        while head is not None:
            self.a.append(head.val)
            head = head.next
        return self.dfs(0, len(self.a))

    def dfs(self, x: int, y: int) -> TreeNode:
        if y <= x:
            return None
        mid = int((y - x) / 2) + x
        t = TreeNode(val=self.a[mid])
        t.left = self.dfs(x, mid)
        t.right = self.dfs(mid + 1, y)
        return t
