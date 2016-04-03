package com.tnz.app.implementations;
import com.tnz.app.services.FeesImpl;
import com.tnz.app.services.MealFeeImpl;
import com.tnz.app.services.ResidentFeeImpl;

/**
 * Write a description of class MealImpl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MealFee implements MealFeeImpl
{
    private float mealFee = (float) 6000.00;
    
    private static MealFee mealInstance;
    
    private MealFee(){}
    
    public static MealFee getInstance(){  
        return new MealFee();
    }
        
    @Override
    public float retrieveStudentCosts(){
        return (float) 6000.00;
    }

    @Override
    public void payStudentResidentMealFee(float amount) {
        mealFee -= amount;
    }

    @Override
    public float getStudentMealFee() {
        return mealFee;
    }
}
