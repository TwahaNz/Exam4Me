package com.tnz.app.services;

/**
 * Created by Admin on 2016/04/03.
 */
public interface MealFeeImpl {
    public float retrieveStudentCosts();
    public void payStudentResidentMealFee(float amount);
    public float getStudentMealFee();
}
