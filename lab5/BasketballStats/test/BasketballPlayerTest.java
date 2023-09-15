import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballStats;

/**
 * Test class for BasketballPlayer.
 */
public class BasketballPlayerTest {
  /**
   * Test getName method.
   */
  @Test
  public void testGetName() {
    BasketballPlayer player = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    assertEquals("Jam", player.getName());

    BasketballPlayer player2 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    assertEquals("xu", player2.getName());
  }

  /**
   * Test getAge method.
   */
  @Test
  public void getAge() {
    BasketballPlayer player = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    assertEquals(23, player.getAge());

    BasketballPlayer player2 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    assertEquals(25, player2.getAge());
  }

  /**
   * Test getHeight method.
   */
  @Test
  public void testGetHeight() {
    BasketballPlayer player = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    assertEquals(5.4, player.getHeight(), 0.01);

    BasketballPlayer player2 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    assertEquals(5.8, player2.getHeight(), 0.01);
  }

  /**
   * Test to getStats method.
   */
  @Test
  public void testGetStats() {
    BasketballPlayer player = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    BasketballStats stats = player.getStats();
    assertNotNull(stats);
    assertEquals(46.0, stats.getPointsPerGame(), 0.01);
    assertEquals(4.0, stats.getReboundsPerGame(), 0.01);
    assertEquals(3.0, stats.getAssistsPerGame(), 0.01);

    BasketballPlayer player2 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    BasketballStats stats2 = player2.getStats();
    assertNotNull(stats2);
    assertEquals(50.0, stats2.getPointsPerGame(), 0.01);
    assertEquals(5.0, stats2.getReboundsPerGame(), 0.01);
    assertEquals(2.0, stats2.getAssistsPerGame(), 0.01);
  }

  /**
   * Test copied constructor.
   */
  @Test
  public void testCopyConstructor() {
    BasketballStats stats = new BasketballStats(50.0, 5.0, 2.0);
    BasketballPlayer player1 = new BasketballPlayer("xu", 25, 5.8, stats);
    BasketballPlayer player2 = new BasketballPlayer(player1);
    // Test that the copy constructor creates a new object
    assertNotSame(player1, player2);
    // Test that the copied object has the same properties as the original object
    assertEquals(player1.getName(), player2.getName());
    assertEquals(player1.getAge(), player2.getAge());
    assertEquals(player1.getHeight(), player2.getHeight(), 0.01);
    assertEquals(player1.getStats().getPointsPerGame(),
        player2.getStats().getPointsPerGame(), 0.01);
    assertEquals(player1.getStats().getReboundsPerGame(),
        player2.getStats().getReboundsPerGame(), 0.01);
    assertEquals(player1.getStats().getAssistsPerGame(),
        player2.getStats().getAssistsPerGame(), 0.01);
  }

  /**
   * Test equals method.
   */
  @Test
  public void testEquals() {
    BasketballPlayer player1 = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    BasketballPlayer player2 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    BasketballPlayer player3 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    assertTrue(player2.equals(player3));
    assertFalse(player1.equals(player2));
  }

  /**
   * Test hashcode method.
   */
  @Test
  public void testHashCode() {
    BasketballPlayer player1 = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    BasketballPlayer player2 = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    BasketballPlayer player3 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    assertEquals(player1.hashCode(), player2.hashCode());
    assertNotEquals(player1.hashCode(), player3.hashCode());
  }
}
