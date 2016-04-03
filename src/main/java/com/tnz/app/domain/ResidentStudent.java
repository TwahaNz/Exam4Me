package com.tnz.app.domain;

import com.tnz.app.implementations.*;
import com.tnz.app.services.FeesImpl;
import com.tnz.app.services.MealFeeImpl;
import com.tnz.app.services.ResidentFeeImpl;
import com.tnz.app.services.Student;

/**
 * Write a description of class ResidentStudent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResidentStudent extends Student
{
    private final MealFeeImpl mealFee;
    private final FeesImpl tuitionFee;
    private final ResidentFeeImpl residenceFee;

    public ResidentStudent(String studentName, String studentNumber) {
        super(studentName, studentNumber);
        mealFee = MealFee.getInstance();
        tuitionFee = TuitionFee.getInstance();
        residenceFee = ResidentFee.getInstance();
    }

    @Override
    public void payStudentFee(float amountPaid, String typeOfFee) {

        if (typeOfFee.toLowerCase().equals("meal"))
            mealFee.payStudentResidentMealFee(amountPaid);
        else {
            if (typeOfFee.toLowerCase().equals("residence"))
                residenceFee.payStudentResidentFee(amountPaid);
            if (typeOfFee.toLowerCase().equals("tuition"))
                tuitionFee.payStudentFee(amountPaid);
        }
    }

    @Override
    public String displayCurrentFee() {
         return "\n Current Fee Owing: R" + (mealFee.getStudentMealFee() +
                 tuitionFee.getStudentFee() +
                 residenceFee.getStudentResidentFee()) +
                 "\n =================================================================";
    }

    @Override
    public String displayAllFees() {
        return "\n Meals Cost: R" + mealFee.retrieveStudentCosts() +
                "\n Tuition Cost: R" + tuitionFee.retrieveStudentCosts(super.getFacultyName()) +
                "\n Residence Cost: R" + residenceFee.retrieveStudentCosts() +
                "\n\n Meal Fee Owing: R" + mealFee.getStudentMealFee() +
                "\n Residence Fee Owing: R" + residenceFee.getStudentResidentFee() +
                "\n Tuition Fee Owing: R" + tuitionFee.getStudentFee() +
                "\n\n Total Owing: R" + (tuitionFee.getStudentFee() + mealFee.getStudentMealFee() + residenceFee.getStudentResidentFee()) +
                "\n ====================================================================";
    }

    @Override
    public float getTotalFees() {
        return tuitionFee.getStudentFee() + residenceFee.getStudentResidentFee() + mealFee.getStudentMealFee();
    }
}
