package tictactoe;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A controller for the Tic Tac Toe game that interacts with the user through the console.
 * Implements the TicTacToeController interface.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private final Appendable out;
  private Readable in;

  /**
   * Instantiates a new Tic tac toe console controller.
   *
   * @param in the in.
   * @param out the out.
   */
  public TicTacToeConsoleController(Readable in, Appendable out) throws IllegalArgumentException {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Can not be null.");
    }
    this.in = in;
    this.out = out;
  }

  /**
   * Execute a single game of tic tac toe given a tic tac toe Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a non-null tic tac toe Model
   */
  @Override
  public void playGame(TicTacToe m) throws IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Null Invalid.");
    }
    Scanner scan = new Scanner(this.in);
    try {
      out.append(m.toString()).append("\n");
      out.append("Enter a move for " + m.getTurn().toString() + ":").append("\n");
      Integer rowInput = null;
      Integer columnInput = null;
      String token = "";
      while (!m.isGameOver()) {
        token = scan.next();
        if (token.equalsIgnoreCase("q")) {
          break;
        }
        try {
          int var = Integer.parseInt(token);
          if (rowInput == null) {
            rowInput = var;
          } else {
            columnInput = var;
            m.move(rowInput - 1, columnInput - 1);
            if (m.isGameOver()) {
              out.append(m.toString()).append("\n");
              out.append("Game is over! ");
              if (m.getWinner() != null) {
                out.append(m.getWinner().toString() + " wins.\n");
              } else {
                out.append("Tie game.\n");
              }
              break;
            }
            out.append(m.toString()).append("\n");
            out.append("Enter a move for " + m.getTurn().toString() + ":").append("\n");
            rowInput = columnInput = null;
          }
        } catch (NumberFormatException e) {
          out.append("This is not a valid number: " + token + "\n");
        } catch (IllegalArgumentException e) {
          out.append("Invalid move" + rowInput + ":" + columnInput + "\n");
          rowInput = columnInput = null;
        }
      }
      if (!m.isGameOver() && token.equalsIgnoreCase("q")) {
        out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
      } else if (!m.isGameOver()) {
        throw new IllegalStateException("No more inputs");
      }
    } catch (IOException e) {
      throw new IllegalStateException("append failed", e);
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("Failure to read from readable");
    }
    scan.close();
  }
}
