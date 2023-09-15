package distance;

/**
 *Chenxuan Xu  - CS5004 Lab_01
 *This class represents a 3D Point. A 3D Point has the following attributes: x, y, z
 */
public class Point3D {
  private int x;
  private int y;
  private int z;

  /**
   * Default constructor for Point3D.
   */
  public Point3D() {
  }

  /**
   *Constructor for Point3D that takes in three coordinates (x, y, z).
   */
  public Point3D(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Getter for the x coordinate.
   * @return x coordinate.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Getter for the y coordinate.
   * @return y coordinate.
   */
  public int getY() {
    return this.y;
  }

  /**
   * Getter for the z coordinate.
   * @return z coordinate.
   */
  public int getZ() {
    return this.z;
  }

  /**
   * Method that calculates the distance between two Point3D objects.
   * @return distance.
   */
  public double distanceTo(Point3D other) {
    int xDif = this.x - other.x;
    int yDif = this.y - other.y;
    int zDif = this.z - other.z;
    return Math.sqrt(xDif * xDif + yDif * yDif + zDif * zDif);
  }

  /**
   * Method that checks if two Point3D objects are equal.
   */
  public boolean equals( Object other) {
    if (other == null) {
      return false;
    }
    if (!(other instanceof Point3D)) {
      return false;
    }
    Point3D otherPoint = (Point3D) other;
    return this.x == otherPoint.getX()
            && this.y == otherPoint.getY() && this.z == otherPoint.getZ();
  }

  /**
   * Method that returns the hashcode for a Point3D object.
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    result = prime * result + z;
    return result;
  }
}
