package sports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import sports.basketball.BasketballPlayerComparator;

/**
 * Roster class that represents a roster of players of a specific sport.
 * @param <T> The type of player.
 * @param <R> The type of result.
 */
public class Roster<T, R> {
  private List<T> players;

  /**
   * Default constructor that creates a new roster.
   */
  public Roster() {
    this.players = new ArrayList<>();
  }

  /**
   * Roster constructor creates a roster from a list of players.
   * @param players list of players.
   */
  public Roster(List<T> players) {
    this.players = players;
  }

  /**
   * Get the list of players.
   * @return An unmodifiable view of the list of players in this roster.
   */
  public List<T> getPlayers() {
    return Collections.unmodifiableList(this.players);
    // return the collection of players
  }

  /**
   * Adds a new player to the roster.
   * @param player The new player that need to add to the roster.
   */
  public void addPlayer(T player) {
    this.players.add(player);
    // add the new player to our list of players
  }

  /**
   * Sorts the players list in the roster by their stats.
   */
  public void sortByStats() {
    this.players.sort((Comparator<? super T>) new BasketballPlayerComparator());
    //this.players.sort((Comparator<? super T>) new BasketballPlayerComparator());

    // use our comparator to sort
    // the previous generic is using a wildcard ?
    // basically stating the type can be any T or a super type of T
    // this is Turkish Delights from Java "deep magic"
    // - don't worry if you don't understand it - you can
    // use this method safely without editing it or knowing how it works under the hood. Asland.
  }

  /**
   * Combines stats of each players in the roster into a single result using a fold function.
   * @param combiner combines the stats of two players into a single result.
   * @param seedValue initial value of the result.
   * @return result of combining.
   */
  // Bi-Function to combine individual stats the dream team has, into one value
  public <R> R fold(BiFunction<T, R, R> combiner, R seedValue) {
    R total = seedValue;
    for (T each : this.players) {
      total = combiner.apply(each, total);
    }
    return total;
  }

  // given a bi-function and a seed-value (initial value), combine all of the
  // values from each player
  // into a single value. The value we're combining will be dependent on
  // the bi-function passed in as a parameter
  // T and R are "formal" parameters that may be bound to 2 different concrete type.
}

