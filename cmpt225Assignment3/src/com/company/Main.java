package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //test1
        System.out.println("\n");
        System.out.println("Test Question 1 sample Branching Out... ");
        System.out.print("Begun to create some tasks...");
        System.out.println("\n");

        BranchingOut.Tree testTree = new BranchingOut.Tree();
        BranchingOut.Node task1 = new BranchingOut.Node("Collect litter", 5);
        BranchingOut.Node task2 = new BranchingOut.Node("Direct visitors", 8);
        BranchingOut.Node task3 = new BranchingOut.Node("Plant sapling", 3);
        BranchingOut.Node task4 = new BranchingOut.Node("Report smoke sightings", 10);
        BranchingOut.Node task5 = new BranchingOut.Node("Record wildlife sightings", 7);
        BranchingOut.Node task6 = new BranchingOut.Node("Clean the forestry station", 2);
        BranchingOut.Node root = testTree.getRoot();
        testTree.insert(root, task1);
        testTree.insert(root, task2);
        testTree.insert(root, task3);
        testTree.insert(task1, task4);
        testTree.insert(task1, task5);
        testTree.insert(task2, task6);

        System.out.println("Now print the tasks in the system...");
        System.out.println();
        testTree.printWholeTree(testTree.getRoot());
        System.out.println("\n");
        System.out.println("Now print the importance level of each task in the system..." + "\n");
        testTree.printCount();
        System.out.println();
        System.out.println("Now you can also join this system, please enter the tasks in this system...");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the task name: ");

        while (scan.hasNext()) {
            System.out.println();
            String taskName1 = scan.nextLine();
            System.out.println("Please enter the importance number: ");
            String importanceNumber1 = scan.nextLine();
            int num = Integer.parseInt(importanceNumber1);
            System.out.println();
            BranchingOut.Node tempTask = new BranchingOut.Node(taskName1, num);
            System.out.println("Please enter the name of the node which do you want to add below: ");
            String nodeBelow = scan.nextLine();
            System.out.println();
            if (testTree.find(testTree.getRoot(), nodeBelow)) {
                BranchingOut.Node targetNode = testTree.target(testTree.getRoot(), nodeBelow);
                testTree.insert(targetNode, tempTask);
            } else
                System.out.println("Sorry, system cannot find the corresponding node...");
            System.out.println("Do you want to continue to add or remove task in the system ? ");
            System.out.println("Please answer \"yes\" or \"no\"... ");
            String check = scan.nextLine();
            System.out.println();
            if (check.equalsIgnoreCase("yes")) {
                System.out.println("So do you want to add or remove task? Please answer \"add\" or \"remove\"...");
                String check2 = scan.nextLine();
                System.out.println();
                if (check2.equalsIgnoreCase("add")) {
                    System.out.println("Now all the tasks in the system is: ");
                    testTree.printWholeTree(testTree.getRoot());
                    System.out.println();
                    System.out.println("The importance level count is: ");
                    testTree.printCount();
                    System.out.println();
                    System.out.println("Please enter the task name: ");
                    System.out.println();
                } else {
                    System.out.println("Please enter the task name which you want to remove from the system:");
                    String removeName = scan.nextLine();
                    if (testTree.find(testTree.getRoot(), removeName)) {
                        BranchingOut.Node removeNode = testTree.target(testTree.getRoot(), removeName);
                        testTree.remove(removeNode);
                        System.out.println("Now all the tasks in the system is: ");
                        testTree.printWholeTree(testTree.getRoot());
                        System.out.println();
                        System.out.println("The importance level count is: ");
                        testTree.printCount();
                        System.out.println();
                        System.out.println("Please enter the task name: ");
                        System.out.println();
                    }

                }
            } else if (check.equalsIgnoreCase("no")) {
                System.out.println("Now all the tasks in the system are: ");
                testTree.printWholeTree(testTree.getRoot());
                System.out.println();
                System.out.println("The importance level count is: ");
                testTree.printCount();
                System.out.println();
                System.out.println("Thank you! Test 1 is over.");
                System.out.println("-------------------------------");
                break;
            }
        }

        //test2
        System.out.println("\n");
        System.out.println("Test Question 2 Priority Queue... ");
        System.out.println("Now create the queue and print the queue from the tree...");
        System.out.println();
        ListPriorityQueue testQue1 = new ListPriorityQueue(testTree);
            testQue1.print();

        System.out.println();
        System.out.println("Do you want to add or remove task from this queue? answer \"yes\" or \"no\" ");
        ListPriorityQueue testQue2 = new ListPriorityQueue(testTree);
        testQue2.sort(testQue2.treeNodeList);
        while (scan.hasNext()) {
            String answer = scan.nextLine();
            if (answer.equals("yes")) {
                {
                    System.out.println("So do you want add or remove task from the queue?");
                    System.out.println("Please answer \"add\" or \"remove\" ");
                    String answer2 = scan.nextLine();

                    System.out.println();
                    if (answer2.equalsIgnoreCase("add")) {
                        System.out.println("Please enter the task name you want to add: ");
                        String taskName2 = scan.nextLine();
                        System.out.println();
                        System.out.println("Please enter the importance level of that task: ");
                        String importanceNumber2 = scan.nextLine();
                        System.out.println();
                        int num2 = Integer.parseInt(importanceNumber2);
                        testQue2.add(taskName2, num2);
                        System.out.println("Do you want to add or remove one more? answer \"yes\" or \"no\"");
                    } else if (answer2.equalsIgnoreCase("remove")) {
                        System.out.println("Please enter the task name you want to remove: ");
                        String taskName3 = scan.nextLine();
                        System.out.println();
                        if (testQue2.target(testQue2, taskName3) != null) {
                            ListPriorityQueue.Task temp = testQue2.target(testQue2, taskName3);
                            testQue2.remove(temp);
                            System.out.println("Remove has done...");
                        } else {
                            System.out.println("Sorry, cannot find the task in the queue! ");

                        }
                        System.out.println("Do you want to add or remove one more? answer\" yes\" or \"no\" ");
                    }
                }
            } else{
                System.out.println("Now the queue is: ");
                testQue2.print();


                System.out.println("Thank you! Test 2 is over.");
                break;
            }
        }


            //testQ3
            System.out.println("-------------------------------");
            System.out.println("\n");
            System.out.println("Test Question 3 Heap System...");
            System.out.println("Now create the Heap System and print the heap from the tree...");
            System.out.println();
            HeapSystem testHeap = new HeapSystem(testTree);
            testHeap.printHeap();
            System.out.println();
            System.out.println("Now you can add or remove some tasks in the heap system...");
            System.out.println("Do you want to add or remove tasks? ");
            System.out.println("Please answer \"add\" , \"remove\" or leave(answer anything is ok)...");
            while (scan.hasNext()) {
                //System.out.println("Please answer \"add\" , \"remove\" or leave(answer anything is ok)...");
                System.out.println();
                String check3 = scan.nextLine();
                if (check3.equalsIgnoreCase("add")) {
                    System.out.println("Please enter the task name you want to add: ");
                    String taskName3 = scan.nextLine();
                    System.out.println();
                    System.out.println("Please enter the importance level of the task: ");
                    String importanceNum3 = scan.nextLine();
                    int num3 = Integer.parseInt(importanceNum3);
                    System.out.println();
                    testHeap.insert(taskName3, num3);
                    System.out.println("Task has added...");
                    System.out.println();
                    System.out.println("The heap system now is: ");
                    testHeap.printHeap();
                    System.out.println("Do you want to continue to add or remove tasks? ");
                    System.out.println("Please answer \"add\" , \"remove\" or leave(answer anything is ok)...");
                } else if (check3.equalsIgnoreCase("remove")) {
                    testHeap.removeMin();
                    System.out.println("The highest priority task has been removed...");
                    System.out.println("The heap system now is: ");
                    testHeap.printHeap();
                    System.out.println();
                    System.out.println("Do you want to continue to add or remove tasks? ");
                    System.out.println("Please answer \"add\" , \"remove\" or leave(answer anything is ok)...");
                } else {
                    System.out.println("The heap system now is: ");
                    testHeap.printHeap();
                    System.out.println("Thank you! Test 3 is over.");
                    break;
                }
            }
            System.out.println("-------------------------------");
    }


}
