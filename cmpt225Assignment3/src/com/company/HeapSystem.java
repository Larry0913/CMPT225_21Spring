package com.company;

import java.util.ArrayList;

public class HeapSystem {
    private ArrayList<ListPriorityQueue.Task> newHeap;

    public HeapSystem(BranchingOut.Tree T){
        newHeap = new ArrayList<>();
        treeInsert(T.getRoot());

    }

    public void swapValue(int index1, int index2){
        ListPriorityQueue.Task temp = new ListPriorityQueue.Task( newHeap.get(index1).description, newHeap.get(index1).importance_number);
        newHeap.set(index1,newHeap.get(index2));
        newHeap.set(index2,temp);
    }

    public void bubbleUp(int index){
        int parentIndex = (index - 1)/2;
        if(newHeap.get(parentIndex).importance_number>newHeap.get(index).importance_number){
            ListPriorityQueue.Task temp = newHeap.get(index);
            newHeap.set(index,newHeap.get(parentIndex));
            newHeap.set(parentIndex,temp);
            bubbleUp(parentIndex);
        }
    }
    public void insert(String des, int impNum){
        ListPriorityQueue.Task taskIn = new ListPriorityQueue.Task(des, impNum);
        newHeap.add(taskIn);

        int lastValueIndex = newHeap.size()-1;
        while((lastValueIndex != 0 )&&(newHeap.get(lastValueIndex).importance_number < newHeap.get((lastValueIndex-1) / 2).importance_number)){
            swapValue((lastValueIndex-1)/2 , lastValueIndex);
            lastValueIndex = (lastValueIndex-1)/2;
        }
    }

    public void treeInsert(BranchingOut.Node tempRoot){
        if(tempRoot == null){
            return;
        }
        insert(tempRoot.getDes(), tempRoot.getNumber());
        for(int i = 0; i < tempRoot.getChildren().size(); i++){
            treeInsert(tempRoot.getChildren().get(i));
        }
    }

    public void bubbleDown(int index){
        if(index >= (newHeap.size() - 1) / 2){
            return;
        }
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if(newHeap.get(index).importance_number < newHeap.get(leftIndex).importance_number || newHeap.get(index).importance_number < newHeap.get(rightIndex).importance_number){
            if(newHeap.get(leftIndex).importance_number < newHeap.get(rightIndex).importance_number){
                swapValue(index, rightIndex);
                bubbleDown(rightIndex);
            }
            else{
                swapValue(index, leftIndex);
                bubbleDown(leftIndex);
            }
        }
    }

    public ListPriorityQueue.Task removeMin(){
        ListPriorityQueue.Task temp = new ListPriorityQueue.Task(newHeap.get(0).description,newHeap.get(0).importance_number);
        newHeap.set(0,newHeap.get(newHeap.size() - 1));
        newHeap.remove(newHeap.size() - 1);
        bubbleDown(0);
        return temp;
    }

    public ListPriorityQueue.Task peek(){
        return newHeap.get(0);
    }

    public void printHeap(){
        for(int i =0;i< newHeap.size();i++) {
            System.out.println("The task Name is \""+newHeap.get(i).description +"\", the importance level is "+ newHeap.get(i).importance_number+".");
        }
        System.out.println();
    }
}