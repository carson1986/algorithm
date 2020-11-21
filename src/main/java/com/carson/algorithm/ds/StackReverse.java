package com.carson.algorithm.ds;

import java.util.Stack;

/**
 * 利用递归函数，反转栈
 */
public class StackReverse {

    /**
     * 返回栈底元素
     * @param stack
     * @return
     */
    private static int getAndRemoveLastItem(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastItem(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack == null){
            throw new RuntimeException("stack is null");
        }

        if(stack.isEmpty()){
            return ;
        }

        int last = getAndRemoveLastItem(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverse(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
