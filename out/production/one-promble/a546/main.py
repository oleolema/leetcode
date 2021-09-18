from typing import List


def remove_some(i: int, li: List[int]) -> int:
    a = li[i]
    del li[i]
    count = 1
    while i < len(li):
        if a != li[i]:
            return count
        count += 1
        del li[i]
    return count


class Solution:
    max_count = 0
    cache = {}

    def removeBoxes(self, boxes: List[int]) -> int:
        self.dfs(0, boxes, 0)
        return self.max_count

    def dfs(self, x: int, li: List[int], count):
        if len(li) == 0:
            self.max_count = max(self.max_count, count)
        if x >= len(li):
            return 0
        key = tuple(li)
        if not self.cache.get(key) is None:
            return self.cache.get(key)
        for i in range(len(li)):
            li_copy = li[:]
            a = remove_some(i, li_copy)
            self.dfs(i, li_copy, count + a * a)
        self.cache[key] = count


if __name__ == '__main__':
    result = Solution().removeBoxes([1, 3, 2, 2, 2, 3, 4, 3, 1])
    print(result)
