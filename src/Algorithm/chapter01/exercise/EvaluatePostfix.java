package Algorithm.chapter01.exercise;

import java.util.Stack;

public class EvaluatePostfix {
    public static double evaluate(String exp) {
        Stack<Double> dataStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char p = exp.charAt(i);
            if (CompleteParentheses.isDigit(p)) {
                dataStack.push((double)(p-'0'));
            } else if (CompleteParentheses.isOperator(p)) {
                double data2 = dataStack.pop();
                double data1 = dataStack.pop();
                if (p == '+') dataStack.push(data1+data2);
                else if (p == '-') dataStack.push(data1-data2);
                else if (p == '*') dataStack.push(data1*data2);
                else if (p == '/') dataStack.push(data1/data2);
            }
        }
        return dataStack.pop();
    }

    public static void main(String[] args) {
        String expr = "123*+45*6+7*+";
        System.out.println(evaluate(expr));
    }
}
