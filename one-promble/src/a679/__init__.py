from typing import List


class Solution:

    def f(self, nums: List[int], a: int, b: int, f1) -> List[int]:
        li = []
        for i in range(0, len(nums)):
            if i == b:
                continue
            n = nums[i]
            if i == a:
                n = f1(n, nums[b])
            li.append(n)
        return li

    def judgePoint24(self, nums: List[int], result='') -> bool:
        if len(nums) == 1:
            var = round(nums[0], 13) == 24
            if var:
                print("#############################success")
                print(f'{result} = 24')
                print("#############################")
            return var
        for i in range(0, len(nums)):
            if len(nums) == 4: result = nums[i]
            for j in range(0, len(nums)):
                if i == j:
                    continue
                if self.judgePoint24(self.f(nums, i, j, lambda a, b: a + b), f'({result} + {nums[j]})'):
                    print(f'{nums} {i} {j}  {nums[i]} + {nums[j]} = {nums[i] + nums[j]}')
                    return True
                if self.judgePoint24(self.f(nums, i, j, lambda a, b: a - b), f'({result} - {nums[j]})'):
                    print(f'{nums} {i} {j}  {nums[i]} - {nums[j]} = {nums[i] - nums[j]}')
                    return True
                if self.judgePoint24(self.f(nums, i, j, lambda a, b: a * b), f'{result} * {nums[j]}'):
                    print(f'{nums} {i} {j}  {nums[i]} * {nums[j]} = {nums[i] * nums[j]}')
                    return True
                if nums[j] != 0 and self.judgePoint24(self.f(nums, i, j, lambda a, b: a / b), f'{result} / {nums[j]}'):
                    print(f'{nums} {i} {j}  {nums[i]} / {nums[j]} = {nums[i] / nums[j]}')
                    return True
        return False


if __name__ == '__main__':
    a = Solution().judgePoint24([7,2,1,1])
    print(a)
