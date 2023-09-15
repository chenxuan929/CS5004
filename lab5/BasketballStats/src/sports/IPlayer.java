package sports;

import sports.basketball.BasketballStats;

/**
 * An interface class represents a player in a sports game.
 * @param <T> any type.
 */
public interface IPlayer<T> {

  /**
   * Get the name of player.
   * @return name of player.
   */
  String getName();

  /**
   * Get the age of player.
   * @return age of player.
   */
  int getAge();

  /**
   * Get the height of player.
   * @return height of player.
   */
  double getHeight();

  /**
   * Get the statistics of player.
   * @return statistics of player.
   */
  <T> BasketballStats getStats(); // generic method returns status type T

}
