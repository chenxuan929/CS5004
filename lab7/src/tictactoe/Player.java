package tictactoe;

/**
 * Enum player.
 */
public enum Player {
  X, O;

  /**
   * Methode toString.
   * @return string.
   */
  @Override
  public String toString() {
    if (this == Player.X) {
      return "X";
    } else {
      return "O";
    }
  }
}
