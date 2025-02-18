package day2;

public class SimpleArithmetic implements Arithmetic {

	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double sub(double a, double b) {
		return a-b;
	}

	@Override
	public double mul(double a, double b) {
		return a*b;
	}

	@Override
	public double div(double a, double b) {
		return a/b;
	}
	
	@Override
	public int div(int a, int b) {
		return a/b;
	}
		
//	public static void main(String[] args) {
//		SimpleArithmetic p = new SimpleArithmetic();
//		System.out.println(p);
//		System.out.println(p.add(10, 20));
//		System.out.println(p.sub(20, 10 ));
//		System.out.println(p.mul(10,20));
//		System.out.println(p.div(20, 10));
//	}

}
