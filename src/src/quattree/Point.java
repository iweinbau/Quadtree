package quattree;

/**
 *
 * Represent a point in 2D space, (x,y)
 *
 */
public class Point implements Point2D {

  /**
   *
   * The position of this point.
   */
  private Position2D position;

  /**
   *
   * Create new point with the given Position.
   *
   * @param position the position.
   */
  public Point(Position2D position) {
    this.position = position;
  }


  /**
   *
   * Create new point with x, y coordinate.
   *
   * @param x the x coordinate of the point (1ste coordinate.)
   * @param y the y coordinate of the point (2nd coordinate.)
   */
  public Point(float x, float y) {
    position = new Position2D(x,y);
  }

  /**
   *
   * @return the positoin of this point.
   */
  @Override
  public Position2D getPosition2D() {
    return position;
  }

  /**
   *
   * set the position of this point.
   *
   * @param x the x coordinate.
   * @param y the y coordinate.
   */
  @Override
  public void setPosition2D(float x, float y) {
    this.position = new Position2D(x,y);
  }

  /**
   *
   * set the position with a new position object.
   *
   * @param position
   */
  @Override
  public void setPosition2D(Position2D position) {
    this.position = position;
  }

  /**
   *
   * get the x coordinate.
   *
   * @return
   */
  @Override
  public float getX() {
    return this.position.getX();
  }

  /**
   *
   * get the y coordinate.
   *
   * @return
   */
  @Override
  public float getY() {
    return this.position.getY();
  }
}
