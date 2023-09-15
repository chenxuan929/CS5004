package sensorcomp;

/**
 * SensorData class.
 */
public class SensorData {
  /**
   * Constructor of SensorData.
   */
  private static double [] readings = {0.1, 0.4, 0.0, 0.51, 0.5, 0.7, 0.0, 2.2, 1.0};
  private static int counter = 0;

  /**
   * Current reading loop through the data.
   * @return current reading value.
   */
  public static double currentReading() {
    int value = counter;
    counter++;
    if (counter >= readings.length) {
      counter = 0;
    }
    return readings[value];
  }

  /**
   * Reset the counter.
   */
  public static void reset() {
    counter = 0;
  }
}
