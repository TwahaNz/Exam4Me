package com.tnz.app.services;


/**
 * Write a description of interface Fees here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface FeesImpl
{
     public float retrieveStudentCosts(String course);
     public void payStudentFee(float amount);
     public float getStudentFee();
}
