package com.Calculator.labc;
import java.util.*;

public class Test extends Gui {
	public static Stack<Double> stack = new Stack<Double>();
	public int i=0;
	public String input="";
	
	public void ops() {
		double A=0,B=0,C=0;
		//i permite que el programa funcione correctamente
	    double a = 0;
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
						printCalculator(String.valueOf(a));
					}
					else if(input.equals("-")) {
						while(stack.size()>i) {
							a-=stack.pop();
						}
						printCalculator(String.valueOf(a));
					}
					else if(input.equals("*")) {
						while(stack.size()>i) {
							a=a*stack.pop();
						}
						printCalculator(String.valueOf(a));
					}
					else if(input.equals("/")) {
						while(stack.size()>i) {
							double d,g;
							g=stack.get(i-1);d=stack.pop();
							a=g/d;
						}
						printCalculator(String.valueOf(a));
					}
					else if(input.equals("^")) {
						double d,g;
						d=stack.get(i-1);g=stack.pop();
						a=Math.pow(d, g);
						printCalculator(String.valueOf(a));
					}
					else if(input.equals("$")) {
						i=stack.size();
						a=Math.sqrt(stack.get(i-1));
						printCalculator(String.valueOf(a));
					}
					else if(input.equals("c")) {
						while(!stack.empty()) {
							stack.pop();
							a=0;
						}
					}
					else if(input.equals("omg")) {
						printCalculator("You've found an easter egg c:");
						while(!stack.empty()) {
							stack.pop();
							a=0;
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
							printCalculator("A-->"+A);
							i=stack.size();
					    }
					    else {
					    	System.out.println(A);
					    	stack.push(A);
					    	printCalculator(stack.get(stack.size()-1).toString());
					    }
					}
					else if(input.equals("B")) {
						if(B==0) {
							i=stack.size()-1;
							B=stack.get(i);
							printCalculator("B-->"+B);
							i=stack.size();
						}
						else {
							System.out.println(B);
							stack.push(B);
							printCalculator(stack.get(stack.size()-1).toString());
						}
					}
					else if(input.equals("C")) {
						if(C==0) {
							i=stack.size()-1;
							C=stack.get(i);
							printCalculator("C-->"+C);
							i=stack.size();
						}
						else {
							System.out.println(C);
							stack.push(C);
							printCalculator(stack.get(stack.size()-1).toString());
						}
					}
					//Borra el valor de las variables para poder asignarle uno nuevo
					else if(input.equals("cA")) {
						A=0;
						printCalculator("A-->"+A);
					}
					else if(input.equals("cB")) {
						B=0;
						printCalculator("B-->"+B);
					}
					else if(input.equals("cC")) {
						C=0;
						printCalculator("C-->"+C);
					}
				}
				else if(!input.equals("x")) {
					System.out.println("Syntax error");
				}
				//Se coloca el resultado de la operacion encima 
				//de la pila
				
			}
			printCalculator(stack.get(stack.size()-1).toString());
		}
		printCalculator("Thank you for using my RPN calculator! :3");
	}
	
	
	public String toString(){
		return "";
	}
}
