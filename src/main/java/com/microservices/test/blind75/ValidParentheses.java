package com.microservices.test.blind75;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Opening brackets pushed to the stack
     * others pop from the stack
     * then compare the current must be the opponent of the poped opening bracket
     * otherwise should return false
     * return stack.isEmpty()
     */

    public boolean isValid(String input) {

        if (input.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (Character ch : input.toCharArray()) {
            // opening brackets pushed to the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    static void main() {
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("[{!}]"));
    }
}
