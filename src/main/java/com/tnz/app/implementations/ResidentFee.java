package com.tnz.app.implementations;

import com.tnz.app.services.FeesImpl;
import com.tnz.app.services.ResidentFeeImpl;


/**
 * Write a description of class ResidentImpl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResidentFee implements ResidentFeeImpl
{
    private float residenceFee = (float) 12000.00;
    
    private static ResidentFee residenceInstance;
    
    private ResidentFee(){}
    
    public static ResidentFee getInstance(){  
        return new ResidentFee();
    }
    
    @Override
    public float retrieveStudentCosts(){
        return (float) 12000.00;
    }

    @Override
    public void payStudentResidentFee(float amount) {
        residenceFee -= amount;
    }

    @Override
    public float getStudentResidentFee() {
        return residenceFee;
    }
}
