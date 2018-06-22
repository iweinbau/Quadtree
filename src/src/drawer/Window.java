package drawer;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import quattree.Dimension;
import quattree.Point;
import quattree.QuadTree;
import quattree.Rectangle;

public class Window extends Frame {
  List<Point> points;
  Dimension dimension;
  List<Point> query;
  Rectangle boundary;
  QuadTree<?> quadTree;
  ShapeDrawer shapeDrawer;

  public Window(List<Point> points, List<Point> selectedPoints, Rectangle boundary,
      QuadTree<?> quadTree,
      Dimension dimension){
    super("quadTree example");
    System.out.println("create window");
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent we)
      {
        System.exit(0);
      }
    });
    this.points = points;
    this.query = selectedPoints;
    this.boundary = boundary;
    this.quadTree = quadTree;

    setSize((int) dimension.getWidth(),(int) dimension.getHeight());
    setVisible(true);
  }

  @Override
  public void paint(Graphics g) {
    System.out.println("paint");
    shapeDrawer = new ShapeDrawer(g);

    shapeDrawer.drawShape(quadTree);

    for (Point point:points) {
      shapeDrawer.drawPoint(point);
    }

    for (Point point:query) {
      shapeDrawer.drawSelectedPoint(point);
    }

    shapeDrawer.drawShape(boundary);
    super.paint(g);
  }
}
