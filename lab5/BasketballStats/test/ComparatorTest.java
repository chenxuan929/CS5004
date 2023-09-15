import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballPlayerComparator;
import sports.basketball.BasketballStats;

/**
 * Junit test for comparator.
 */
public class ComparatorTest {

  /**
   * Test comparator.
   */
  @Test
  public void testCompare() {
    BasketballPlayerComparator comparator = new BasketballPlayerComparator();
    BasketballPlayer player1 = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    BasketballPlayer player2 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    assertEquals("xu", player2.getName());
    BasketballPlayer player3 = new BasketballPlayer("Ross", 40, 6.5,
        new BasketballStats(39.0, 3.0, 1.0));
    assertTrue(comparator.compare(player1, player2) < 0);
    assertTrue(comparator.compare(player1, player3) > 0);
    assertTrue(comparator.compare(player2, player3) > 0);
    assertTrue(comparator.compare(player2, player1) > 0);
  }

}