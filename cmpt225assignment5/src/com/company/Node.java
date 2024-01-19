package com.company;

public class Node<V> {
    Entry<V>data;
    Node<V> left;
    Node<V> right;

    public Node(Entry<V> data, Node<V> left, Node<V> right, Node<V> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("Entry: %s, left : %s, right : %s. ",
                data.toString(),
                left == null?"null":left.data.key,
                right == null?"null":right.data.key
                );

    }
}
