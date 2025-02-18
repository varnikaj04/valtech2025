package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListPractice {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(6);
		nums.add(5);
		nums.add(8);
		nums.add(4);

		System.out.println(nums.get(2));
		
		System.out.println(nums);
	}
}
