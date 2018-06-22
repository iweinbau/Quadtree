package quattree;

public class Vector2D {
  private final float x,y;

  public Vector2D(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getY() {
    return y;
  }

  public float getX() {
    return x;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj.getClass() != this.getClass())
      return false;
    Vector2D position = (Vector2D) obj;
    return position.getX() == getX() && position.getY() == getY();
  }
}
