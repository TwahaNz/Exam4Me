package com.tnz.app.domain;


import com.tnz.app.implementations.TuitionFee;
import com.tnz.app.services.FeesImpl;
import com.tnz.app.services.Student;


/**
 * Write a description of class NonResidentStudent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NonResidentStudent extends Student
{
    private FeesImpl tuitionFee;
    
    public NonResidentStudent(String studentName, String studentNumber){
        super(studentName, studentNumber);
        tuitionFee = TuitionFee.getInstance();
    }

    @Override
    public void payStudentFee(float amountPaid, String typeOfFee) {
        if (typeOfFee.toLowerCase().equals("tuition"))
            tuitionFee.payStudentFee(amountPaid);
    }

    @Override
    public String displayCurrentFee() {
        return "\n Current Fee: R" + tuitionFee.getStudentFee() +
                "\n =================================================================";
    }

    @Override
    public String displayAllFees() {
        return "\n Course Fee: R" + tuitionFee.retrieveStudentCosts(getFacultyName()) +
                "\n Current Fee Owing: R" + tuitionFee.getStudentFee() +
                "\n =================================================================";
    }

    @Override
    public float getTotalFees() {
        return tuitionFee.getStudentFee();
    }

}
