package doubledispatch;

/**
 * Class LifeExplorer.
 */
public class LifeExplorer implements ISpaceExplorer {

  /**
   * Method to visit Mercury.
   * @param mercury the mercury.
   */
  @Override
  public void visit(Mercury mercury) {
    SimulationBuilder.addToLog("Landing on Mercury...exploring for life");
  }

  /**
   * Method to visit Mars.
   * @param mars the mars.
   */
  @Override
  public void visit(Mars mars) {
    SimulationBuilder.addToLog("Landing on Mars...exploring for life");
  }

  /**
   * Method to visit Venus.
   * @param venus the venus.
   */
  @Override
  public void visit(Venus venus) {
    SimulationBuilder.addToLog("Landing on Venus...exploring life");
  }
}
