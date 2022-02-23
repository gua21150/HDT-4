//package main.java;

import java.util.Stack;

/***
 * Class that changes infix expressions to postfix expressions
 * @author Mariel Guamuche 2115
 * @author Aaron Beltran 21092
 * @author Diana Diaz 21066
 * @since 21022022
 */
public class InfixPostfix {
    private final Stack<Character> stack = new Stack<>(); // donde se guardan temporalmente los datos

    /***
     * Changes a string infix expression to a postfix expression
     * @param infix String with de expression
     * @return String of postfix expression
     */
    public String conversion(String infix) {
        // esta es la expresion que se retornara
        String postFix = ""; // delete every element introduced into this string
        char[] aChar = infix.toCharArray(); // cambio de string a un array de chars
        for (char c: aChar) {
            if(c!='+' && c!='-' && c!='*' && c!='/' && c!='^' && c!='(' && c!=')') {
                postFix += c; // se agrega el numero
            } else {
                if (c=='(')
                    stack.push(c);
                else {
                    if(c==')') {
                        while (!stack.isEmpty()) {
                            char t = stack.pop();
                            if(t!='(')
                                postFix += t;
                            else
                                break;
                        }
                    } else {
                        if(stack.isEmpty())
                            stack.push(c);
                        else {
                            while(!stack.isEmpty()) {
                                char t = stack.pop();
                                if(t=='(') {
                                    stack.push(t);
                                    break;
                                } else{
                                    if(this.getPriority(t)<this.getPriority(c))  {
                                        stack.push(t); break;
                                    } else
                                        postFix += t;
                                }
                            }
                            stack.push(c);
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty())
            postFix += stack.pop();

        return postFix;
    }

    /**
     * Determines the priority of math expressions
     * @param sig Sign
     * @return Number of priority
     */
    private int getPriority(char sig) {
        int resultado=0;
        if (sig == '+' || sig == '-') {
            resultado = 1; // least priority
        } else if (sig == '*' || sig == '/') {
            resultado = 2; // middle priority
        } else if (sig == '^') {
            resultado = 3; // top priority
        }
        return resultado;
    }
}
