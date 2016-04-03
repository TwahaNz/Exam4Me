package com.tnz.app.domain;


import java.util.ArrayList;
import java.util.List;

import com.tnz.app.domain.Results;
import com.tnz.app.services.Student;


/**
 * Write a description of class ResultTerm4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultTerm4 extends Results
{
    @Override
    public int[] handleNextTermRequest(String studentNumber, int termRequest){
        if (termRequest == 4)
            return Exam.getInstance().getTermResult(studentNumber,termRequest);
        else
            if (nextTermResults != null)
                return nextTermResults.handleNextTermRequest(studentNumber,termRequest);
            else
                return null;
    }
    
}
