package com.company;

public class ReverseList {
    private Node head;
    private class Node {
        public String letter;
        public Node next;
        Node (String input) {
            letter = input;
            next = null;
        }
    }

    public ReverseList()
    {
        head = null;
    }

    public void add(String n) {
        Node node = new Node(n);
        if (head == null) {
            head = node;
        }
        else{
            Node temp = head;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    //O(N)  space O(1)
    public void reverseIterative()
    {
        Node prev = null;
        Node next = null;
        Node curr = head;

        // 1 ->3 ->2 ->4 ->null
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //O(N) space O(N)
    private Node reverseHelper(Node node)
    {
        if(node == null||node.next == null)
            return node;
        Node temp = reverseHelper(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }
    public void reverseRecursive()
    {
        head = reverseHelper(head);
    }

    public void printList()
    {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.letter);
            temp = temp.next;
        }
        System.out.println();
    }
}
