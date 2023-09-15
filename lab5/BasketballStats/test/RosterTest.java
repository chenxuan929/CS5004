import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import sports.Roster;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballStats;


/**
 * Test for roster class.
 */
public class RosterTest {
  /**
   * Test AddPlayer method.
   */
  @Test
  public void testAddPlayer() {
    Roster<BasketballPlayer, String> roster = new Roster<>();
    BasketballPlayer player = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    roster.addPlayer(player);
    assertEquals(1, roster.getPlayers().size());
    assertTrue(roster.getPlayers().contains(player));
  }

  /**
   * Test SortByStats method.
   */
  @Test
  public void testSortByStats() {
    Roster<BasketballPlayer, String> roster = new Roster<>();
    BasketballPlayer player1 = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    BasketballPlayer player2 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    assertEquals("xu", player2.getName());
    BasketballPlayer player3 = new BasketballPlayer("Ross", 40, 6.5,
        new BasketballStats(39.0, 3.0, 1.0));
    roster.addPlayer(player1);
    roster.addPlayer(player2);
    roster.addPlayer(player3);
    roster.sortByStats();
    List<BasketballPlayer> sortedPlayers = roster.getPlayers();
    assertEquals(sortedPlayers.get(0), player3);
    assertEquals(sortedPlayers.get(1), player1);
    assertEquals(sortedPlayers.get(2), player2);
  }

  /**
   * Test fold method.
   */
  @Test
  public void testFold() {
    Roster<BasketballPlayer, Double> roster = new Roster<>();
    BasketballPlayer player1 = new BasketballPlayer("Jam", 23, 5.4,
        new BasketballStats(46.0, 4.0, 3.0));
    BasketballPlayer player2 = new BasketballPlayer("xu", 25, 5.8,
        new BasketballStats(50.0, 5.0, 2.0));
    assertEquals("xu", player2.getName());
    BasketballPlayer player3 = new BasketballPlayer("Ross", 40, 6.5,
        new BasketballStats(39.0, 3.0, 1.0));
    roster.addPlayer(player1);
    roster.addPlayer(player2);
    roster.addPlayer(player3);
    Double totalPoints =
        roster.fold((player, acc) -> acc + player.getStats().getPointsPerGame(), 0.0);
    assertEquals(135.0, totalPoints, 0.01);
  }
}