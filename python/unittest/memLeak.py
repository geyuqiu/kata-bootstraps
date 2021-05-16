from typing import List

class MemLeak:
    def memLeak(self, memory1: int, memory2: int) -> List[int]:

        for i in range(1, 1000000000):
            if i > memory1 and i > memory2:
                return [i, memory1, memory2]
            elif memory1 < memory2:
                memory2 -= i
            elif memory1 >= memory2:
                memory1 -= i

        return []