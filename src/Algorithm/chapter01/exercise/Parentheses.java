package Algorithm.chapter01.exercise;

import Algorithm.chapter01.MyStack;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    public static boolean isPaired(String ls, String rs) {
        if (ls == "(" && rs == ")")
            return true;
        else if (ls == "[" && rs == "]")
            return true;
        else if (ls == "{" && rs == "}")
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isPaired("["," "));

        /*
        String[] input = {"[","(","]",")"};
        Stack<String> stack = new Stack<>();
        for(String p: input) {
            if (p == "(" || p == "[" || p == "{")
                stack.push(p);
            else if (p == ")" || p == "]" || p == "}") {
                if (isPaired(stack.pop(), p))
                    continue;
                else {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
        */
    }
}


