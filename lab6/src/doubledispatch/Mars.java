package doubledispatch;

/**
 * The type Mars.
 */
public class Mars implements IPlanet {

  /**
   * Override accept function.
   * @param explorer explorer of this Mars.
   */
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
