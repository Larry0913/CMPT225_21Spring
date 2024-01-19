package com.company;

import java.util.Stack;

public class MyQueue {
    private Stack<String> stack1;
    private Stack<String> stack2;
    private String first;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        first = "";
    }

    //Operation efficiency is O(1)
    public void enqueue(String data) {
        if (stack1.isEmpty())
            first = data;
        stack1.push(data);
    }

    //Operation efficiency is O(N)
    public String dequeue() {
        //Stack1: 3 2 1 4
        //Stack2: 4 1 2 3
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        String temp = stack2.pop();
        first = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return temp;
    }

    //Operation efficiency is O(1)
    public String front() {
        return first;
    }

    //Operation efficiency is O(1)
    public int size() {
        return stack1.size();
    }

    //Operation efficiency is O(1)
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < size(); i++)
            System.out.print(stack1.elementAt(i) + " ");
        System.out.println();
    }
}