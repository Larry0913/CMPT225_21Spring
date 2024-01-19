package com.company;

class StudentEntry{
    String firstName;
    String lastName;
    String major;
    int birthYear;
    ContactInfo personalInfo;

    public StudentEntry(String firstNameIn, String lastNameIn, String majorIn, int birthYearIn, ContactInfo
            contactInfoIn) {
        firstName = firstNameIn;
        lastName = lastNameIn;
        major = majorIn;
        birthYear = birthYearIn;
        personalInfo = contactInfoIn;
    }
}

