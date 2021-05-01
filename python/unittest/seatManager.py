class SeatManager:
    def __init__(self, n: int):
        self.r = [False] * n
        self.N = n

    def reserve(self) -> int:
        index = self.avail()
        self.r[index] = True

        return index + 1

    def unreserve(self, seatNumber: int) -> None:
        self.r[seatNumber - 1] = False

    def avail(self) -> int:
        for i in range(0, self.N):
            if (not self.r[i]):
                return i
        return -1