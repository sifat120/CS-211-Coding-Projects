import java.util.Stack;

public class PostfixEvaluation {
    //stack to keep track of operands
    private static Stack<Integer> stack = new Stack<>();
    public static int PostFixEvaluation(String postfix) {
        //result is returned value
        int result = 0;
        //clear stack
        stack.clear();

        //iterate through the string
        for(int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            //add integer value of c to the stack
            if(c >= '0' && c <= '9') {
                int intVal = c-'0';
                stack.push(intVal);
            }

            if(c == '+' || c == '-' || c == '*' || c == '/') {
                //operand2 is first because order matters in / & - operations
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                //check for different cases (depends on c)
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

                //push the final result to the stack
                stack.push(result);
            }
        }

        //return the value of the mathematical expression
        return result;
    }
}
