package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Test for My hash table by using different hash code...\n");
        System.out.println("Now create some students...\n");
        StudentEntry s1 = new StudentEntry("John",
                "Smith",
                "Computer Science",
                1988,
                new ContactInfo(5555555,"jsmith@email.com"));

        StudentEntry s2 = new StudentEntry("Howard",
                "Calico",
                "Chemical Engineering",
                1991,
                new ContactInfo( 8675309,"hcalico@email.com"));

        StudentEntry s3 = new StudentEntry("Yarah",
                "Bahri",
                "Psychology",
                1976,
                new ContactInfo(6647665,"ybahri3@email.com"));

        StudentEntry s4 = new StudentEntry("Aveline",
                "Macon",
                "Arts",
                1991,
                new ContactInfo(7181234,"its_aveline@avelineworld.com"));

        StudentEntry s5 = new StudentEntry("Pratik",
                " Gera",
                "Psychology",
                1996,
                new ContactInfo(3232368,"pgera@email.com"));

        StudentEntry s6 = new StudentEntry("Usui",
                "Aimi",
                "Psychology",
                1996,
                new ContactInfo(4623457,"x_shadow_hunter_x03@gaming.com"));

        StudentEntry s7 = new StudentEntry("Jane",
                "Smith",
                "Computer Science",
                1990,
                new ContactInfo(5555555,"j2smith@email.com"));

        StudentEntry s8 = new StudentEntry("Vreni",
                "Spitz",
                "Law",
                1992,
                new ContactInfo(5554444,"vspitz@email.com"));


        StudentEntry s9 = new StudentEntry("Pratik",
                "Comar",
                "Business",
                1991,
                new ContactInfo(6645622,"pcomar@email.com"));

        StudentEntry s10 = new StudentEntry("Padma",
                "Gera",
                "Arts",
                1994,
                new ContactInfo(5554544,"pgera@realemail.org"));

        StudentEntry s11 = new StudentEntry("Theresa",
                "Chavez",
                "Arts",
                1970,
                new ContactInfo(3136544,"f8wq8xj7976@payspun.com"));

        StudentEntry s12 = new StudentEntry("Debra",
                "Strauss",
                "Business",
                1990,
                new ContactInfo(50937814,"km9fbdivx8a@claimab.com"));

        StudentEntry s13 = new StudentEntry("Lance",
                "Hernandez",
                "Computer Science",
                1997,
                new ContactInfo(95484366,"u0gmmw9hzl@lidhieeddxian.net"));

        StudentEntry s14 = new StudentEntry("Hector",
                "Lewis",
                "Psychology",
                1984,
                new ContactInfo(30476389,"mmszpka34a@claimab.com"));

        StudentEntry s15 = new StudentEntry("Corinne",
                "Baker",
                "Arts",
                1999,
                new ContactInfo(77294023,"hwmy3tcny4q@lnsfvuxiang.net"));

        StudentEntry s16 = new StudentEntry("Sean",
                "Corliss",
                "Business",
                1974,
                new ContactInfo(67789002,"p2s23g8omr@nshdsiang.net"));

        StudentEntry s17 = new StudentEntry("Helen",
                "Pickett",
                "Psychology",
                1983,
                new ContactInfo(21675548,"asrz99px7id@thrubay.com"));

        StudentEntry s18 = new StudentEntry("Penny",
                "Cervantes",
                "Arts",
                1983,
                new ContactInfo(91829409,"3k2uro34gaa@claimab.com"));

        StudentEntry s19 = new StudentEntry("Ryan",
                "Alice",
                "Law",
                1990,
                new ContactInfo(23676544,"dadkf@rfkemail.ca"));

        StudentEntry s20 = new StudentEntry("Bily",
                "Hong",
                "Computer Science",
                1978,
                new ContactInfo(23345783,"Billytyui@email.org"));

        TestHelper testHashtable = new TestHelper();
        List<StudentEntry> studentsList = new ArrayList<>();
        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);
        studentsList.add(s4);
        studentsList.add(s5);
        studentsList.add(s6);
        studentsList.add(s7);
        studentsList.add(s8);
        studentsList.add(s9);
        studentsList.add(s10);
        studentsList.add(s11);
        studentsList.add(s12);
        studentsList.add(s13);
        studentsList.add(s14);
        studentsList.add(s15);
        studentsList.add(s16);
        studentsList.add(s17);
        studentsList.add(s18);
        studentsList.add(s19);
        studentsList.add(s20);


        testHashtable.print(studentsList);
        System.out.println();

        System.out.println("Test first hash code option...");
        System.out.println("Printing hashmap using first name, last name and birth year as key\n");
        List<String> keys1 = testHashtable.nameAndBirthKey(studentsList);
        MyHashTable hashTable1 = testHashtable.createTable(keys1, studentsList);
        testHashtable.testResultPrint(hashTable1);

        System.out.println("Test second hash code option...");
        System.out.println("Printing hashmap using birth year and major as key\n");
        List<String> keys2 = testHashtable.birthYearAndMajorKey(studentsList);
        MyHashTable hashTable2 = testHashtable.createTable(keys2, studentsList);
        testHashtable.testResultPrint(hashTable2);

        System.out.println("Test third hash code option...");
        System.out.println("Printing hashmap using only major as key\n");
        List<String> keys3 = testHashtable.MajorKey(studentsList);
        MyHashTable hashTable3 = testHashtable.createTable(keys3, studentsList);
        testHashtable.testResultPrint(hashTable3);

        System.out.println("Test forth hash code option...");
        System.out.println("Printing hashmap using contact information as key\n");
        List<String> keys4 = testHashtable.contactInfoKey(studentsList);
        MyHashTable hashTable4 = testHashtable.createTable(keys4, studentsList);
        testHashtable.testResultPrint(hashTable4);

        System.out.println("Thank you for checking my cmpt225 assignment4...");


    }
}
