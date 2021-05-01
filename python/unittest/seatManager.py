from queue import PriorityQueue

class SeatManager:  # TLE O(C*N) -> O(C * log n)
    def __init__(self, n: int):
        self.r = [False] * n
        self.N = n
        self.q = PriorityQueue()
        for i in range(0, n):
            self.q.put(i)

    def reserve(self) -> int:
        index = self.q.get()
        self.r[index] = True

        return index + 1

    def unreserve(self, seatNumber: int) -> None:
        self.r[seatNumber - 1] = False
        self.q.put(seatNumber - 1)  # O(log n)