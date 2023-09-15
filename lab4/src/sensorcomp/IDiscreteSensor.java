package sensorcomp;

/**
 * This is an interface named IDiscreteSensor extends the ISensor.
 */
public interface IDiscreteSensor extends ISensor {
  /**
   * Constructor of the IDiscreteSensor.
   */
  boolean status();

  /**
   * This method changes the current status of sensor to opposite.
   */
  void flipStatus();

  /**
   * This method sets the status of sensor.
   */
  void setStatus(boolean value);

  /**
   * This method get the last reading value of sensor.
   * Return 0 by default.
   */
  default double lastReading() {
    return 0;
  }

  /**
   * This method take current reading value of sensor.
   * Return 0 by default.
   */
  @Override
  default double takeNewReading() {
    return 0;
  }
}
