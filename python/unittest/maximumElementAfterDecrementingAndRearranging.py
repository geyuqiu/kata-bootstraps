from typing import List

class MaximumElementAfterDecrementingAndRearranging:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:

        N = len(arr)
        arr.sort()
        if (arr[0] > 1):
            arr[0] = 1

        for i in range(1, N):
            if (abs(arr[i] - arr[i - 1]) > 1):
                arr[i] = arr[i - 1] + 1

        return max(arr)