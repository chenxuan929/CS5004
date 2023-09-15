package bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test CheckingAccount class.
 */
public class CheckingAccountTest {
  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    try {
      new CheckingAccount(-9);
    } catch (IllegalArgumentException e) {
      assertEquals("Starter amount can not less than min deposit 0.01.", e.getMessage());
    }

    try {
      new CheckingAccount(0);
    } catch (IllegalArgumentException e) {
      assertEquals("Starter amount can not less than min deposit 0.01.", e.getMessage());
    }

    CheckingAccount goodTest = new CheckingAccount(999);
    assertEquals(999, goodTest.getBalance(), 0.01);
  }

  /**
   * Test deposit method.
   */
  @Test
  public void testDeposit() {
    CheckingAccount S1 = new CheckingAccount(1000);
    try {
      S1.deposit(-100);
    } catch (IllegalArgumentException e) {
      assertEquals("Deposit amount can not be less than 0.", e.getMessage());
    }

    S1.deposit(1000);
    assertEquals(2000, S1.getBalance(), 0.01);

    S1.deposit(0);
    assertEquals(2000, S1.getBalance(), 0.01);
  }

  /**
   * Test withdraw method.
   */
  @Test
  public void testWithdraw() {
    CheckingAccount S2 = new CheckingAccount(1000);
    assertFalse(S2.withdraw(-1));
    assertTrue(S2.withdraw(100));
    assertTrue(S2.withdraw(300));
    assertEquals(600, S2.getBalance(), 0.01);
  }

  /**
   * Test getBalance method.
   */
  @Test
  public void testGetBalance() {
    CheckingAccount S3 = new CheckingAccount(199.99);
    assertEquals(199.99, S3.getBalance(), 0.01);
    CheckingAccount S4 = new CheckingAccount(200);
    assertEquals(200, S4.getBalance(), 0.01);
  }

  /**
   * Test performMonthlyMaintenance method.
   */
  @Test
  public void testPerformMonthlyMaintenance() {
    CheckingAccount S5 = new CheckingAccount(200);
    S5.withdraw(150);
    S5.performMonthlyMaintenance();
    assertEquals(45, S5.getBalance(), 0.01);
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    CheckingAccount S7 = new CheckingAccount(99.99);
    assertEquals("$99.99", S7.toString());
    CheckingAccount S9 = new CheckingAccount(10.00);
    assertEquals("$10.00", S9.toString());
  }
}