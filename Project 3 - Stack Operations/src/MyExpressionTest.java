//Project 3 (Stack Operations)
//Name: Sifat Hasan
//ID: 202887233
//Date: 11/10/2022
//Project Description: This project performs stack operations given
//a mathematical expression.


import java.util.Scanner;

public class MyExpressionTest {
    //taking input from user
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //start of program
        System.out.println("CS 211. Fall Quarter 2022.");

        //continue until user hits enter without any input
        while(true) {
            System.out.println();

            //ask user for math expression
            System.out.print("Enter a math expression: ");
            String infix = input.nextLine();

            //break if no input provided
            if(infix.length() == 0) {
                System.out.println("Bye!");
                break;
            }

            //check to see if expression is valid
            boolean valid = ExpressionEvaluation.ExpressionEvaluation(infix);

            //perform stack operations if valid, otherwise return error message
            if(valid) {
                System.out.println("infix: " + infix);

                String postfix = InfixToPostfix.InfixToPostfix(infix);
                System.out.println("postfix: " + postfix);

                int result = PostfixEvaluation.PostFixEvaluation(postfix);
                System.out.println("result: " + result);
            } else {
                System.out.println(infix);
                System.out.println(ExpressionEvaluation.returnError());
            }
        }
    }
}