package drawer;

import java.awt.Color;
import java.awt.Graphics;
import quattree.Point2D;
import quattree.QuadTree;
import quattree.Rectangle;

public final class ShapeDrawer {

  private final Graphics graphics;

  public ShapeDrawer(Graphics g) {
    graphics = g;
  }

  public void drawShape(QuadTree<?> tree) {
    graphics.setColor(Color.RED);
    graphics.drawRect((int) tree.getPosition().getX(), (int) tree.getPosition().getY(),
        (int) tree.getDimension().getWidth(), (int) tree.getDimension().getHeight());
    if (tree.isSubdivided()) {
      drawShape(tree.getFirst());
      drawShape(tree.getSecond());
      drawShape(tree.getThird());
      drawShape(tree.getFourth());
    }
  }

  public void drawShape(Rectangle boundary){
    graphics.setColor(Color.BLUE);
    graphics.drawRect((int)boundary.getPosition().getX(),(int)boundary.getPosition().getY(),(int)boundary.getDimension().getWidth(),(int)boundary.getDimension().getHeight());
  }

  public void drawSelectedPoint(Point2D point){
    this.drawPoint(point);
    graphics.setColor(Color.GREEN);
    graphics.drawOval((int)point.getX()-3,(int)point.getY()-3,6,6);
  }

  public void drawPoint(Point2D point){
    graphics.setColor(Color.BLACK);
    graphics.fillOval((int)point.getX() -3,(int)point.getY()-3,6,6);
  }
}
