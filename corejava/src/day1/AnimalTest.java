package day1;

//import static org.junit.jupiter.api.Assertions.*;
// all static methods of assertions can be directly used in the class 

import org.junit.jupiter.api.Test;

class AnimalTest {

	@Test
	void testDog() {
		Dog dog = new Dog();
		showBehaviour(dog);				// dog object wont be used further
//		fail("Should fail...");			imported from Assertions class 
	}

	@Test
	void testCat() {
		showBehaviour(new Cat());		//creating an instance and immediately passing it
	}

	@Test
	void testTiger() {
		showBehaviour(new Tiger());
	}
	
	void showBehaviour(Animal a) {
		a.makeSound();
		a.eat();
		a.sleep();
	}

}
