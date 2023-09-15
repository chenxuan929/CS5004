package sports.basketball;

import java.util.Objects;

import sports.IPlayer;

/**
 * Class implements IPlayer and represents a basketball player.
 */
public class BasketballPlayer implements IPlayer<BasketballStats> {
  private final String playerName;
  private final int playerAge;
  private final double playerHeight;
  private BasketballStats playerStats;

  /**
   * Constructor of basketball object.
   * @param playerName name of player.
   * @param playerAge age of player.
   * @param playerHeight height of player.
   * @param playerStats stats of player.
   */
  public BasketballPlayer(String playerName, int playerAge,
                          double playerHeight, BasketballStats playerStats) {
    this.playerName = playerName;
    this.playerAge = playerAge;
    this.playerHeight = playerHeight;
    this.playerStats = playerStats;
  }

  /**
   * Copy constructor of a BasketballPlayer object.
   */
  public BasketballPlayer(BasketballPlayer other) {
    this.playerName = other.playerName;
    this.playerAge = other.playerAge;
    this.playerHeight = other.playerHeight;
    this.playerStats = new BasketballStats(other.playerStats.getPointsPerGame(),
      other.playerStats.getReboundsPerGame(), other.playerStats.getAssistsPerGame());
  }

  /**
   * Get name of player.
   * @return name.
   */
  @Override
  public String getName() {
    return this.playerName;
  }

  /**
   * Get age of player.
   * @return age.
   */
  @Override
  public int getAge() {
    return this.playerAge;
  }

  /**
   * Get height of player.
   * @return height.
   */
  @Override
  public double getHeight() {
    return this.playerHeight;
  }

  /**
   * Get stats of player.
   * @return stats.
   */
  @Override
  public BasketballStats getStats() {
    return this.playerStats;
  }

  /**
   * Override to String method.
   * @return String.
   */
  @Override
  public String toString() {
    return this.playerName + ": (pts " + this.getStats().getPointsPerGame()
      + ", rebounds " + this.getStats().getReboundsPerGame()
      + ", assists " + this.getStats().getAssistsPerGame() + ")";
  }

  /**
   * Override equals method.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (this.getClass() != other.getClass()) return false;
    BasketballPlayer o = (BasketballPlayer) other;
    return Double.compare(o.playerHeight, playerHeight) == 0 && this.playerAge == o.playerAge
      && this.playerName.equals(o.playerName); // never use == for floating point)
  }

  /**
   * Override hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.playerName, this.playerAge, this.playerHeight);
  }
}
