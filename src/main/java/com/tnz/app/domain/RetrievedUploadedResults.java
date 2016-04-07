package com.tnz.app.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tnz.app.conf.ResultsFactory;
import com.tnz.app.services.Student;


/**
 * Write a description of class UploadedResults here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class RetrievedUploadedResults
{
    private static RetrievedUploadedResults retrievedUploadedResults;

    private RetrievedUploadedResults(){}

    public static RetrievedUploadedResults getInstance() {
        if (retrievedUploadedResults == null)
            return new RetrievedUploadedResults();
        return retrievedUploadedResults;
    }

    public int[] fecthUploadedResults(String studentNumber, int term){
        return ResultsFactory.getStudentTermResults(studentNumber,term);
    }
}
