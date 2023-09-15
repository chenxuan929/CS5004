package stock;

/**
 *Chenxuan Xu  - CS5004 Lab_01
 *This class represents a Stock class. A stock has the following attributes:
 *Symbol, Name, CostBasis, CurrentPrice.
 */
public class Stock {
  private final String Symbol;
  private final String Name;
  private double CostBasis;
  private double CurrentPrice;

  /**
   * params in Stock class.
   * Symbol: the symbol of the stock.
   * Name: the name  of the stock.
   * CostBasis: the cost basis of the stock.
   */
  public Stock(String Symbol, String Name, double CostBasis) {
    this.Symbol = Symbol;
    this.Name = Name;
    this.CostBasis = CostBasis;
    this.CurrentPrice = CostBasis;
  }

  /**
   * This method is to get the symbol of the stock.
   * Return the symbol of the stock.
   */
  public String getSymbol() {
    return this.Symbol;
  }

  /**
   * This method is to get the name of the stock.
   * Return the name of the stock.
   */
  public String getName() {
    return this.Name;
  }

  /**
   * This method is to get the cost basis of the stock.
   * Return the cost basis of the stock.
   */
  public double getCostBasis() {
    return this.CostBasis;
  }

  /**
   * This method is to get the current price of the stock.
   * Return the current price of the stock.
   */
  public double getCurrentPrice() {
    return this.CurrentPrice;
  }

  /**
   * This method is to set a new cost basis of the stock.
   * Return the cost basis.
   */
  public void setCostBasis(double CostBasis) {
    //if (this.CostBasis <= 0) {
    //throw new IllegalArgumentException();
    //}
    this.CostBasis = CostBasis;
  }

  /**
   * This method is to set the current price of the stock.
   * Return the current price of the stock.
   */
  public void setCurrentPrice(double CurrentPrice) {
    //if (this.CurrentPrice <= 0) {
    //throw new IllegalArgumentException();
    //}
    this.CurrentPrice = CurrentPrice;
  }

  /**
   * This method is to get the change percent between current price and cost basis of the stock.
   * Return the change percent of the stock.
   */
  public double getChangePercent() {
    double changePercent = ((this.CurrentPrice - this.CostBasis) / this.CostBasis);
    return changePercent;
  }

  /**
   * This method make stock objects to be represented as a String.
   * return the format string of stock.
   */
  @Override
  public String toString() {
    //DecimalFormat commaFormat = new DecimalFormat("0.0");
    return String.format( "%s Current Price: $ %.2f\n" + " Gain/Loss: %.2f%%", getName(),
            getCurrentPrice(), (getChangePercent() * 100));
  }

}
