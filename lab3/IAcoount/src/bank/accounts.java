package bank;

/**
 * This is a abstract class represents IAccount.
 */
public abstract class accounts implements IAccount {
  protected double balance;
  protected boolean penaltyCharged;
  private static final double minStarter = 0.01;

  /**
   * Constructor for Saving and Checking account.
   * @param starter the start amount of account
   */
  public accounts(double starter) {
    if (starter < minStarter) {
      throw new IllegalArgumentException("Starter amount can not less than min deposit 0.01.");
    }
    this.balance = starter;
  }

  /**
   * Deposit method, add the specific deposit amount to account balance.
   * @param amount The amount to be deposited into account.
   */
  @Override
  public void deposit(double amount) {
    double minDeposit = 0;
    if (amount < minDeposit) {
      throw new IllegalArgumentException("Deposit amount can not be less than 0.");
    }
    this.balance += amount;
  }

  /**
   * Withdraw method, subtract the specific withdraw amount to account balance.
   */
  @Override
  public abstract boolean withdraw(double amount);

  /**
   * Get balance method.
   * @return the current balance of the account.
   */
  @Override
  public double getBalance() {
    return this.balance;
  }

  /**
   * Perform monthly maintenance.
   */
  @Override
  public abstract void performMonthlyMaintenance();

  /**
   * toString method.
   * @return a formatted string represents account balance.
   */
  @Override
  public String toString() {
    return String.format("$%.2f", this.balance);
  }

  /**
   * Helper function for penalty in order to prevent redundant.
   */
  protected void helperPenaltyBoundary() {
    int penaltyBoundary = 100;
    if (this.balance < penaltyBoundary) {
      this.penaltyCharged = true;
    } else {
      this.penaltyCharged = false;
    }
  }
}
