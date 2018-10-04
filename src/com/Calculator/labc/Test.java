package com.Calculator.labc;
import java.util.*;

public class Test {
	
	public void ops() {
		double A,B,C;
		int i=0;
		double a = 0;
		Stack<Double> stack = new Stack<Double>();
		String input="";
		Scanner sn = new Scanner(System.in);
		while(input != "x") {
			//Si la entrada es de tipo double ejecuta el try statement 
			//si es de tipo String ejecuta el catch statement
			try {
				input=sn.next();
				stack.push(Double.valueOf(input));
			}catch(Exception e) {
				//Se utiliza un contador para sumar todo lo que pueda
				//introducir el usuario
				if (input.equals("+")) {
					if(i==0) {
						while (!stack.empty()) {
							a=a+stack.pop();
						}
					}
					else {
						while(stack.size()>i) {
							a=a+stack.pop();						}
					}
					System.out.println(a);
				}
				else if(input.equals("-")) {
					if(i==0) {
						while(!stack.empty()) {
							a=a-stack.pop();
						}
					}
					else {
						while(stack.size()>i);
					}
					System.out.println(a);
				}
				else if(input.equals("*")) {
					if(i==0) {
						while(!stack.empty()) {
							a=a*stack.pop();	
						}
					}
					else
						while(stack.size()>i) {
							a=a*stack.pop();
						}
					System.out.println(a);
				}
				else if(input.equals("/")) {
					while(!stack.empty()) {
						a=stack.pop()/stack.pop();
					}
					System.out.println(a);
				}
				else if(input.equals("^")) {
					a=Math.pow(stack.pop(), stack.pop());
					System.out.println(a);
				}
				else if(input.equals("$")) {
					a=Math.sqrt(stack.pop());
					System.out.println(a);
				}
				else if(input.equals("A")) {
				    A=stack.get(i);
				}
				else if(input.equals("B")) {
					B=stack.get(i);
				}
				else if(input.equals("C")) {
					C=stack.get(i);
				}
				else {
					System.out.println("Syntax error");
				}
				//Se coloca el resultado de la operacion encima 
				//de la pila
				stack.push(a);
				i++;
				System.out.println("CLEAR? Y N");
				String b=sn.next();
				if(b.equals("Y")) {
					while(!stack.empty()) {
						stack.pop();
					}
					a=0;
					i=0;
				}
				else {
					System.out.println("xd");
				}
			}
		}
	}
}
