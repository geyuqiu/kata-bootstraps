class sortSentence:
    def sortSentence(self, s: str) -> str:
        s = s.split(' ')
        N = len(s)
        dic = {}
        for j in range(N):
            num = ''
            l = len(s[j])
            for i in range(l - 1, -1, -1):
                if s[j][i].isdigit():
                    num += s[j][i]
                else:
                    numL = len(num)
                    dic[num] = s[j][:(l - numL)]
                    break
        #        print(dic)
        res = ''
        for key in sorted(dic):
            res += dic[key] + ' '

        return res[:len(res) - 1]