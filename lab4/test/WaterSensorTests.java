import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import sensorcomp.SensorData;
import sensorcomp.WaterSensor;

/**
 * Test of Water sensor.
 */
public class WaterSensorTests {
  private WaterSensor reading;

  /**
   * Set up one sensor reading to start test.
   */
  @Before
  public void setup() {
    reading = new WaterSensor();
  }

  /**
   * Test the method takeNewReading.
   */
  @Test
  public void takeNewReading() {
    SensorData.reset();
    double r1 = reading.takeNewReading();
    assertEquals(0.1, r1, 0.01);
    double r2 = reading.takeNewReading();
    assertEquals(0.4, r2, 0.01);
    double r3 = reading.takeNewReading();
    assertEquals(0.0, r3,0.01);
  }

  /**
   * Test LastReading method.
   */
  @Test
  public void testLastReading() {
    SensorData.reset();
    reading.takeNewReading();
    reading.takeNewReading();
    double r1 = reading.lastReading();
    assertEquals(0.1,r1,0.01);
    reading.takeNewReading();
    double r2 = reading.lastReading();
    assertEquals(0.4,r2,0.01);
  }

  /**
   * Test status method.
   */
  @Test
  public void testStatus() {
    SensorData.reset();
    reading.takeNewReading();
    reading.takeNewReading();
    boolean s1 = reading.status();
    assertFalse(s1);
    reading.takeNewReading();
    reading.takeNewReading();
    boolean s2 = reading.status();
    assertTrue(s2);
    reading.flipStatus();
    boolean s3 = reading.status();
    assertFalse(s3);
  }

  /**
   * Test setStatus method.
   */
  @Test
  public void testSetStatus() {
    reading.setStatus(true);
    boolean s1 = reading.status();
    assertTrue(s1);
    reading.setStatus(false);
    boolean s2 = reading.status();
    assertFalse(s2);
  }

}
