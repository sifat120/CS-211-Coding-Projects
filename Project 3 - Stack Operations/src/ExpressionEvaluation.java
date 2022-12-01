import java.util.HashMap;
import java.util.Stack;

public class ExpressionEvaluation {
    //returned value
    private static String error;
    //stack to keep track of parentheses and curly braces
    private static Stack<Character> stack = new Stack<>();
    public static boolean ExpressionEvaluation(String exp) {
        //initialize class variables (and clear)
        init();

        //iterate through the string expression
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            //if c is opening, then push to stack and store index in hashmap
            if(c == '(' || c == '{') {
                stack.push(c);
            }

            if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    //check for incorrect pair
                    if(stack.pop() == '{') {
                        updateError(i,false); //for '{' to return '}'
                        return false;
                    }
                }
                //nothing is in stack, meaning that there is no opening curly parentheses
                if(stack.isEmpty()) {
                    updateError(i);
                    return false;
                }
                stack.pop(); //pop '('
            }

            if(c == '}') {
                while(!stack.isEmpty() && stack.peek() != '{') {
                    //check for incorrect pair
                    if(stack.pop() == '(') {
                        updateError(i,true); //for '(' to return ')'
                        return false;
                    }
                }
                //nothing is in stack, meaning that there is no opening curly brace
                if(stack.isEmpty()) {
                    updateError(i);
                    return false;
                }
                stack.pop(); //pop '{'
            }
        }
        //this is for case that there is opening parentheses or bracket but no complement
        if(!stack.isEmpty()) {
            updateError(exp.length()-1);
            return false;
        }

        //if none of those conditions are true, then we have valid expression
        return true;
    }

    //initialize/clear all class variables
    private static void init() {
        error = "";
        stack.clear();
    }

    //#1 way to update error, which is just default
    private static void updateError(int spaces) {
        for(int i = 0; i < spaces; i++) {
            error += " ";
        }
        error += "^ Incomplete Expression";
    }

    //#2 way to update error; this is the case when we have wrong pair
    private static void updateError(int spaces, boolean type) {
        for(int i = 0; i < spaces; i++) {
            error += " ";
        }
        error += "^";
        // true is for ')' and false is for '}'
        if(type) {
            error += " ) expected";
        } else {
            error += " } expected";
        }
    }

    //return the class variable error
    public static String returnError() {
        return error;
    }
}
