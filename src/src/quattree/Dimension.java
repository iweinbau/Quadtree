package quattree;


/**
 *
 * Represent the dimensions of an object, in 2D space, width (right) and height(down).
 *
 */
public final class Dimension extends Vector2D {

  /**
   *
   * create new dimension object.
   *
   * @param width the width of the dimension
   * @param height the height of the dimension.
   */
  public Dimension(float width, float height) {
    super(width,height);
  }

  /**
   *
   * get the width
   *
   * @return the width.
   */
  public float getWidth() {
    return super.getX();
  }

  /**
   *
   * get the height
   *
   * @return the height.
   */
  public float getHeight() {
    return super.getY();
  }

  /**
   *
   * Scale the dimension with a given factor. This result in multiply the width and height with the
   * scaleFactor.
   *
   * @param scaleFactor the factor of scale.
   * @return a new Dimension with the result of the scaling.
   */
  public Dimension scale(double scaleFactor){
    return new Dimension((int)(getWidth() * scaleFactor), (int)(getHeight() * scaleFactor));
  }

  /**
   *
   * check if a point is within this dimension.
   * Note there is no notion of positions so the points has to be defined to the origin at 0,0.
   *
   * @param point the point
   * @return true if the position is within the dimensions 0,0 -> width, height.
   */
  public boolean contains(Point2D point){
    return point.getX() >= 0 && point.getX() <= this.getWidth() &&
            point.getY() >= 0 && point.getY() <= this.getHeight();
  }

  /**
   *
   * check if a point is within this dimension.
   * Note there is no notion of positions so the points has to be defined to the origin at 0,0.
   *
   * @param x the x coordinate.
   * @param y the y coordinate.
   * @return true if the position is within the dimensions 0,0 -> width, height.
   */
  public boolean contains(float x, float y){
    return x >= 0 && x <= this.getWidth() &&
        y >= 0 && y <= this.getHeight();
  }
}
