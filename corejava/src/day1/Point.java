package day1;

public class Point {

	private static double ORIGIN = 0;
	private double x;
	private double y;
	
	public Point() {}
// public void Point() {}

	public Point(final double x, final double y) {
		this.x = x;
		this.y = y;
	}
	
	public final double getX() {
		return x;
	}
	
	public final double getY() {
		return y;
	}
	
	public final void setX(double x) {
		this.x = x;
	}
	
	public final void setY(double y) {
		this.y = y;
	}
	
	// public abstract void markMeOnScreen();
	
	public double distance(){
		return distance(0,0);
	}
	
	public double distance(Point p) {
		return distance(p.x, p.y);
	}
	
	public double distance(final double x1, final double y1) {
		double diffx = x1-x;
		double diffy = y1-y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}
	
	public static void main(String[] args) {
		Point p = new Point(10,20);
		System.out.println(p);
		System.out.println(p.distance());
		System.out.println(p.distance(100,200));
		System.out.println(p.distance(p));
	}
	
	@Override
	public String toString() {
		return "Point X = "+x+" Point y = " +y;
	}
}
