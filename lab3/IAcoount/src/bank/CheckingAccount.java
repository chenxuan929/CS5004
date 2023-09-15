package bank;

/**
 * This class represents a checking account.
 * Implements the IAccount interface.
 */
public class CheckingAccount extends accounts {
  private static final double minRemain = 100.00;
  private static final double maintenanceFee = 5.00;
  private static final double minStarter = 0.01;

  /**
   * Constructor for the checkingAccount class.
   *
   * @param starter The starting amount for account.
   */
  public CheckingAccount(double starter) {
    super(starter);
    helperPenaltyBoundary();
  }

  /**
   * Withdraw method, subtract the specific withdraw amount to account balance.
   *
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
    if (this.balance < minRemain) {
      this.penaltyCharged = true;
    }
    return true;
  }

  /**
   * Perform monthly maintenance method, updates the account balance by subtract maintenance fee,
   * if balance less than 0.01 after subtract, throw exception.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (this.penaltyCharged) {
      this.balance -= maintenanceFee;
    }
    helperPenaltyBoundary();
  }
}
