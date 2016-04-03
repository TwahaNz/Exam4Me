package com.tnz.app.services;

import com.tnz.app.conf.ResultsFactory;
import com.tnz.app.domain.*;
import com.tnz.app.implementations.*;
import java.util.List;
import java.util.Random;


public abstract class Student
{
    private Faculty studentFaculty;
    private int[] retrievedResults;
    
    private final String studentName;
    private final String studentNumber;
    
    private float studentCurrentFee;
    private Exam exam = Exam.getInstance();
    private RetrievedUploadedResults retrievedUploadedResults = RetrievedUploadedResults.getInstance();
    
    public Student(String studentName, String studentNumber){
        this.studentName = studentName;
        this.studentNumber = studentNumber;
    }
    public Student assignFaculty(String facultyName, String facultyLocation){
        studentFaculty = new Faculty.Builder(facultyName, facultyLocation).build();
        return this;
    }
    public Student assignStudentFee(String course){
        studentCurrentFee = TuitionFee.getInstance().retrieveStudentCosts(course);
        return this;
    }
    public String displayStudentDetails(){
        return "\n Student Name: " + studentName +
                "\n Student Number: " + studentNumber +
                "\n Course: " + studentFaculty.getFacultyName() +
                "\n Campus Location: " + studentFaculty.getFacultyLocation();
    }

    public String fetchResults(int term){

        retrievedResults = retrievedUploadedResults.fecthUploadedResults(studentNumber, term);

        String marks = "";

        for (int i : retrievedResults)
            marks += "\nSubject: " + i;

        return marks;
    }
    public void printResults(){
        new ResultsPrint().displayResults(retrievedResults);
    }
    public void viewResults(){

        System.out.println("\n Student Name: " + studentName +
                          "\n Student Number: " + studentNumber +
                          "\n ================================");

        new ResultsView().displayResults(retrievedResults);
    }

    public abstract void payStudentFee(float amountPaid, String typeOfFee);
    public abstract String displayCurrentFee();
    public abstract String displayAllFees();
    public abstract float getTotalFees();

    public void writeExam(int term) throws IndexOutOfBoundsException{

        if (term > 4 || term < 1)
                throw new IndexOutOfBoundsException();

        exam.writeExam(Integer.parseInt(studentNumber), term);
    }

    public Integer getStudentNumber() {
        return Integer.parseInt(studentNumber);
    }
    public String getFacultyName(){
        return studentFaculty.getFacultyName();
    }
    public String getFacultyLocation(){
        return studentFaculty.getFacultyLocation();
    }

}
