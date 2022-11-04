import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner input = new Scanner(System.in);

    private static int postfixEvaluation(String postfix) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        stack.clear();

        for(int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if(c >= '0' && c <= '9') {
                int intVal = c-'0';
                stack.push(intVal);
            }

            if(c == '+' || c == '-' || c == '*' || c == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch(c) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                }
                stack.push(result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println();
            System.out.println("Enter a postfix expression");
            String postfix = input.nextLine();

            if(postfix.length() == 0) {
                System.out.println("Bye...");
                break;
            }

            int result = postfixEvaluation(postfix);

            System.out.println("postfix: " + postfix);
            System.out.println("result: " + result);
        }
    }
}