package com.valtech.training.simple;

public interface Operation {

	int perform(int a, int b);
	
	Operation ADD = (a,b) -> a+b;
	Operation SUB = (a,b) -> a-b;
	Operation MUL = (a,b) -> a*b;
	Operation DIV = (a,b) -> a/b;
	
}
