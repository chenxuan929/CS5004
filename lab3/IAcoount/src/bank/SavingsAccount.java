package bank;

/**
 * This class represents a saving account with deposit, withdraw, and monthly maintenance function.
 * Implements the IAccount interface.
 */
public class SavingsAccount extends accounts {
  private int withdrawCount;
  private static final double penalty = 14;
  private static final int maxWithdrawTimes = 6;

  /**
   * Constructor for the SavingAccount class.
   * @param starter The starting amount for account.
   */
  public SavingsAccount(double starter) {
    super(starter);
    this.withdrawCount = 0;
  }

  /**
   * Withdraw method, subtract the specific withdraw amount to account balance.
   * Updates the withdraw count.
   * @param amount The amount to be reduced from account.
   * @return false if withdraw amount is less than 0 or balance is less than withdraw amount.
   */
  @Override
  public boolean withdraw(double amount) {
    int minWithdraw = 0;
    if (amount < minWithdraw) {
      return false;
    }
    if (this.balance < amount) {
      return false;
    }
    this.balance -= amount;
    withdrawCount ++;
    return true;
  }

  /**
   * Perform monthly maintenance method, updates the account balance by subtract penalty,
   * if the withdraw time over the max withraw times.
   * And resets the withdraw counter.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (this.withdrawCount > maxWithdrawTimes) {
      this.balance -= penalty;
    }
    this.withdrawCount = 0;
  }
}
