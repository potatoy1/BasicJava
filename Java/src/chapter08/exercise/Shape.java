package chapter08.exercise;

public abstract class Shape implements Comparable<Shape> {
	public abstract double area();
	public abstract double perimeter();
	@Override
	public int compareTo(Shape o) {
		if (this.area() > o.area()) {
			return 1;
		} else if (this.area() < o.area()) {
			return -1;
		} else {
			return 0;
		}
			
	}
}