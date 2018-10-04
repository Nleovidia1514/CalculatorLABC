package com.Calculator.labc;
import java.util.*;

public class Test {
	
	public void ops() {
		double A=0,B=0,C=0;
		//contador i permite que el programa funcione correctamente
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
						while(stack.size()>i) {
							a=a-stack.pop();
						}
					}
					System.out.println(a);
				}
				else if(input.equals("*")) {
					if(i==0) {
						a=1;
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
					while(stack.size()>i-1) {
						double d,g;
						d=stack.pop();g=stack.pop();
						a=g/d;
					}
					System.out.println(a);
				}
				else if(input.equals("^")) {
					double d,g;
					d=stack.pop();g=stack.pop();
					a=Math.pow(g, d);
					System.out.println(a);
				}
				else if(input.equals("$")) {
					a=Math.sqrt(stack.pop());
					System.out.println(a);
				}
				else if(input.equals("A")) {
				    if(A==0) {
				    	i=stack.size()-1;
						A=stack.get(i);
						System.out.println("A-->"+A);
				    }
				    else {
				    	a=A;
				    }
				}
				else if(input.equals("B")) {
					if(B==0) {
						i=stack.size()-1;
						B=stack.get(i);
						System.out.println("B-->"+B);
					}
					else {
						a=B;
					}
				}
				else if(input.equals("C")) {
					if(C==0) {
						i=stack.size()-1;
						C=stack.get(i);
						System.out.println("C-->"+C);
					}
					else {
						a=C;
					}
				}
				else if(input.equals("c")) {
					while(!stack.empty()) {
						stack.pop();
					}
					a=0;
					i=0;
				}
				else if(input.equals("omg")) {
					System.out.println("You've found an easter egg c:");
				}
				else {
					System.out.println("Syntax error");
				}
				//Se coloca el resultado de la operacion encima 
				//de la pila
				stack.push(a);
				i=stack.size();
			}
			System.out.print(stack.size());
		}
	}
}
