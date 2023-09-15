package doubledispatch;

/**
 * The type Venus.
 */
public class Venus implements IPlanet {

  /**
   * Override accept function.
   * @param explorer explorer of this Venus.
   */
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
