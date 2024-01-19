package com.company;

import java.util.ArrayList;


public class BranchingOut {
    public static class Node {
        private final String description;
        private final int importance_number;
        private Node parent;
        private ArrayList<Node> children;

        Node(String des, int num) {
            description = des;
            importance_number = num;
            children = new ArrayList<>();
        }

        public int getNumber() {
            return importance_number;
        }

        public String getDes() {
            return description;
        }

        public void setParent(Node node) {
            parent = node;
        }

        public Node getParent() {
            return parent;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public void addNode(String taskName, int num) {
            Node newNode = new Node(taskName, num);
            children.add(newNode);
            newNode.setParent(this);
        }

        public void addNode(Node node) {
            if (node == null)
                return;
            children.add(node);
            node.setParent(this);
        }
    }

    public static class Tree {
        private Node root;
        private int size;
        private int[] importCount = new int[10];

        Tree() {
            root = new Node("Open up in the morning", 11);
            importCount = new int[11];
        }

        public Node getRoot() {
            return root;
        }

        public void insert(Node tempParent, String des, int value) {
            Node newNode = new Node(des, value);
            tempParent.addNode(newNode);
            size++;
            importCount[value - 1]++;
        }

        public void insert(Node tempParent, Node node) {
            tempParent.addNode(node);
            size++;
            importCount[node.getNumber() - 1]++;
        }

        public void remove(Node node) {
            Node temp1 = node.getParent();
            ArrayList<Node> temp2 = node.getChildren();
            for (int i = 0; i < temp2.size(); i++) {
                temp1.addNode(temp2.get(i));
            }
            temp1.getChildren().remove(node);
            size--;
            importCount[node.getNumber() - 1]--;
            root = temp1;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int levelNum(int num) {
            return importCount[num];
        }

        public void printCount() {
            for (int i = 0; i < 10; i++) {
                int count = i + 1;
                System.out.println("There are " + importCount[i] + " task of " + count + " importance.");
            }
        }

        public void printWholeTree(Node root) {
            if (root == null)
                return;
            if(root.parent == null)
                System.out.println("The task Name is \""+root.getDes() + "\", the importance level is " + root.getNumber()+".");
            else
                System.out.println("The task Name is \""+root.getDes() + "\", the importance level is " + root.getNumber()+", and its parent is \""+root.parent.getDes()+"\".");
            for (int i = 0; i < root.getChildren().size(); i++) {
                printWholeTree(root.children.get(i));
            }
        }

        public boolean find(Node root, String value) {
            ArrayList<Node> children = root.getChildren();
            if(root.getDes().equals(value))
                return true;
            for (Node child : children) {
                if (child.getDes().equals(value) || (child.getChildren().size() > 0 && find(child, value))) {
                    return true;
                }
            }
            return false;
        }

        public Node target(Node root, String name) {
            ArrayList<Node> children = root.getChildren();
            if(root.getDes().equals(name))
                return root;
            for (Node child : children) {
                if (child.getDes().equals(name) || (child.getChildren().size() > 0 && find(child, name))) {
                    return child;
                }
            }
            return null;
        }
    }
}