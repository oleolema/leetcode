def hw(s) -> bool:
    length = len(s)
    for i in range(0, int(length / 2)):
        if s[i] != s[length - i - 1]:
            return False
    return True


class Solution:
    s = ""
    catch = {}
    catcha = {}

    def countSubstrings(self, s: str) -> int:
        self.s = s
        return self.dfs(0, len(s))

    def dfs(self, a: int, b: int) -> int:
        if a >= b:
            return 0
        if self.catch.get((a, b)) is not None:
            return 0
        if a + 1 == b:
            self.catch[(a, b)] = 1
            return 1
        count = 0
        if hw(self.s[a:b]):
            count += 1
        count += self.dfs(a, b - 1)
        count += self.dfs(a + 1, b)
        self.catch[(a, b)] = count
        return count


if __name__ == '__main__':
    print("a" * 100)
    print(Solution().countSubstrings("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
