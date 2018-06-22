package quattree;

import drawer.Window;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main{

  static Dimension dimension = new Dimension(400, 400);
  static Position2D position = new Position2D(0, 0);
  static Rectangle rect = new Rectangle(new Dimension(200, 100), new Position2D(100, 100));

  public static void main(String[] args) {
    QuadTree<Point> KD = new QuadTree<Point>(position, dimension);
    Random random = new Random();
    List<Point> pointList = new LinkedList<>();
    for (int i = 0; i < 500; i++) {
      Point point = new Point(
          random.nextInt((int) (dimension.getWidth() + 1)),
          random.nextInt((int) (dimension.getHeight() + 1)));
      KD.insert(point);
      pointList.add(point);
    }
    List<Point> points = KD.query(rect);
    new Window(pointList, points, rect, KD,dimension);
  }
}
