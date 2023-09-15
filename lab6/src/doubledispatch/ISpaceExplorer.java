package doubledispatch;

/**
 * The interface Space explorer.
 */
public interface ISpaceExplorer {

  /**
   * Method to visit mercury.
   *
   * @param mercury the mercury
   */
  void visit(Mercury mercury);

  /**
   * Method to visit mars.
   *
   * @param mars the mars
   */
  void visit(Mars mars);

  /**
   * Method to visit venus.
   *
   * @param venus the venus
   */
  void visit(Venus venus);

  /**
   * Method to visit an unknown planet.
   *
   * @param aPlanet a planet
   */
  default void visit(IPlanet aPlanet) {
    SimulationBuilder.addToLog("Visiting an unknown planet");
  }
}

