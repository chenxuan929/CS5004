package sensorcomp;

/**
 * This is a interface class ISensor.
 */

public interface ISensor {

  /**
   * This method take the current reading.
   * @return current reading value.
   */
  double takeNewReading();

  /**
   * This method get the last reading.
   * @return last reading value.
   */
  double lastReading();
}
