package stock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Stock class.
 * Two test are set: Apple, Benz.
 */
public class StockTest {
  private Stock Apple;
  private Stock Benz;

  /**
   * Set up values for test Stock examples.
   */
  @Before
  public void setUp() {
    Apple = new Stock("Ap", "Apple", 192.90);
    Benz = new Stock("B", "Benz", 79.00);
  }

  /**
   * Test for getting the symbol of stock.
   */
  @Test
  public void getSymbolTest() {
    assertEquals("Ap", Apple.getSymbol());
    assertEquals("B", Benz.getSymbol());
  }

  /**
   * Test for getting the name of stock.
   */
  @Test
  public void getNameTest() {
    assertEquals("Apple", Apple.getName());
    assertEquals("Benz", Benz.getName());
  }

  /**
   * Test for getting the cost basis of stock.
   */
  @Test
  public void getCostBasisTest() {
    assertEquals(192.90, Apple.getCostBasis(), 0.01);
    assertEquals(79.00, Benz.getCostBasis(), 0.01);
  }

  /**
   * Test for getting the current price of stock.
   */
  @Test
  public void getCurrentPriceTest() {
    assertEquals(192.90, Apple.getCurrentPrice(), 0.01);
    assertEquals(79.00, Benz.getCurrentPrice(), 0.01);
  }

  /**
   * Test for setting the new cost basis of stock.
   */
  @Test
  public void setCostBasisTest() {
    double costBasis1 = 99.88;
    Apple.setCostBasis(costBasis1);
    Benz.setCostBasis(costBasis1);
    assertEquals(99.88, Apple.getCostBasis(), 0.01);
    assertEquals(99.88, Benz.getCostBasis(), 0.01);
  }

  /**
   * Test for setting the current price of stock.
   */
  @Test
  public void setCurrentPriceTest() {
    double currentPrice1 = 66.88;
    double currentPrice2 = 202.12;
    Apple.setCurrentPrice(currentPrice2);
    Benz.setCurrentPrice(currentPrice1);
    assertEquals(202.12, Apple.getCurrentPrice(), 0.01);
    assertEquals(66.88, Benz.getCurrentPrice(), 0.01);
  }

  /**
   * Test for getting the change percent of stock.
   * formula: (this.CurrentPrice - this.CostBasis) / this.CostBasis)
   * Expected result of the test:
   * Apple: (202.12- 99.88) / 99.88 = 1.0236
   */
  @Test
  public void getChangePercentTest() {
    double costBasis1 = 99.88;
    Apple.setCostBasis(costBasis1);
    double currentPrice2 = 202.12;
    Apple.setCurrentPrice(currentPrice2);
    assertEquals(1.0236, Apple.getChangePercent(), 0.01);
  }

  /**
   * Test for string output of information of Stock.
   */
  @Test
  public void testToStringTest() {
    double costBasis1 = 99.88;
    Apple.setCostBasis(costBasis1);
    double currentPrice2 = 202.12;
    Apple.setCurrentPrice(currentPrice2);
    assertEquals("Apple Current Price: $ 202.12\n Gain/Loss: 102.36%", Apple.toString());
  }
}