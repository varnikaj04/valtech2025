package practice;

class VarnikaException extends RuntimeException{
	public VarnikaException(String string) {
		super(string);
	}
}

public class ExceptionCheck {

	public static void main(String[] args) {
		
		int i= 20;
		int j= 0;
		
		try {
			j = 18/i;
			if(j==0)
				throw new VarnikaException("I dont want to print zero ");
		}
		catch(VarnikaException e) {
			j = 18/1;
			System.out.println("Thats the default output " + e);
		}
		catch(Exception e) {
			System.out.println("Something went wrong.. " + e);
		}
		
		System.out.println(j);
		System.out.println("BYE");
	}
}
