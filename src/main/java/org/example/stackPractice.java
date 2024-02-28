package org.example;

import java.util.Stack;

public class stackPractice {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        stack.push('a');
        stack.push('a');
        stack.push('a');
        stack.push('b');


        System.out.println(stack.pop());

    }
}
