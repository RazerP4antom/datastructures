// examine next element in input 
// if operand, output it 
// if '(' push it to stack
// if operator then:
    //a) Stack is empty, push operator on stack
    //b) if top of stack is '(' push operator on stack
    //c) if it has highes priority than top of the stack, push operator on stack
    //d) else(equal or lower priority) pop the operator from the stackand output it
// if ')' pop operator from stack and output it till a '(' is encountered and discard both parenthesis
// repeat and pop remaining operators and print

import java.util.Stack;


public class infixToPostfix {

    // a utility function to return
    // precedence of a given operator 
    // Higher returned value means higher precedence

    public static int precedence(char ch){

        switch(ch){

            case '+':
            case '-':
                return 1;
            
            case '*':
            case '/':
                return 2;
            
            case '^':
                return 3;
        }
        
        return -1;
    }


    // method to convert infix to postfix

    public static String infixToPostfix(String exp){

        // empty string for result
        String result = new String("");

        // empty stack
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < exp.length(); ++i){

            char c = exp.charAt(i);

            // if scanned charactre is an operand and output it
            if(Character.isLetterOrDigit(c))
                result += c;

            // if scanned character is '(' push it to stack

            else if(c == '(')
                stack.push(c);

            // if the scanned character is an ')'
            // pop and output from the stack
            // until an '(' is encountered

            else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            }

            else // when an operator is encountered
            {
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result += stack.pop();
                
                stack.push(c);
            }
            
            
        }


        //poping all operators from the stack
        while(!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }

        return result;

    }
    



    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

}
