package com.Calculator.labc;

public class Gui{
	
	public void calcTop() {
		System.out.println("________________________________________");
		System.out.println("|    RPN                By LeoB        |");
		System.out.println("|       CALCULATOR                     |");
		System.out.println("|   ______________2K18______________   |");
		System.out.println("|   |                              |   |");
	}
	
	public void calcBottom() {
		System.out.println("|   |______________________________|   |");
		System.out.println("|   _______ _______ _______            |");
		System.out.println("|   |     | |     | |     |            |");
		System.out.println("|   |  A  | |  B  | |  C  |            |");
		System.out.println("|   |_____| |_____| |_____|            |");
		System.out.println("|   _______ _______         _______    |");
		System.out.println("|   |Squar| |Pow  |         |     |    |");
		System.out.println("|   | root| |  ^  |         |CLEAR|    |");
		System.out.println("|   |___$_| |_____|         |_____|    |");
		System.out.println("|   _______ _______ _______ _______    |");
		System.out.println("|   |     | |     | |     | |     |    |");
		System.out.println("|   |  +  | |  -  | |  *  | |  /  |    |");
		System.out.println("|   |_____| |_____| |_____| |_____|    |");
		System.out.println("|______________________________________|");
		System.out.println("--->                                   ");
	}
	
	protected void printCalculator(String a) {
		calcTop();
	    if(!a.equals("x")) {
			System.out.println("|   |"+a);
		}
		else {
			System.out.println("Thanks for using my RPN Java calculator :#");
		}
		calcBottom();
	}

}
