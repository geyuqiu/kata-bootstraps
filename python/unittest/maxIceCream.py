from typing import List

class MaxIceCream: # https://leetcode.com/problems/maximum-ice-cream-bars/submissions/

    def maxIceCream(self, costs: List[int], coins: int) -> int:
        costs.sort()
        sum = 0
        for cost in costs:
            coins -= cost
            if (coins < 0):
                break
            else:
                sum += 1

        return sum