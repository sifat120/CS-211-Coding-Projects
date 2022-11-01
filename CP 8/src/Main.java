import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Character> myStack = new Stack<>();
    static Scanner input = new Scanner (System.in);
    static HashMap<Character, Integer> precedence = new HashMap<>();

    public static void main(String[] args) {
        loadPrecedence();

        while(true) {
            myStack.clear();
            String postfix = "";

            System.out.println();
            System.out.println("Enter an infix expression");
            String infix = input.nextLine();

            if(infix.length() == 0) {
                System.out.println("Bye...");
                break;
            }

            System.out.println("Infix: " + infix);

            for(int i = 0; i < infix.length(); i++) {
                char c = infix.charAt(i);

                if(c >= '0' && c <= '9') {
                    postfix += c;
                }

                if(c == '(' || c == '{') {
                    myStack.push(c);
                }

                if(c == ')') {
                    while(!myStack.isEmpty() && myStack.peek() != '(') {
                        postfix += myStack.pop();
                    }
                    myStack.pop();
                }

                if(c == '}') {
                    while(!myStack.isEmpty() && myStack.peek() != '{') {
                        postfix += myStack.pop();
                    }
                    myStack.pop();
                }

                if(c == '+' || c == '-' || c == '*' || c == '/') {
                    if(myStack.isEmpty() ||myStack.peek() == '(' || myStack.peek() == '{') {
                        myStack.push(c);
                    } else {
                        while(!myStack.isEmpty() && precedence.get(myStack.peek()) >= precedence.get(c)) {
                            postfix += myStack.pop();
                        }
                        myStack.push(c);
                    }
                }
            }

            while(!myStack.isEmpty()) {
                postfix += myStack.pop();
            }

            System.out.println("postfix: " + postfix);
        }
    }

    public static void loadPrecedence() {
        precedence.put('+',1);
        precedence.put('-',1);
        precedence.put('*',2);
        precedence.put('/',2);
    }
}