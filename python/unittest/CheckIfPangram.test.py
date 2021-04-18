import unittest


class CheckIfPangramTestCase(unittest.TestCase):

    def test_python_test_setup_works(self):
        self.checkIfPangram("thequickbrownfoxjumpsoverthelazydog", True)

    def checkIfPangram(self, sentence: str) -> bool:
        N = len(sentence)

        check = [False] * 26
        for i in range(0, N):
            check[ord(sentence[i]) - ord('a')] = True
        return True if all(check) else False