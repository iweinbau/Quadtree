package quattree;

public class Rectangle implements Boundary {

  Dimension dimension;
  Position2D position;

  /**
   *
   * Create new rectangle.
   *
   * @param dimension
   * @param position
   */
  public Rectangle(Dimension dimension, Position2D position) {
    this.dimension = dimension;
    this.position = position;
  }

  /**
   * Check if the point is within the rectangle.
   *
   * @param point2D the point to check
   * @return true if the point 2d is within the rectangle. False otherwise.
   */
  @Override
  public boolean contains(Point2D point2D) {
    return this.dimension.contains(
        point2D.getX() - this.position.getX(),
        point2D.getY() - this.position.getY());
  }

  public Dimension getDimension() {
    return dimension;
  }

  public Position2D getPosition() {
    return position;
  }
}
