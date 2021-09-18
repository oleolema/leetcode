class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        map = {}
        for it in rectangles:
            key = it[0] / it[1]
            value = map.get(key)
            if value is None:
                value = 0
            map[key] = value + 1
        count = 0
        for v in map.values():
            count += v * (v - 1) / 2
        print(map)
        return int(count)