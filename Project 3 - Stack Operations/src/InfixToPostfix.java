import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {
    //stack contains the parentheses, curly braces, and operators
    private static Stack<Character> stack = new Stack<>();
    //hashmap is used to determine precedence between different operators
    private static HashMap<Character, Integer> precedence = new HashMap<>();

    public static String InfixToPostfix(String infix) {
        //initialize the precedence hashmap
        loadPrecedence();

        //clear stack and initialize the returned value 'postfix'
        stack.clear();
        String postfix = "";

        //iterate through the string
        for(int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            //add to returned value if c is a number
            if(c >= '0' && c <= '9') {
                postfix += c;
            }

            //add to stack if c is opening curly brace or parentheses
            if(c == '(' || c == '{') {
                stack.push(c);
            }

            if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    //add popped values to postfix
                    postfix += stack.pop();
                }
                stack.pop(); //pops '(' from stack
            }

            if(c == '}') {
                while(!stack.isEmpty() && stack.peek() != '{') {
                    //add popped values to postfix
                    postfix += stack.pop();
                }
                stack.pop(); //pops '{' from stack
            }

            if(c == '+' || c == '-' || c == '*' || c == '*') {
                //check if the top of stack has an opening parentheses or curly brace
                if(stack.isEmpty() || stack.peek() == '(' || stack.peek() == '{') {
                    stack.push(c); //push character to stack
                } else {
                    //check if current operand has smaller than the one in the stack
                    while(!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(c)) {
                        postfix += stack.pop(); //add popped vals to postfix
                    }
                    stack.push(c); //push the character to the stack
                }
            }
        }

        //add all remaining elements from stack to postfix
        while(!stack.isEmpty()) {
            postfix += stack.pop();
        }

        //return the postfix string
        return postfix;
    }

    //method to initialize precedence hashmap
    private static void loadPrecedence() {
        precedence.put('+',1);
        precedence.put('-',1);
        precedence.put('*',2);
        precedence.put('/',2);
    }
}
