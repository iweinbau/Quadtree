package quattree;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class QuadTree<T extends Point2D> {

  /**
   *
   * Max number per node.
   *
   */
  private final static int MAX_POSITIONS = 2;

  /**
   *
   * Flag for if the node is subdivided.
   *
   */
  private boolean isSubdivided = false;

  /**
   *
   * the dimensions of this node.
   */
  private final Dimension dimension;

  /**
   *
   * the position of this node.
   */
  private final Position2D position;

  /**
   *
   * List of all points in this node.
   *
   */
  private List<T> positions = new LinkedList<>();

  /**
   *
   * check if the node is subdivided.
   *
   * @return true if the node is subdivided false otherwise.
   */
  public boolean isSubdivided() {
    return isSubdivided;
  }

  public Dimension getDimension() {
    return dimension;
  }

  public Position2D getPosition() {
    return position;
  }

  /**
   *
   * get the first quadrant node.
   *
   * @return the first node.
   */
  public QuadTree<T> getFirst() {
    return first;
  }

  /**
   *
   * get the second quadrant node.
   *
   * @return the first node.
   */
  public QuadTree<T> getSecond() {
    return second;
  }

  /**
   *
   * get the third quadrant node.
   *
   * @return the first node.
   */
  public QuadTree<T> getThird() {
    return third;
  }

  /**
   *
   * get the fourth quadrant node.
   *
   * @return the first node.
   */
  public QuadTree<T> getFourth() {
    return fourth;
  }

  /**
   * Holds 4 quadrants representing the subdivided quad.
   *
   *
   * 2nd       |   1ste
   * --------- |-------
   * 3th       |   4th
   */

  QuadTree<T> first;
  QuadTree<T> second;
  QuadTree<T> third;
  QuadTree<T> fourth;

  /**
   * construct new QuaTree.
   */
  public QuadTree(Position2D position, Dimension dimension) {
    this.dimension = dimension;
    this.position = position;

  }

  /**
   *
   * Insert new point2d in the quadtree. check if there is space in this node.
   * else add to the child nodes.
   *
   *
   * @param point2D
   */
  public void insert(T point2D) {
    //check if this point falls within the dimensions of this node.
    if (!this.contains(point2D)) {
      return;
    }
    //check if MAX_POSITIONS is exceeded.
    if (positions.size() < MAX_POSITIONS) {
      //if not we can add this positions to this node and return.
      positions.add(point2D);
      //no further computations needed.
      if (positions.size() >= MAX_POSITIONS) {
        this.subDivide();
      }
      return;
    }
    first.insert(point2D);
    second.insert(point2D);
    third.insert(point2D);
    fourth.insert(point2D);

  }

  /**
   *
   * subdivide the current node.
   *
   * @throws IllegalStateException when this function is called when the node has more space and
   * when it's already subdivided.
   */
  private void subDivide() throws IllegalStateException {
    if (positions.size() < MAX_POSITIONS || this.isSubdivided)
      throw new IllegalStateException("Can not subDivide, this node has not reached MAX_POSITIONS");
    this.isSubdivided = true;
    Dimension newDimension = this.dimension.scale(0.5);
    first = new QuadTree<>(this.position.add(newDimension.getX(), 0), newDimension);
    second = new QuadTree<>(this.position, newDimension);
    third = new QuadTree<>(this.position.add(0, newDimension.getHeight()), newDimension);
    fourth = new QuadTree<>(
        this.position.add(newDimension.getX(), newDimension.getHeight()),
        newDimension);
  }

  /**
   *
   * Remove a point2D from the tree.
   *
   * @param point2D point to remove.
   * @return true if it has remove the point false otherwise.
   */
  public boolean remove(T point2D) {
    if (positions.remove(point2D)) {
      return true;
    }
    if (this.isSubdivided) {
      if (first.remove(point2D))
        return true;
      if (second.remove(point2D))
        return true;
      if (third.remove(point2D))
        return true;
      if (fourth.remove(point2D))
        return true;
    }
    return false;
  }

  /**
   *
   * Query points in a given boundary. returns all points within this boundary.
   *
   * this is the core of the quadtree and can run in O(N.Log(N)) with N the number of points.
   *
   * @param bounds the boundary.
   * @return List of all Points within the boundary
   */
  public List<T> query(Boundary bounds) {
    List points = new LinkedList<>();
    for (T point2D : positions) {
      if (bounds.contains(point2D)) {
        points.add(point2D);
      }
    }
    if (isSubdivided) {
      points.addAll(first.query(bounds));
      points.addAll(second.query(bounds));
      points.addAll(third.query(bounds));
      points.addAll(fourth.query(bounds));
    }
    return points;
  }

  /**
   *
   * check if the point falls within the node.
   * @param point
   * @return true if the points is in this node false otherwise.
   */
  private boolean contains(T point) {
    return
        point.getX() > this.position.getX() &&
            point.getY() > this.position.getY() &&
            point.getX() <= this.position.getX() + this.dimension.getWidth() &&
            point.getY() <= this.position.getY() + this.dimension.getHeight();
  }
}
