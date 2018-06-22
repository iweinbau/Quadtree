package quattree;

public interface Point2D {

  /**
   *
   * get the 2d position of the point 2D
   *
   * @return Position 2D
   */
  Position2D getPosition2D();

  /**
   *
   * set the position to the x,y coordinate.
   *
   * @param x the x coordinate.
   * @param y the y coordinate.
   */
  void setPosition2D(float x , float y);

  /**
   *
   * get the x coordinate.
   * @return the x coordinate.
   */
  float getX();

  /**
   *
   * get the y coordinate.
   *
   * @return the y coordinate.
   */
  float getY();

  /**
   *
   * Set the position
   *
   * @param position
   */
  void setPosition2D(Position2D position);

}
