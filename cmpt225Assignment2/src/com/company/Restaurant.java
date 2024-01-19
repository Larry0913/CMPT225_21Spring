package com.company;

public class Restaurant {
    private Node head;
    private class Node {
        public int data;
        public Node next;
        Node (int input) {
            data = input;
            next = null;
        }
    }

    public Restaurant()
    {
        head = null;
    }

    //O(N)
    public int dequeue()
    {
        Node temp = head;
        if(head == null)
            return -1;
        if(temp.next == null)
        {
            head = null;
            return temp.data;
        }
        while(temp.next.next!=null)
        {
            temp = temp.next;
        }
        int newData = temp.next.data;
        temp.next = null;
        return newData;
    }

    //O(N)
    public void addFront(int data)
    {
        Node newNode = new Node(data);
        Node temp = head;
        if(head == null)
        {
            head = newNode;
            return;
        }
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    //O(1)
    public void addLast(int data)
    {
        Node newNode = new Node(data);
        Node temp = head;
        newNode.next = temp;
        head = newNode;
    }

    public String toString()
    {
        String temp = "";
        Node node = head;
        while(node != null) {
            temp += node.data;
            node = node.next;
        }
        return temp;
    }
}
