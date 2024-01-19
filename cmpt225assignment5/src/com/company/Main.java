package com.company;

import java.util.Random;

public class Main {

    static void print1(){
        System.out.println("     30");
        System.out.println("    /  \\");
        System.out.println("  20    40");
        System.out.println("  / \\   /");
        System.out.println("10   25 32");
        System.out.println("          \\");
        System.out.println("           35");
        System.out.println("            \\");
        System.out.println("             38");
    }

    static void print2() {
        System.out.println("     30");
        System.out.println("    /  \\");
        System.out.println("  20    40");
        System.out.println("  / \\   /");
        System.out.println("10   25 32");
        System.out.println("      \\   \\");
        System.out.println("      28   35");
        System.out.println("             \\");
        System.out.println("              38");
    }

    static void print3(){
        System.out.println("     30");
        System.out.println("    /  \\");
        System.out.println("  20    40");
        System.out.println("  / \\   /");
        System.out.println("10  25 32");
        System.out.println("      \\   \\");
        System.out.println("       28  35");
    }

    static void print4(){
        System.out.println("     32");
        System.out.println("    /  \\");
        System.out.println("  20    40");
        System.out.println("  / \\   /");
        System.out.println("10  25  35");
        System.out.println("      \\");
        System.out.println("       28");

    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("Now test for Binary Search Tree...");
        BST<Integer> bstTest = new BST<>();
        bstTest.insert(new Entry<>(30, 3));
        bstTest.insert(new Entry<>(20, 8));
        bstTest.insert(new Entry<>(10, 19));
        bstTest.insert(new Entry<>(25, 46));
        bstTest.insert(new Entry<>(40, 8));
        bstTest.insert(new Entry<>(32, 21));
        bstTest.insert(new Entry<>(35, 73));
        bstTest.insert(new Entry<>(38, 50));
        System.out.println("The Binary Search Tree is : ");
        print1();
        System.out.println();
        System.out.println("Print it out by rank: ");
        bstTest.print();
        System.out.println();
        System.out.println("The mean of the BST is " + bstTest.mean());
        System.out.println("The median of the BST is " + bstTest.median());
        System.out.println();
        System.out.println("---------------------------------");

        System.out.println("Insert 28 to the tree... ");
        bstTest.insert(new Entry<>(28,0));
        System.out.println("The Binary Search Tree is : ");
        print2();
        System.out.println();
        System.out.println("Print it out by rank: ");
        bstTest.print();
        System.out.println();
        System.out.println("The mean of the BST is " + bstTest.mean());
        System.out.println("The median of the BST is " + bstTest.median());
        System.out.println();
        System.out.println("---------------------------------");

        System.out.println("Remove 38 from the tree (no child)");
        bstTest.remove(new Entry<>(38, 50));
        System.out.println("The Binary Search Tree is : ");
        print3();
        System.out.println();
        System.out.println("Print it out by rank: ");
        bstTest.print();
        System.out.println();
        System.out.println("The mean of the BST is " + bstTest.mean());
        System.out.println("The median of the BST is " + bstTest.median());
        System.out.println();
        System.out.println("---------------------------------");

        System.out.println("Remove 30 from the tree (root remove)");
        bstTest.remove(new Entry<>(30, 3));
        System.out.println("The Binary Search Tree is : ");
        print4();
        System.out.println();
        System.out.println("Print it out by rank: ");
        bstTest.print();
        System.out.println();
        System.out.println("The mean of the BST is " + bstTest.mean());
        System.out.println("The median of the BST is " + bstTest.median());
        System.out.println("\nSearching key 40 in the rest tree : ");
        System.out.println("Entry 40 found in tree : " + bstTest.search (40));
        System.out.println("\nSearching key 15 in the rest tree : ");
        System.out.println("Entry 15 found in tree : " + bstTest.search (15));

        System.out.println("-------------------------------------------------");

        System.out.println("Now test for merge sort and quick sort...");
        System.out.println();
        SortSystem sort = new SortSystem();
        Random randNum = new Random();
        int[] arr1 = new int[32];
        System.out.println("Create an 32-bit sequence of zeroes and ones array and print before merge sort:");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = randNum.nextInt(2);
            System.out.print(arr1[i]);
        }
        System.out.print("\nAfter sort:\n");
        sort.mergeSort(arr1,0, arr1.length - 1);
        for (int j = 0; j < arr1.length; j++) {
            System.out.print(arr1[j]);
        }
        System.out.println("\nThe comparison times by merge sort is: " + sort.getMerge_times());
        System.out.println();

        int[] arr2 = new int[32];
        System.out.println("Create an 32-bit sequence of zeroes and ones array and print before quick sort:");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = randNum.nextInt(2);
            System.out.print(arr2[i]);
        }
        System.out.print("\nAfter sort:\n");
        sort.quickSort(arr2);
        for (int j = 0; j < arr1.length; j++) {
            System.out.print(arr2[j]);
        }
        System.out.println("\nThe comparison times by quick sort is: " +  sort.getQuick_times());

        System.out.println("----------------------------------");
        int [][] matrix1 = new int[100][32];
        double totalTimes1 = 0;
        Random rand = new Random();
        System.out.println("\nTest 100 randomly-generated sequences by merge sort...");
        for (int i = 0; i < matrix1.length; i ++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = rand.nextInt(2);
            }
            sort.mergeSort(matrix1[i]);
            totalTimes1 += sort.getMerge_times();
        }
        double averageTime1 = totalTimes1 / matrix1.length;
        System.out.println("The average comparison times by merge sort is: " + averageTime1);

        int [][] matrix2 = new int[100][32];
        double totalTimes2 = 0;

        System.out.println("\nTest 100 randomly-generated sequences by quick sort...");
        for (int i = 0; i < matrix2.length; i ++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = rand.nextInt(2);
            }
            sort.quickSort(matrix2[i]);
            totalTimes2 += sort.getQuick_times();
        }
        double averageTimes2 =  totalTimes2 / matrix2.length;
        System.out.println("The average comparison times by quick sort is: " + averageTimes2);
        System.out.println("------------------------------------------------");
        System.out.println("Thank you for checking my cmpt225 assignment5...");
    }
}
