package sensorcomp;

/**
 * Water sensor class.
 */
public class WaterSensor implements IDiscreteSensor {
  private double currentNum;
  private boolean ifFlood;
  private double lastNum;

  /**
   * Constructor of WatrerSensor class.
   */
  public WaterSensor() {
    this.currentNum = 0.0;
    this.lastNum = 0.0;
    this.ifFlood = false;
  }

  /**
   * Method to get the current status of sensor.
   * @return boolean of if it is flooding.
   */
  @Override
  public boolean status() {
    return this.ifFlood;
  }

  /**
   * Method to flip the boolean status.
   */
  @Override
  public void flipStatus() {
    this.ifFlood = !this.ifFlood;
  }

  /**
   * Method to set status of status.
   * @param value boolean represent if it's flooding.
   */

  @Override
  public void setStatus(boolean value) {
    this.ifFlood = value;
  }

  /**
   * Method to get the last reading value.
   * @return last reading value.
   */
  @Override
  public double lastReading() {
    return this.lastNum;
  }

  /**
   * Method to read new number and decide if it's flooding.
   * @return current reading number.
   */
  @Override
  public double takeNewReading() {
    this.lastNum = this.currentNum;
    this.currentNum = SensorData.currentReading();
    if (this.currentNum > 0.5) {
      this.ifFlood = true;
    } else {
      this.ifFlood = false;
    }
    return this.currentNum;
  }

}
