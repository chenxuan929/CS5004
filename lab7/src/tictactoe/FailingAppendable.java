package tictactoe;

import java.io.IOException;

/**
 * A mock to simulate a failure to write to the Appendable.
 */
public class FailingAppendable implements Appendable {

  /**
   * Appends the specified character sequence to this Appendable.
   * In this implementation, it always throws an IOException with the message "Fail!".
   * @param csq the character sequence to append
   * @return a reference to this Appendable
   * @throws IOException always throws an IOException with the message "Fail!"
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Fail!");
  }

  /**
   * Appends a subsequence of the specified character sequence to this Appendable.
   * In this implementation, it always throws an IOException with the message "Fail!".
   * @param csq the character sequence to append
   * @param start the index of the first character in the subsequence
   * @param end the index of the character following the last character in the subsequence
   * @return a reference to this Appendable
   * @throws IOException always throws an IOException with the message "Fail!"
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Fail!");
  }

  /**
   * Appends the specified character to this Appendable.
   * In this implementation, it always throws an IOException with the message "Fail!".
   * @param c the character to append
   * @return a reference to this Appendable
   * @throws IOException always throws an IOException with the message "Fail!"
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Fail!");
  }
}
