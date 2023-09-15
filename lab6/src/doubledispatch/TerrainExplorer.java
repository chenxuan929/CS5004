package doubledispatch;

/**
 * Type Terrain explorer.
 */
public class TerrainExplorer implements ISpaceExplorer {
  @Override
  public void visit(Mercury mercury) {
    SimulationBuilder.addToLog("Navigating and mapping Mercury");
  }

  @Override
  public void visit(Mars mars) {
    SimulationBuilder.addToLog("Navigating and mapping Mars");
  }

  @Override
  public void visit(Venus venus) {
    SimulationBuilder.addToLog("Navigating and mapping Venus");
  }
}
