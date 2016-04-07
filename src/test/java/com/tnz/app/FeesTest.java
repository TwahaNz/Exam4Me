package com.tnz.app;

import com.tnz.app.domain.NonResidentStudent;
import com.tnz.app.services.Student;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Admin on 2016/04/03.
 */
public class FeesTest {

    private Student student;

    @Test
    public void payStudentTuitionTest(){

        student = new NonResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        float total = student.getTotalFees();

        student.payStudentFee(10000, "Tuition");

        Assert.assertNotEquals(student.getTotalFees(), total, 0);
    }

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
