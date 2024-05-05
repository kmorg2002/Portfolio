public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>{
  private double side;
  private boolean isClone;

  public Octagon() {
      this(5);
  }

  public Octagon(double side) {
      this.side = side;
      this.isClone = false;
  }

  public double getSide() {
      return side;
  }

  public void setSide(double side) {
      this.side = side;
  }

  public boolean getIsClone() {
      return isClone;
  }

  public void setIsClone(boolean isClone) {
      this.isClone = isClone;
  }

  @Override
  public double getArea() {
      return (2 + 4 / Math.sqrt(2)) * side * side;
  }

  @Override
  public double getPerimeter() {
      return 8 * side;
  }

  @Override
  public String toString() {
      return "Octagon with side = " + side + " perimeter = " + getPerimeter() + " area = " + getArea() + " isClone = " + isClone;
  }

  @Override
  public int compareTo(Octagon o) {
      if (this.getArea() > o.getArea())
          return 1;
      else if (getArea() < o.getArea())
          return -1;
      else
          return 0;
  }

}