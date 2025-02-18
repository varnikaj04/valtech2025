package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticTest {

	private Arithmetic ari = new SimpleArithmetic();

	@Test
	void testAdd() {
		assertEquals(5, ari.add(2.3, 2.7), 0.0);
	}

	@Test
	void testSub() {

	}

	@Test
	void testMul() {

	}

	@Test
	void testDivWithDouble() {
		assertEquals(1.666, ari.div(5., 3), 0.001);
		assertEquals(Double.POSITIVE_INFINITY, ari.div(5., 0), 0.0001);
	}

	@Test
	void testDivWithInt() {
		assertEquals(2, ari.div(4, 2));
		assertEquals(3, ari.div(7, 2));
	}

	@Test
	void testDivWithIntDenomIsZero() {
		try {
			ari.div(3, 0);
			fail("Exception was Excepted...");		//if it is not 0 then it should fail 
		} catch (Exception e) {

		}

	}
}
