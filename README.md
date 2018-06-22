# Quadtree

This is a Java implementation of Quadtree, a tree data structure useful to store 2D positional data.

# Usage


## Creating new Quad tree
initialize the world with a 400 by 400 dimension starting at point (0,0)

```java
//init.
Dimension dimension = new Dimension(400, 400);  
Position2D position = new Position2D(0, 0);
QuadTree<Point> KD = new QuadTree<Point>(position, dimension);

//populate with random points.
Random random = new Random();  
List<Point> pointList = new LinkedList<>();  
for (int i = 0; i < 500; i++) {  
  Point point = new Point(  
      random.nextInt((int) (dimension.getWidth()+1)),  
      random.nextInt((int) (dimension.getHeight()+1)));
  //insert in the QuadTree  
  KD.insert(point);
}
``` 

## Query points from QuadTree
You can query points from the tree using a `Boundary` object. Use the default `Rectangle` or create one yourself just by implementing the `Boundary` interface and overriding the `contains(Point2D point)` methode.

Default query using the rectangle class.
```java
//init.
Dimension dimension = new Dimension(400, 400);  
Position2D position = new Position2D(0, 0);
QuadTree<Point> KD = new QuadTree<Point>(position, dimension);
	...
	
Rectangle rect = new Rectangle(new Dimension(200,100), new Position2D(100,100));

//query the result is a list of all points within the rectangle.
KD.query(rect);
}
``` 
## Debug 
There is also a drawing tool for the QuadTree. 

```java
	//Create new visual window for the quadtree.
	//PointsList = list of all points in the tree.
	//seletecPoints = selected Points from the query.
	//rect = rectangle boundary.
	//KD = the QuadTree.
	//dimension = the dimension of the screen/ world space
	new Window(pointList, seletecPoints, rect, KD,dimension);
}
```
