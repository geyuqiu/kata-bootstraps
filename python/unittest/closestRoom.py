from typing import List

class ClosestRoom:
    def getMin(self, dic, minSize, preferred):
        m = 10000001
        roomNumber = -1
        for key, value in dic.items():
            if key >= minSize:
                for i in value:
                    res = abs(i - preferred)
                    if res < m:
                        m = res
                        roomNumber = i
                    elif res == m:  # use the room with the smallest room if tie
                        roomNumber = min(roomNumber, i)

        return roomNumber

    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]: # TLE O(Q * N * logN)
        res = []

        dic = {}
        N = len(rooms)
        NQ = len(queries)
        for i in range(0, N):
            pair = rooms[i]
            size = pair[1]
            roomId = pair[0]
            if dic.get(size) == None:
                dic[size] = [roomId]
            else:
                dic[size].append(roomId)

        # print(dic)
        for i in range(0, NQ):
            pair = queries[i]
            minSize = pair[1]
            preferred = pair[0]

            if max(dic.keys()) < minSize:
                res.append(-1)
            else:
                min = self.getMin(dic, minSize, preferred)
                res.append(min)

        return res