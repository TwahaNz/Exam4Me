package com.tnz.app.domain;

import java.util.List;


/**
 * Abstract class Results - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Results
{
    Results nextTermResults;

    public void assignNextTermResults(Results nextTerm){
        this.nextTermResults = nextTerm;
    }
    
    public abstract int[] handleNextTermRequest(String studentNumber, int termRequest);

}