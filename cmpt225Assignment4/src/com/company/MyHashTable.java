package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable{
    private  Entry[] buckets;

    private int numberOfCollisions;
    private int expandTimes;
    private int size;
    private int capacity;

    private static final double LOAD_FACTOR_COEFFICIENT = 0.9;

    public MyHashTable() {
        capacity = 10;
        buckets = new Entry[capacity];
        size = 0;
        numberOfCollisions = 0;
        expandTimes = 0;
    }

    //first choice hashCode()

    //second hash code choice
    private int sumOfHashCode(String key) {
        int result = 0;
        for (int i = 0; i < key.length(); ++i) {
            result += Character.getNumericValue(key.charAt(i));
        }
        return result;
    }
/*
    //third choice
    private int studentHashCode(Entry entry){
        int result = 0;
        for(int i = 0;i < entry.getStudent().firstName.length();i++) {
            result += entry.getStudent().firstName.charAt(i);
        }
        for(int i = 0;i < entry.getStudent().lastName.length();i++) {
            result += entry.getStudent().lastName.charAt(i);
        }
        return result;
    }

*/


    private int getIndex(String key, Entry[] buckets){
        if(key == null)
            return -1;
        else
            return Math.abs(key.hashCode() % buckets.length);
        //return sumOfHashCode(key) % buckets.length;
    }

    public void add(String key,StudentEntry student){
        if(key == null)
            return;
        //int hashValue = entry.hashCode();
        int index = getIndex(key,buckets);
        if(buckets[index] != null){
            numberOfCollisions++;
        }
        for (Entry entry = buckets[index]; entry != null; entry = entry.getNext()) {
            if (entry.getKey().equals(key)) {
                entry.setStudent(student);
                size++;
                return;
            }
        }
        Entry newEntry = new Entry(key, student, buckets[index]);
        buckets[index] = newEntry;
        size++;

        if((double)size / buckets.length >= LOAD_FACTOR_COEFFICIENT){
            expandSize(buckets.length * 2);
        }


        //check load factory
        /*
        if((double)size / buckets.size() >= LOAD_FACTOR_COEFFICIENT)
        {
            expandTimes++;
            ArrayList<Entry> tempBuckets = new ArrayList<>();
            for(int i = 0; i < buckets.size() * 2;i++) {
                tempBuckets.add(new ArrayList<>());
            }
            for(Entry bucket : buckets){
                for(Entry e : bucket){
                    int newHash = getIndex(e.getKey(),tempBuckets);
                    int newIndex = newHash % tempBuckets.size();
                    if(tempBuckets.get(newIndex)!=null){
                        numberOfCollisions++;
                    }
                    tempBuckets.get(newIndex).add(entry);
                }
            }
        }
        */

    }

    public StudentEntry getEntry(String key) {
        int index = getIndex(key, buckets);
        Entry tempEntry = null;
        for (Entry entry = buckets[index]; entry != null; entry = entry.getNext()) {
            if (entry.getKey().equals(entry.key)) {
                tempEntry = entry;
            }
        }

        if (tempEntry == null)
            return null;
        return tempEntry.getStudent();
    }

    public void expandSize(int capacity){
        Entry[] tempBuckets = new Entry[capacity];
        for (Entry entry : buckets) {
            Entry originalEntry = entry;
            while (originalEntry != null) {
                Entry nextEntry = originalEntry.getNext();
                int index = getIndex(originalEntry.getKey(), tempBuckets);
                originalEntry.setNextEntry(tempBuckets[index]);
                tempBuckets[index] = originalEntry;
                originalEntry = nextEntry;
            }
        }
        buckets = tempBuckets;
        expandTimes++;
    }

    public int getEntryInUse() {
        return buckets.length - getEmptyBucket();
    }

    public int getNumberOfCollisions(){
        return numberOfCollisions;
    }

    public int getExpandTimes(){return expandTimes;}

    public int numOfBucketsInUse(){
        int result = 0;
        for(Entry entry: buckets) {
            if(entry != null) {
                result++;
            }
        }
        return result;
    }

    public int getSize(){
        return size;
    }

    public int getBucketsLength(){
        return buckets.length;
    }

    public int getEmptyBucket(){
        int emptyBucket = 0;
        for (Entry entry: buckets) {
            if (entry == null) {
                emptyBucket++;
            }
        }
        return emptyBucket;
    }

    private static final class Entry {
        private final String key;
        private StudentEntry student;
        private Entry nextEntry;

        public Entry(String k, StudentEntry s, Entry n) {
            key = k;
            student = s;
            nextEntry = n;
        }

        public String getKey() {
            return key;
        }

        public StudentEntry getStudent() {
            return student;
        }

        public void setStudent(StudentEntry student) {
            this.student = student;
        }

        public void setNextEntry(Entry nextEntry) {
            this.nextEntry = nextEntry;
        }

        public Entry getNext(){
            return nextEntry;
        }


    }

}
