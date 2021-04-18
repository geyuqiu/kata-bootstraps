class CheckIfPangram:

    def checkIfPangram(self, sentence: str) -> bool:
        N = len(sentence)

        check = [False] * 26
        for i in range(0, N):
            check[ord(sentence[i]) - ord('a')] = True
        return True if all(check) else False


checkIfPangram = CheckIfPangram()
print(checkIfPangram.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))