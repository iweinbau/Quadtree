package quattree;

public final class Position2D extends Vector2D{

  /**
   *
   * Create new position in 2D space, x the first coordinate and y the second coordinate.
   *
   * @param x the x coordinate of the position.
   * @param y the y coordinate of the position.
   */
  public Position2D(float x, float y) {
    super(x,y);
  }

  /**
   *
   * add a vector 2D to this position. This will add the coordinates.
   *
   * @param vector the sum vector.
   * @return a new Position 2D with the new added position.
   */
  public Position2D add(Vector2D vector){
    return new Position2D(this.getX() + vector.getX(), this.getY() + vector.getY());
  }

  /**
   *
   * add x, y to the position.
   *
   * @param x value to add to the x coordinate.
   * @param y value to add to the y coordinate.
   *
   * @return new position with the added values.
   */
  public Position2D add(float x, float y){
    return new Position2D(this.getX() + x, this.getY() + y);
  }
}
