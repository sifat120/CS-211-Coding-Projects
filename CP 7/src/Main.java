import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static Scanner input = new Scanner(System.in);
    private static boolean checkChar(char a, char b) {
        if ((a=='{' && b=='}') || (a=='(' && b==')')) return true;
        return false;
    }
    public static void main(String[] args) {
        while(true) {
            stack.clear();

            System.out.print("Enter a math expression: ");
            String exp = input.nextLine();

            if(exp.length()==0) {
                System.out.println("Bye...");
                break;
            }

            boolean b = true;
            for(int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);
                if (c == '(' || c == '{') {
                    stack.push(c);
                }
                else if(c == ')' || c == '}') {
                    if (stack.isEmpty() || !checkChar(stack.pop(),c)) b = false;
                }
            }
            if(b && stack.isEmpty()) {
                System.out.println("correct expression \n");
            } else {
                System.out.println("wrong expression \n");
            }
        }
    }
}