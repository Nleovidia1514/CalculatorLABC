package com.Calculator.labc;
import java.util.*;

public class Test extends Gui {
	private static Stack<Double> stack = new Stack<Double>();
	//i permite que el programa funcione correctamente
	private int i=0;
	private String input="";
	private double A=0,B=0,C=0;
	private double a = 0;
	private Scanner sn = new Scanner(System.in);
	
	Queue<String> convertInfixToRPN(String [] infixNotation) {
		Map<String, Integer> prededence = new HashMap<>();
        prededence.put("/", 5);
        prededence.put("*", 5);
        prededence.put("+", 4);
        prededence.put("-", 4);
        prededence.put("(", 0);
 
        Queue<String> Q = new LinkedList<>();
        Stack<String> S = new Stack<>();
 
        for (String token : infixNotation) {
            if ("(".equals(token)) {
                S.push(token);
                continue;
            }
 
            if (")".equals(token)) {
                while (!"(".equals(S.peek())) {
                    Q.add(S.pop());
                }
                S.pop();
                continue;
            }
            // an operator
            if (prededence.containsKey(token)) {
                while (!S.empty() && prededence.get(token) <= prededence.get(S.peek())) {
                    Q.add(S.pop());
                }
                S.push(token);
                continue;
            }
 
            if (isNumber(token)) {
                Q.add(token);
                continue;
            }
 
            throw new IllegalArgumentException("Invalid input");
        }
        // at the end, pop all the elements in S to Q
        while (!S.isEmpty()) {
            Q.add(S.pop());
        }
 
        return Q;
	}
	static boolean isNumber(String str) {
        try{
            Double.valueOf(str);
            return true;
        } catch(Exception e){
            return false;
        }
    }
	public void ops() {
		while(!input.equals("x")) {
			//Si la entrada es de tipo double ejecuta el try statement 
			//si es de tipo String ejecuta el catch statement
			input=sn.nextLine();
			Queue<String> tokens = convertInfixToRPN(input.split(" "));

			for (String tok : tokens) {
				try {
					
					stack.push(Double.valueOf(tok));
					printCalculator(stack.get(stack.size()-1).toString());
				}catch(Exception e) {
					if(tok.equals("+")||tok.equals("-")||tok.equals("*")||tok.equals("/")||tok.equals("c")||tok.equals("omg")
					||tok.equals("$")||tok.equals("^")||tok.equals("zelda")) {
						String toprint ="";
						for (int i = 0; i < stack.size(); i++) {
							toprint += " " + stack.get(i);
						}
						toprint += " " + tok;
						System.out.println(toprint);
						//Se utiliza un contador para sumar todo lo que pueda
						//introducir el usuario
						if (tok.equals("+")) {
							while(stack.size()>i) {
								a+=stack.pop();						
							}
							printCalculator(String.valueOf(a));
							stack.push(a);
						}
						else if(tok.equals("-")) {
							if (stack.size()<2) {
								printCalculator("                     Syntax error                     |   |");
							}
							else {
								try{
									a=stack.remove(i-1);
									while(stack.size()>i-1) {
										a=a-stack.pop();
								    }
								}catch(Exception o) {
									a=stack.remove(0);
									while(stack.size()>i) {
										a=a-stack.pop();
								    }
								}
								printCalculator(String.valueOf(a));
								stack.push(a);
					       }
						}	
						else if(tok.equals("*")) {
							if(stack.size()<2) {
								printCalculator("                     Syntax error                     |   |");
							}
							else {
								while(stack.size()>i) {
									a=stack.pop()*stack.pop();
							   }
							}
							printCalculator(String.valueOf(a));
							stack.push(a);
						}
						else if(tok.equals("/")) {
							if(stack.size()<2) {
								printCalculator("                     Syntax error                     |   |");
							}
							else {
								while(stack.size()>i) {
									double d,g;
									d=stack.pop();g=stack.pop();
									a=g/d;
								}
								printCalculator(String.valueOf(a));
							}
							stack.push(a);
						}
						else if(tok.equals("^")) {
							double d,g;
							if(stack.size()<2) {
								printCalculator("                     Syntax error                     |   |");
								
							}
							else {
								g=stack.pop();d=stack.pop();
								a=Math.pow(d,g);
								printCalculator(String.valueOf(a));
								
							}
							stack.push(a);
						}
						else if(tok.equals("$")) {
							i=stack.size();
							a=Math.sqrt(stack.get(i-1));
							printCalculator(String.valueOf(a));
							stack.push(a);
						}
						else if(tok.equals("c")) {
							while(!stack.empty()) {
								stack.pop();
								a=0;
								printCalculator("                      CLEARED!                        |   |");
							}
						}
						else if(tok.equals("omg")) {
							printCalculator("            You've found an easter egg c:             |   |");
							while(!stack.empty()) {
								stack.pop();
								a=0;
							}
						}
						else if (tok.equals("zelda")) {
						    zelda();
							while(!stack.empty()) {
								stack.pop();
								a=0;
							}
						}
						i=stack.size();
					}
					//Operaciones para el manejo de variables en la memoria de la calculadora
					else if (tok.equals("A")||tok.equals("B")||tok.equals("C")
							||tok.equals("cA")||tok.equals("cB")||tok.equals("cC")) {
						if(tok.equals("A")) {
						    if(A==0) {
						    	i=stack.size()-1;
								A=stack.get(i);
								printCalculator("A-->"+A);
								i=stack.size();
						    }
						    else {
						    	stack.push(A);
						    	printCalculator(stack.get(stack.size()-1).toString());
						    }
						}
						else if(tok.equals("B")) {
							if(B==0) {
								i=stack.size()-1;
								B=stack.get(i);
								printCalculator("B-->"+B);
								i=stack.size();
							}
							else {
								stack.push(B);
								printCalculator(stack.get(stack.size()-1).toString());
							}
						}
						else if(tok.equals("C")) {
							if(C==0) {
								i=stack.size()-1;
								C=stack.get(i);
								printCalculator("C-->"+C);
								i=stack.size();
							}
							else {
								stack.push(C);
								printCalculator(stack.get(stack.size()-1).toString());
							}
						}
						//Borra el valor de las variables para poder asignarle uno nuevo
						else if(tok.equals("cA")) {
							A=0;
							printCalculator("A-->"+A);
						}
						else if(tok.equals("cB")) {
							B=0;
							printCalculator("B-->"+B);
						}
						else if(tok.equals("cC")) {
							C=0;
							printCalculator("C-->"+C);
						}
					}
					else if(!tok.equals("x")) {
						printCalculator("                     Syntax error                     |   |");
					}
					//stack.clear();
					System.out.println(stack.size());
					//Se coloca el resultado de la operacion encima 
					//de la pila
					//stack.push(a);
					
				}
			}
			

		}
		printCalculator("      Thank you for using my RPN calculator! :3       |   |");
	}
	
	
	public String toString(){
		return "";
	}
}
