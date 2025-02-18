package practice;

class A {
	
	int age;

	public void show() {
		System.out.println("in show");
	}

	static class B {
		public void config() {
			System.out.println("in config");
		}
	}
}

public class InnerClassPrac {

	public static void main(String[] args) {
		A obj = new A();
		obj.show();
//		A.B obj1 = obj.new B();				when inner class is non-static
//		obj1.config();
		
		A.B obj1 = new A.B();				//when inner class is static
		obj1.config();
	}
}
