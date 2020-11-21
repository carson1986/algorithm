package com.carson.algorithm.ds;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class TwoStacksQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue(){
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    //把压入栈，写入，弹出栈
    private void pushToPop(){
        if(!stackPop.isEmpty()){
            return ;
        }

        while (!stackPush.isEmpty()){
            stackPop.push(stackPush.pop());
        }
    }

    public void add(int item){
        stackPush.push(item);
        pushToPop();
    }

    public Integer poll() throws Exception {
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new Exception("queue is empty");
        }

        pushToPop();
        return stackPop.pop();
    }

    public Integer peek() throws Exception {
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new Exception("queue is empty");
        }

        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) throws Exception {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.add(3);
        System.out.println(queue.poll());
    }
}
