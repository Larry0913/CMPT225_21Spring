package com.company;

public class Main {

    public static void main(String[] args) {
        testQ1();
        testQ2();
        testQ3();
        testQ4();
        System.out.println();
        System.out.println("Thank you  for check my cmpt225 assignment2");
    }
    public static void testQ1() {
        Library lib = new Library(10);
        System.out.println("Test Q1");
        System.out.println("Creating some new books...");
        System.out.println();
        Book book1 = new Book("a", 0,"Jack",false);
        Book book2 = new Book("b", 1,"Amy",false);
        Book book3 = new Book("c", 2,"Larry",false);
        Book book4 = new Book("d", 3,"Billy",false);
        Book book5 = new Book("e", 4,"Ryan",false);

        System.out.println("Adding books into the library... ");
        System.out.println();

        lib.addBook(book1);
        book1.print();
        lib.addBook(book2);
        book2.print();
        lib.addBook(book3);
        book3.print();
        lib.addBook(book4);
        book4.print();
        lib.addBook(book5);
        book5.print();
        int size = lib.booksTotal();

        System.out.println();
        System.out.println("Now there are " + size + " books existed in the library.");
        System.out.println();
        System.out.println("Testing the library systems,if somebody borrow books from library...");
        System.out.println();
        lib.checkOut(0);
        lib.checkOut(3);
        System.out.println("The library is checking out "+ lib.bookHasLentOut()+" books...");
        System.out.println();
        lib.print2();

        System.out.println("Then we return a book back to the library...");
        lib.returnBook(3);
        System.out.println();
        lib.print2();

        System.out.println();
        System.out.println("If we swap a new book to replace an old one");
        System.out.println();

        Book book6 = new Book("f",5,"Eric",false);
        lib.addBook(book6);
        lib.swapBook(book6,3);
        lib.print2();
        int bookCurr = lib.bookCurrentIn();
        System.out.println();
        System.out.println("So now there are " + bookCurr + " books in the library.");
    }


    public static void testQ2() {
        System.out.println();
        System.out.println("Test Q2");
        //Creating a queue
        MyQueue myQueue = new MyQueue();
        //Adding some data into the queue
        System.out.println("Test the queue consist of two stacks...");
        System.out.println();
        System.out.println("Adding some data into the queue...");
        myQueue.enqueue("a");
        myQueue.enqueue("1");
        myQueue.enqueue("b");
        myQueue.enqueue("2");
        myQueue.enqueue("c");
        myQueue.enqueue("3");
        myQueue.enqueue("d");
        myQueue.print();
        System.out.println();
        System.out.println("Now there are " + myQueue.size() + " elements in the queue..." );
        System.out.println();
        System.out.println("Test for dequeue...");
        System.out.println();
        System.out.println("The first element of the queue is "+myQueue.dequeue()+"...");
        System.out.println();
        System.out.println("The rest of the queue is : ");
        myQueue.print();
        System.out.println();
        System.out.println("After that, there are " + myQueue.size() + " elements in the queue...");
        System.out.println();
        System.out.println("The first element of the queue is "+myQueue.front()+" ...");
        System.out.println();
    }

    public static void testQ3() {
        System.out.println("Test Q3");
        System.out.println("Creating a list for testing reverse recursive and iterative... ");
        ReverseList reverseList = new ReverseList();
        reverseList.add("a");
        reverseList.add("b");
        reverseList.add("c");
        reverseList.add("d");
        reverseList.add("e");
        System.out.print("The list is : ");
        reverseList.printList();
        System.out.println();
        System.out.print("Test for reverse recursively, the new list is : ");
        reverseList.reverseRecursive();
        reverseList.printList();
        System.out.println();
        System.out.print("Test for reverse iteratively, the new list is : ");
        reverseList.reverseIterative();
        reverseList.printList();
        System.out.println();
    }

    public static void testQ4() {
        System.out.println("Test Q4");
        System.out.println("Creating a restaurant system...");
        Restaurant R = new Restaurant();
        System.out.println("Add 2 elements front of the list...");
        R.addFront(2);
        R.addFront(3);
        System.out.println(R);
        System.out.println("Add 1 elements at last of the list...");
        R.addLast(6);
        System.out.println(R);
        System.out.println("Add 1 elements front of the list...");
        R.addFront(8);
        System.out.println(R);
        System.out.println("Remove the first element form the list...");
        R.dequeue();
        System.out.println(R);
        System.out.println("Add 1 element front of the list...");
        R.addFront(10);
        System.out.println(R);
        System.out.println("Add 2 elements at last of the list...");
        R.addLast(5);
        R.addLast(1);
        System.out.println(R);
        System.out.println("Remove the first element form the list...");
        R.dequeue();
        System.out.println(R);
    }
}
