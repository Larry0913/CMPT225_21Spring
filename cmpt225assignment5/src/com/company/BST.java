package com.company;

public class BST<V> {
    private Node<V> root;
    private int size;
    private int count;
    private double median;

    public BST(){
        this.root = null;
        size = 0;
        count = 0;
        median = 0;
    }

    public void insert(Entry<V> entry){
        root = insertRec(root,entry);
        size++;
    }

    private Node<V> insertRec(Node<V> root,Entry<V> entry){
        if(root == null)
        {
            root = new Node<V>(entry, null, null, null);
            return root;
        }
        if(entry.key<root.data.key)
            root.left = insertRec(root.left, entry);
        else
            root.right = insertRec(root.right, entry);

        return root;
    }

    public void remove(Entry<V>entry){
        root = deleteRec(root,entry);
        size--;
    }

    private Node<V> deleteRec(Node<V> root, Entry<V> entry){
        int key = entry.key;
        if(root == null)
            return null;

        if(key < root.data.key)
            root.left = deleteRec(root.left, entry);
        else if(key > root.data.key)
            root.right = deleteRec(root.right, entry);
        else {
            if (root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.data.key = minValue(root.right);
            root.right = deleteRec(root.right,root.data);
        }
        return root;
    }

    private int minValue(Node<V> root){
        int minV = root.data.key;
        while(root.left != null){
            minV = root.left.data.key;
            root = root.left;
        }
        return minV;
    }

    public double mean(){
        return size == 0 ? 0 : sum(root) / (size * 1.0);
    }

    private int sum(Node<V> root){
        if(root == null)
            return 0;
        return sum(root.left) + sum(root.right) + root.data.key;
    }

    public double median(){
        count = 0;
        median = 0;
        medianRec(root);
        if (size % 2 == 0) {
            return (median / 2);
        } else {
            return median;
        }
    }

    private void medianRec(Node<V> root){
        if (root != null) {
            medianRec(root.left);
            if (size % 2 == 0) {
                if (count == (size/2 - 1) || count == size/2) {
                    median += root.data.key;
                }
            } else {
                if (count == size/2) {
                    median += root.data.key;
                }
            }
            count++;
            medianRec(root.right);
        }
    }

    public boolean search(int key) {
        Node<V>tempRoot = searchRec(root, key);
        return tempRoot != null;
    }

    private Node<V> searchRec(Node<V> root, int key) {
        if (root == null || root.data.key == key) {
            return root;
        }
        if (root.data.key < key) {
           // System.out.println(root.data.key);
            return searchRec(root.right, key);
        }
        else {
           // System.out.println(root.data.key);
            return searchRec(root.left, key);
        }
    }

    public void print() {
        preorder(root,"");
    }

    private void preorder(Node<V> root,String prefix){
        if(root == null)
            return;
        System.out.println(prefix + root.toString());
        preorder(root.left, prefix + "\t");
        preorder(root.right,prefix + "\t");
    }
}
