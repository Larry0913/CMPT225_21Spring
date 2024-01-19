package com.company;

public class Entry<V> {
    public int key;
    public V value;

    public Entry(int key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return String.format("%d",key);
    }

}
