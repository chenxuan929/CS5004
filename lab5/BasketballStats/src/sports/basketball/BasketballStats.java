package sports.basketball;

import java.util.Objects;

/**
 * A class represents a basketball player.
 */
public class BasketballStats {
  private double pointsPerGame;
  private double reboundsPerGame;
  private double assistsPerGame;

  /**
   * Constructor of the class BasketballStats.
   * @param pointsPerGame the player's points per game.
   * @param reboundsPerGame the player's rebounds per game.
   * @param assistsPerGame the player's assists per game.
   */
  public BasketballStats(double pointsPerGame, double reboundsPerGame,
                         double assistsPerGame) {
    this.pointsPerGame = pointsPerGame;
    this.reboundsPerGame = reboundsPerGame;
    this.assistsPerGame = assistsPerGame;
  }

  /**
   * Get the points of player.
   * @return points per game of player.
   */
  public double getPointsPerGame() {
    return this.pointsPerGame;
  }

  /**
   * Get the rebounds of player.
   * @return rebounds per game of player.
   */
  public double getReboundsPerGame() {
    return this.reboundsPerGame;
  }

  /**
   * Get the assists of player.
   * @return assists per game of player.
   */
  public double getAssistsPerGame() {
    return this.assistsPerGame;
  }

  /**
   * Method to override equal.
   * @param other other object of BaskerballStatus.
   * @return boolean
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    BasketballStats o = (BasketballStats) other;
    if (this.assistsPerGame == o.assistsPerGame
        && this.reboundsPerGame == o.reboundsPerGame
        && this.pointsPerGame == o.pointsPerGame) {
      return true;
    }
    return false;
  }

  /**
   * Methode to Override hashCode.
   * @return hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.assistsPerGame, this.reboundsPerGame, this.pointsPerGame);
  }

  /**
   * Methode to override toString.
   */
  @Override
  public String toString() {
    return String.format("Points: %.2f. Rebounds: %.2f. Assists: %.2f",
      this.pointsPerGame, this.reboundsPerGame, this.assistsPerGame);
  }
}
