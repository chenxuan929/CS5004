package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Tic tac toe model.
 */
public class TicTacToeModel implements TicTacToe {
  // add your implementation here
  private Player[][] board;
  private static final int boardSize = 3;
  private int moves;

  /**
   * Instantiates a new tic tac model.
   */
  public TicTacToeModel() {
    this.moves = 0;
    this.board = new Player[boardSize][boardSize];
  }

  /**
   * Execute a move in the position specified by the given row and column.
   *
   * @param r the row of the intended move
   * @param c the column of the intended move
   * @throws IllegalArgumentException if the space is occupied or the position is otherwise invalid
   * @throws IllegalStateException    if the game is over
   */
  @Override
  public void move(int r, int c) {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    }

    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("Invalid position.");
    }

    if (getMarkAt(r,c) != null) {
      throw new IllegalArgumentException("Occupied position.");
    }

    board[r][c] = getTurn();
    this.moves++;
  }

  /**
   * Get the current turn, i.e., the player who will mark on the next call to move().
   *
   * @return the {@link Player} whose turn it is
   */
  @Override
  public Player getTurn() {
    return (moves % 2 == 0) ? Player.X : Player.O;
  }

  /**
   * Return whether the game is over. The game is over when either the board is full, or
   * one player has won.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    return getWinner() == Player.X || getWinner() == Player.O || moves == 9;
  }

  /**
   * help function one.
   */
  private boolean checkRow(int r) {
    for (int i = 1; i < board.length; i++) {
      if (board[r][i] != board[r][i - 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * help function two.
   */
  private boolean checkCol(int c) {
    for (int i = 1; i < board.length; i++) {
      if (board[i][c] != board[i - 1][c]) {
        return false;
      }
    }
    return true;
  }

  /**
   * help function three.
   */
  public boolean checkLeftDia() {
    for (int i = 1; i < board.length; i++) {
      if (board[i][i] != board[i - 1][i - 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * help function four.
   */
  public boolean checkRightDia() {
    for (int i = 1; i < board.length; i++) {
      if (board[board.length - i - 1][i] != board[board.length - i][i - 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * Return the winner of the game, or {@code null} if there is no winner. If the game is not
   * over, returns {@code null}.
   *
   * @return the winner, or null if there is no winner
   */
  @Override
  public Player getWinner() {
    for (int i = 0; i < board.length; i++) {
      if (checkRow(i)) {
        return getMarkAt(i, 0);
      }
      if (checkCol(i)) {
        return getMarkAt(0, i);
      }
      if (checkLeftDia()) {
        return getMarkAt(0,0);
      }
      if (checkRightDia()) {
        return getMarkAt(2,0);
      }
    }
    return null;
  }

  /**
   * Return the current game state, as a 2D array of Player. A {@code null} value in the grid
   * indicates an empty position on the board.
   *
   * @return the current game board
   */
  @Override
  public Player[][] getBoard() {
    Player[][] temp = new Player[boardSize][boardSize];
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        temp[i][j] = board[i][j];
      }
    }
    return temp;
  }

  /**
   * Return the current {@link Player} mark at a given row and column, or {@code null} if the
   * position is empty.
   *
   * @param r the row
   * @param c the column
   * @return the player at the given position, or null if it's empty
   */
  @Override
  public Player getMarkAt(int r, int c) {
    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("Invalid position.");
    }
    return board[r][c];
  }

  /**
   * toString method.
   * @return string.
   */
  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
        row -> " " + Arrays.stream(row).map(
          p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
      .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using
    // the helpful built-in String.join method.
  }
}

