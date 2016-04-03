package com.tnz.app.implementations;

import com.tnz.app.domain.RetrievedUploadedResults;
import java.util.List;
import com.tnz.app.services.ResultsImpl;


/**
 * Write a description of class View here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultsView implements ResultsImpl
{
    @Override
    public void displayResults(int[] results) {

        String marks = "";

        for (int i : results)
            marks += "\n Subject: " + i;

        System.out.print(marks + "\n");
    }
    
}
