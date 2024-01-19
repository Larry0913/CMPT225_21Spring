package com.company;

import java.util.Arrays;

public class Library {
    private Book[] lib;
    private int check_out_count;
    private int book_count;

    public Library(int size) {
        lib = new Book[size];
        check_out_count = 0;
    }

    //Operation efficiency is O(1)
    public Book checkOut(int Id) {
        if(Id>lib.length||Id<0)
            System.out.println("ID ERROR, Please choose the correct id.");
        if (lib == null)
            return null;
        if (lib[Id].isCheck()==false)
            return null;
        lib[Id].setCheck(false);
        check_out_count++;
        return lib[Id];
    }

    //Operation efficiency is O(1)
    public void addBook(Book book) {
        if(book.getID()<0|| book.getID()>lib.length)
            System.out.println("ID ERROR, Please choose the correct id.");
        book.setCheck(true);
        lib[book.getID()] = book;
        book_count++;
    }

    //Operation efficiency is O(1)
    public void removeBook(int id) {
        if(id<0||id>lib.length)
            return;
        lib[id] = null;
        if(lib[id].isCheck())
            check_out_count--;
        book_count--;
    }

    //Operation efficiency is O(1)
    public void swapBook(Book newBook, int id) {
        lib[id] = newBook;
    }

    //Operation efficiency is O(1)
    public void returnBook(int id) {
        lib[id].setCheck(true);
        check_out_count--;
    }

    //Operation efficiency is O(1)
    public String getName(int id) {
        return lib[id].getBookName();
    }

    //Operation efficiency is O(1)
    public String getAuthorName(int id) {
        return lib[id].getAuthorName();
    }

    //Operation efficiency is O(1)
    public int booksTotal() {
        return book_count;
    }

    //Operation efficiency is O(1)
    public int bookHasLentOut() {
        return check_out_count;
    }

    //Operation efficiency is O(1)
    public int bookCurrentIn() {
        return book_count - check_out_count;
    }

    public void print2()
    {
        for(int i = 0;i<booksTotal();i++)
        {
            if(lib[i].isCheck()==true)
                lib[i].print();
        }
    }

}


class Book {
    private String name;
    private int ID;
    private String authorName;
    private boolean check;

    public Book(String name, int ID, String authorName, boolean check) {
        this.name = name;
        this.ID = ID;
        this.authorName = authorName;
        this.check = check;
    }

    public String getBookName() {
        return name;
    }

    public void setBookName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isCheck() {
        return check;
    }

    public void print()
    {
        System.out.println("Book name: " + name + " " + "authorName: " + authorName + " " + "ID: " + ID);
    }

}