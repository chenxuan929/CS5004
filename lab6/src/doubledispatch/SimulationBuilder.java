package doubledispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulation builder.
 */
public class SimulationBuilder {
  private static final List<String> logs = new ArrayList<>();

  /**
   * Create planet.
   *
   * @param name the name
   * @return the planet
   */
  public static IPlanet createPlanet(String name) {
    if (name.equalsIgnoreCase("Mars")) {
      return new Mars();
    } else if (name.equalsIgnoreCase("Mercury")) {
      return new Mercury();
    } else if (name.equalsIgnoreCase("Venus")) {
      return new Venus();
    } else {
      return null;
    }
  }

  /**
   * Create space explorer.
   *
   * @param name the name
   * @return the space explorer
   */
  public static ISpaceExplorer createExplorer(String name) {
    if (name.equalsIgnoreCase("LifeExplorer")) {
      return new LifeExplorer();
    } else if (name.equalsIgnoreCase("TerrainExplorer")) {
      return new TerrainExplorer();
    } else {
      return null;
    }
  }

  /**
   * Add to log.
   *
   * @param message the message
   */
  public static void addToLog(String message) {
    logs.add(message);
  }

  /**
   * Gets simulation log.
   *
   * @return the simulation log
   */
  public static List<String> getSimulationLog() {
    return logs;
  }
}



