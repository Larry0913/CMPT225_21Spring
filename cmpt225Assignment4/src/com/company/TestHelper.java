package com.company;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {
    //first choice
    List<String> nameAndBirthKey(List<StudentEntry> students) {
        List<String> key = new ArrayList<>();
        for (StudentEntry student : students) {
            String tempKey = student.firstName + student.lastName + student.birthYear;
            key.add(tempKey);
        }
        return key;
    }

    //second choice
    List<String> birthYearAndMajorKey(List<StudentEntry> students) {
        List<String> key = new ArrayList<>();
        for (StudentEntry student : students) {
            String tempKey = student.birthYear + student.major;
            key.add(tempKey);
        }
        return key;
    }

    //third choice
    List<String> MajorKey(List<StudentEntry> students) {
        List<String> key = new ArrayList<>();
        for (StudentEntry student : students) {
            String tempKey = student.major ;
            key.add(tempKey);
        }
        return key;
    }

    //forth choice
     List<String> contactInfoKey(List<StudentEntry> students) {
        List<String> key = new ArrayList<>();
        for (StudentEntry student : students) {
            String tempKey = student.personalInfo.phoneNumber + student.personalInfo.email;
            key.add(tempKey);
        }
        return key;
    }

    void testResultPrint(MyHashTable table) {
        System.out.println("The number of collision Time is: "+ table.getNumberOfCollisions());
        System.out.println("The number of expand time is: "+ table.getExpandTimes());
        System.out.println("The number bucket length is: "+ table.getBucketsLength());
        System.out.println("The number student occupied in buckets is: "+ table.getSize());
        System.out.println("The number of entries in use in bucket is: "+ table.getEntryInUse());
        System.out.println("The number of free entry in bucket is: "+ table.getEmptyBucket()+"\n");
    }

    public MyHashTable  createTable(List<String> keys, List<StudentEntry> students) {
        MyHashTable hashTable = new MyHashTable();
        for (int i = 0; i < keys.size(); i++) {
            hashTable.add(keys.get(i), students.get(i));
        }
        return hashTable;
    }

    public void print(List<StudentEntry> students){
        for(int i = 0;i<students.size();i++) {
            StudentEntry tempStudent = students.get(i);
            int number = i+1;
            System.out.println("student " + number +" name is : " + tempStudent.firstName +" "+ tempStudent.lastName + ", the major is : "+
                    tempStudent.major + ", the birth year is : "+tempStudent.birthYear + ", the phone number is : "+
                    tempStudent.personalInfo.phoneNumber + ", and email is : " + tempStudent.personalInfo.email + ".");
        }
    }




}
