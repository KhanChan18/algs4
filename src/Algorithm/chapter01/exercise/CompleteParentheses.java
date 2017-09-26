package Algorithm.chapter01.exercise;

import java.util.Stack;

public class CompleteParentheses {
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    public static String completeParentheses(String s) {
        Stack<String> oprStack = new Stack<>();
        Stack<String> dataStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (isDigit(p)) {
                dataStack.push(String.valueOf(p));
            } else if (isOperator(p)) {
                oprStack.push(String.valueOf(p));
            } else {
                String data2 = dataStack.pop();
                String data1 = dataStack.pop();
                String opr = oprStack.pop();
                String exp = "("+data1+opr+data2+")";
                dataStack.push(exp);
            }
        }
        return dataStack.pop();
    }

    public static void main(String[] args) {
        String s = "1+2)*3-4)*5-6)))";
        System.out.println(completeParentheses(s));
    }
}
