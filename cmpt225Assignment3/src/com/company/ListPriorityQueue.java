package com.company;

import java.util.ArrayList;
import java.util.Comparator;


public class ListPriorityQueue {
    public ArrayList<Task> treeNodeList = new ArrayList<Task>();

    public static class Task{
        public int importance_number;
        public String description;

        public Task(){
            importance_number = 0;
            description  = " ";
        }
        public Task(String data, int num){
            importance_number = num;
            description = data;
        }
        public void setDescription(String des){ description = des; }

        public void setImportance_number(int num){importance_number = num; }

        public String getDes(){ return description;}

        public int getImp(){return importance_number;}

        public void printTask(){
                System.out.println("The task Name is \"" + description + "\", the importance level is " + importance_number);

        }
    }

    public static class ListComparator implements Comparator<Task> {
        public int compare(Task number1, Task number2){
            return number1.importance_number - number2.importance_number;
        }
    }

    public ListPriorityQueue(BranchingOut.Tree tempTree) {
        BranchingOut.Node tempRoot = tempTree.getRoot();
        treeNodeList = new ArrayList<Task>();
        setTreeList(tempRoot);

    }

    public ListPriorityQueue(BranchingOut.Node tempNode){
        treeNodeList = new ArrayList<>();
        setTreeList(tempNode);
    }
    public void setTreeList(BranchingOut.Node root){
        if(root == null){
            return;
        }
        Task temp1 = new Task(root.getDes(),root.getNumber());
        treeNodeList.add(temp1);
        ArrayList<BranchingOut.Node> temp2 = root.getChildren();
        for(int i = 0; i < temp2.size(); i++){
            setTreeList(temp2.get(i));
        }
    }

    public void add( String data,int imp){
        Task temp = new Task(data,imp);
        treeNodeList.add(temp);
    }

    public Task removeHead(){
       return treeNodeList.remove(0);
    }

    public void remove(Task task){
        treeNodeList.remove(task);
    }

    public Task peek(){
        return treeNodeList.get(0);
    }

    public Task target(ListPriorityQueue queue, String name) {
        for(int i = 0;i<queue.treeNodeList.size();i++) {
            if (queue.treeNodeList.get(i).getDes().equals(name)) {
                return queue.treeNodeList.get(i);
            }
        }
        return null;
    }
    public void print(){
        for(int i = 0; i < treeNodeList.size(); i++)
            System.out.println(treeNodeList.get(i).getDes());
    }

    public void sort(ArrayList<Task> queue){
        queue.sort(new ListComparator());
    }
}

