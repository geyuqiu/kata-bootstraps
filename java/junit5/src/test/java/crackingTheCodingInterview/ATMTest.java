package crackingTheCodingInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
  ATM atm = new ATM();

  @Test
  void testdeposit() {
    atm.deposit(new int[]{0,0,1,2,1});
    int[] withdraw1 = atm.withdraw(600);
    assertArrayEquals(new int[]{0,0,1,0,1}, withdraw1);
    atm.deposit(new int[]{0,1,0,1,1});
    int[] withdraw2 = atm.withdraw(600);
    assertArrayEquals(new int[]{-1}, withdraw2);
    int[] withdraw3 = atm.withdraw(550);
    assertArrayEquals(new int[]{0,1,0,0,1}, withdraw3);
  }

  @Test
  void testdeposit2() {
    atm.deposit(new int[]{0,10,0,3,0});
    int[] withdraw1 = atm.withdraw(500);
    assertArrayEquals(new int[]{0,2,0,2,0}, withdraw1);
  }
}
