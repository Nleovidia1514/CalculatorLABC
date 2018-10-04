package com.Calculator.labc;
import java.util.*;

public class Test {
	
	public void ops() {
		double A=0,B=0,C=0;
		//i permite que el programa funcione correctamente
		int i=0;
		double a = 0;
		Stack<Double> stack = new Stack<Double>();
		String input="";
		Scanner sn = new Scanner(System.in);
		while(!input.equals("x")) {
			//Si la entrada es de tipo double ejecuta el try statement 
			//si es de tipo String ejecuta el catch statement
			try {
				input=sn.next();
				stack.push(Double.valueOf(input));
			}catch(Exception e) {
				if(input.equals("+")||input.equals("-")||input.equals("*")||input.equals("/")||input.equals("c")||input.equals("omg")
				||input.equals("$")||input.equals("^")) {
					//Se utiliza un contador para sumar todo lo que pueda
					//introducir el usuario
					if (input.equals("+")) {
						while(stack.size()>i) {
							a+=stack.pop();						
						}
						System.out.println(a);
					}
					else if(input.equals("-")) {
						while(stack.size()>i) {
							a-=stack.pop();
						}
				        System.out.println(a);
					}
					else if(input.equals("*")) {
						while(stack.size()>i) {
							a=a*stack.pop();
						}
					    System.out.println(a);
					}
					else if(input.equals("/")) {
						while(stack.size()>i) {
							double d,g;
							g=stack.get(i-1);d=stack.pop();
							a=g/d;
						}
						System.out.println(a);
					}
					else if(input.equals("^")) {
						double d,g;
						d=stack.get(i-1);g=stack.pop();
						a=Math.pow(d, g);
						System.out.println(a);
					}
					else if(input.equals("$")) {
						a=Math.sqrt(stack.get(i-1));
						System.out.println(a);
					}
					else if(input.equals("c")) {
						while(!stack.empty()) {
							stack.pop();
							a=0;
							i=0;
						}
					}
					else if(input.equals("omg")) {
						System.out.println("You've found an easter egg c:");
						while(!stack.empty()) {
							stack.pop();
							a=0;
							i=0;
						}
					}
					stack.push(a);
					i=stack.size();
				}
				//Operaciones para el manejo de variables en la memoria de la calculadora
				else if (input.equals("A")||input.equals("B")||input.equals("C")
						||input.equals("cA")||input.equals("cB")||input.equals("cC")) {
					if(input.equals("A")) {
					    if(A==0) {
					    	i=stack.size()-1;
							A=stack.get(i);
							System.out.println("A-->"+A);
							i=stack.size();
					    }
					    else {
					    	System.out.println(A);
					    	stack.push(A);
					    }
					}
					else if(input.equals("B")) {
						if(B==0) {
							i=stack.size()-1;
							B=stack.get(i);
							System.out.println("B-->"+B);
							i=stack.size();
						}
						else {
							System.out.println(B);
							stack.push(B);
						}
					}
					else if(input.equals("C")) {
						if(C==0) {
							i=stack.size()-1;
							C=stack.get(i);
							System.out.println("C-->"+C);
							i=stack.size();
						}
						else {
							System.out.println(C);
							stack.push(C);
						}
					}
					//Borra el valor de las variables para poder asignarle uno nuevo
					else if(input.equals("cA")) {
						A=0;
						System.out.println("A-->"+A);
					}
					else if(input.equals("cB")) {
						B=0;
						System.out.println("B-->"+B);
					}
					else if(input.equals("cC")) {
						C=0;
						System.out.println("C-->"+C);
					}
				}
				else if(!input.equals("x")) {
					System.out.println("Syntax error");
				}
				//Se coloca el resultado de la operacion encima 
				//de la pila
				
			}
		}
		System.out.print("Thank you for using my RPN calculator! :3");
	}
}
