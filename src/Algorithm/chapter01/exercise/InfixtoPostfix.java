package Algorithm.chapter01.exercise;

import java.util.HashMap;
import java.util.Stack;

public class InfixtoPostfix {
    private static HashMap<Character, Integer> priority = new HashMap<Character, Integer>();

    public static String infix2Postfix(String exp) {
        {
            priority.put('+',1);
            priority.put('-',1);
            priority.put('*',2);
            priority.put('/',2);
            priority.put('(',0);
        }

        Stack<Character> stack = new Stack<>();
        String res = "";

        for (int i = 0; i < exp.length(); i++) {
            char p = exp.charAt(i);
            if (! CompleteParentheses.isOperator(p) && p != '(' && p != ')') {
                res = res + p;
            } else if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                char temp = stack.pop();
                while (temp != '(') {
                    res += temp;
                    temp = stack.pop();
                }
            } else if (CompleteParentheses.isOperator(p)) {
                if (!stack.isEmpty()) {
                    char temp = stack.pop();
                    int p2 = priority.get(p);
                    int p1 = priority.get(temp);
                    while (p1 >= p2) {
                        res += temp;
                        p1 = -1;
                        if (!stack.isEmpty()) {
                            temp = stack.pop();
                            p1 = priority.get(temp);
                        }
                    }
                    if ((p1 < p2) && (p1 != -1)) {
                        stack.push(temp);
                    }
                }
                stack.push(p);
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String exp = "a+b*c+(d*e+f)*g";
        System.out.println(infix2Postfix(exp));
    }
}
