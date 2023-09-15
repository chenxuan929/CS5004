package bank;

/**
 * Interface for saving and checking accounts.
 * This interface defines common methods that both types should implement.
 */
public interface IAccount {

  /**
   * Method to deposit a specified amount into account.
   * @param amount The amount to be deposited into account.
   */
  void deposit(double amount);

  /**
   * Method to reduce the account balance by specified amount.
   * @param amount The amount to be reduced from account.
   * @return True if withdrawal is successful, false otherwise.
   */
  boolean withdraw(double amount);

  /**
   * Method to get current balance of account.
   * @return the current balance of account.
   */
  double getBalance();

  /**
   * Method to perform monthly maintenance on the account.
   */
  void performMonthlyMaintenance();

  /**
   * Method to format the string.
   */
  String toString();
}
