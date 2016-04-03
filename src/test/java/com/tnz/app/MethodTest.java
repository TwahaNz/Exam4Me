package com.tnz.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tnz.app.domain.NonResidentStudent;
import com.tnz.app.services.Student;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Admin on 2016/04/03.
 */
public class MethodTest{

    @Test
    public void testOutstandingFees(){

        Student student = new NonResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        int examTerm = 4;

        student.writeExam(examTerm);
        student.fetchResults(4);
        student.viewResults();

    }

    @Test
    public void testPayOutstandingFees(){

        Student student = new NonResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        float total = student.getTotalFees();

        student.payStudentFee(total, "tuition");

        int examTerm = 4;

        student.writeExam(examTerm);
        student.fetchResults(examTerm);
        student.viewResults();

        System.out.println(student.displayCurrentFee());

        Assert.assertEquals(student.getTotalFees(), 0, 0);

    }
}
