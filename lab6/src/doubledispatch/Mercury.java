package doubledispatch;

/**
 * The type Mercury.
 */
public class Mercury implements IPlanet {

  /**
   * Override accept function.
   * @param explorer explorer of this Mercury.
   */
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
