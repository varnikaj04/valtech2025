package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		String s = "Hello";
		String s1 = "Hello";
		assertSame(s,s1);
		String s2 = new String("Hello");
//		by using new a new object is being created
		assertNotSame(s1, s2);
		String s3 = "Hell" + "o";
		assertSame(s, s3);
		String s4 = "o";
		String s5 = "Hell" + s4;
		assertNotSame(s3, s5);					// bcoz s4 is not final
		final String s6 = "o";
		String s7 = "Hell" + s6;
		assertSame(s, s7);
	}

}
