package bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test SavingAccount class.
 */
public class SavingsAccountTest {
  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    try {
      new SavingsAccount(-1);
    } catch (IllegalArgumentException e) {
      assertEquals("Starter amount can not less than min deposit 0.01.", e.getMessage());
    }

    try {
      new SavingsAccount(0);
    } catch (IllegalArgumentException e) {
      assertEquals("Starter amount can not less than min deposit 0.01.", e.getMessage());
    }

    SavingsAccount goodTest = new SavingsAccount(1);
    assertEquals(1, goodTest.getBalance(), 0.01);
  }

  /**
   * Test deposit method.
   */
  @Test
  public void testDeposit() {
    SavingsAccount S1 = new SavingsAccount(100);
    try {
      S1.deposit(-1);
    } catch (IllegalArgumentException e) {
      assertEquals("Deposit amount can not be less than 0.", e.getMessage());
    }

    S1.deposit(10);
    assertEquals(110, S1.getBalance(), 0.01);

    S1.deposit(0);
    assertEquals(110, S1.getBalance(), 0.01);
  }

  /**
   * Test withdraw method.
   */
  @Test
  public void testWithdraw() {
    SavingsAccount S2 = new SavingsAccount(100);
    assertFalse(S2.withdraw(-1));
    assertTrue(S2.withdraw(10));
    assertTrue(S2.withdraw(10));
    assertEquals(80, S2.getBalance(), 0.01);
  }

  /**
   * Test getBalance method.
   */
  @Test
  public void testGetBalance() {
    SavingsAccount S3 = new SavingsAccount(199.99);
    assertEquals(199.99, S3.getBalance(), 0.01);
    SavingsAccount S4 = new SavingsAccount(200);
    assertEquals(200, S4.getBalance(), 0.01);
  }

  /**
   * Test performMonthlyMaintenance method.
   */
  @Test
  public void testPerformMonthlyMaintenance() {
    SavingsAccount S4 = new SavingsAccount(200);
    for (int i = 0; i < 5; i++) {
      S4.withdraw(1);
    }
    S4.performMonthlyMaintenance();
    assertEquals(195, S4.getBalance(), 0.01);

    SavingsAccount S5 = new SavingsAccount(200);
    for (int i = 0; i < 7; i++) {
      S5.withdraw(1);
    }
    S5.performMonthlyMaintenance();
    assertEquals(179, S5.getBalance(), 0.01);

    SavingsAccount S6 = new SavingsAccount(200);
    for (int i = 0; i < 20; i++) {
      S6.withdraw(1);
    }
    S6.performMonthlyMaintenance();
    assertEquals(166, S6.getBalance(), 0.01);
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    SavingsAccount S7 = new SavingsAccount(99.99);
    assertEquals("$99.99", S7.toString());
    SavingsAccount S9 = new SavingsAccount(10.00);
    assertEquals("$10.00", S9.toString());
  }
}