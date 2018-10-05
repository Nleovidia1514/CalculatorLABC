package com.Calculator.labc;

public class Executable {

	public static void main(String[] args) {
		Gui ui = new Gui();
		Test test = new Test();
		ui.calcTop();
		System.out.println("|   |        Welcome to my RPN java calculator             |   |");
		ui.calcBottom();
		test.ops();
    }
}
