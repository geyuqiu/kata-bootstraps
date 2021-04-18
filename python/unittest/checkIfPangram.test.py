import unittest
from checkIfPangram import CheckIfPangram


class CheckIfPangramTestCase(unittest.TestCase):

    def test_python_test_setup_works(self):
        self.assertEqual(CheckIfPangram().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"), True)

if __name__ == '__main__':
    unittest.main(verbosity=2)