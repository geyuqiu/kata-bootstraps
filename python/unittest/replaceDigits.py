class ReplaceDigits:
    def replaceDigits(self, s: str) -> str:
        chars = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
        n = len(s)

        for i in range(0, n):
            if (i % 2 != 0):
                indexOfPrev = chars.index(s[i - 1])
                s = s[:i] + chars[indexOfPrev + int(s[i])] + s[i + 1:]

        return s
