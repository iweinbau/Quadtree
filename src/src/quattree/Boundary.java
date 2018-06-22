package quattree;

/**
 *
 * Interface, create new boundary types. Used to create different type of selection boxes.
 *
 */
public interface Boundary {

  /**
   *
   * Check if a point2D is within the boundary.
   *
   * @param point2D the point to check
   * @return true if the point is within this boundary false otherwise.
   */
  public abstract boolean contains(Point2D point2D);

}
