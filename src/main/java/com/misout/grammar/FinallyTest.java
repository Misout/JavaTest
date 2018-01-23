package com.misout.grammar;

public class FinallyTest {

	public int finallyCase() {
		int i = 1;
		try {
			i = 3;
			return i;
		} finally {
			i = 4;
		}
	}
	
	public static void main(String[] args) {
		FinallyTest test = new FinallyTest();
		test.finallyCase();
	}
}
