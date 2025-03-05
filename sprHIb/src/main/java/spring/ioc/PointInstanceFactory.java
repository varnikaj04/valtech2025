package spring.ioc;

public class PointInstanceFactory {
	
	private int x;
	private int y;
	
	public PointInstanceFactory(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point createPoint(int x, int y) {
//		return new Point(this.x, this.y);						it will give values for the above constructor
		return new Point(x,y);
	}

}
