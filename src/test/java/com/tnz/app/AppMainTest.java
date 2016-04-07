package com.tnz.app;

import com.tnz.app.conf.ResultsFactory;
import com.tnz.app.domain.*;
import com.tnz.app.services.Student;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 4/7/16.
 */
public class AppMainTest {

    private Faculty informaticsAndDesign;
    private Lecturer tp3Lecturer;
    private Student itStudent;
    private Student accStudent2;

    @Test
    public void testObjectCreation(){

        Exam examPaper = Exam.getInstance();

        informaticsAndDesign = new Faculty.Builder()
                                       .assignFacultyLocation("Cape Town")
                                       .assignFacultyName("Information Technology")
                                       .build();

        tp3Lecturer = new Lecturer.Builder()
                                .assignName("Tabaso")
                                .assignFaculty("Information Technology","Cape Town")
                                .assignStaffID("2547")
                                .assignRoomNumber("2.58")
                                .build();


        itStudent = new NonResidentStudent("Twaha", "214308189")
                .assignFaculty("Information Technology", "Cape Town")
                .assignStudentFee("Information Technology");

        accStudent2 = new ResidentStudent("James", "21569781")
                .assignFaculty("Accounting", "Cape Town")
                .assignStudentFee("Accounting");

        itStudent.writeExam(1);
        itStudent.fetchResults(1);

        int[] marks = ResultsFactory.getStudentTermResults("" + itStudent.getStudentNumber(), 1);

        System.out.println(itStudent.displayStudentDetails() + "\n" + itStudent.displayAllFees());
        System.out.println(accStudent2.displayStudentDetails() + "\n" + accStudent2.displayAllFees());
        itStudent.viewResults();

        Assert.assertSame("Tabaso", tp3Lecturer.getName());
        Assert.assertEquals("Information Technology", informaticsAndDesign.getFacultyName());

    }

    @Test
    public void testUpdatingOfObjects(){

        informaticsAndDesign = new Faculty.Builder()
                .assignFacultyLocation("Cape Town")
                .assignFacultyName("Information Technology")
                .build();

        informaticsAndDesign = new Faculty.Builder()
                               .copyFaculty(informaticsAndDesign)
                               .assignFacultyName("Information Tech")
                               .build();

        Assert.assertEquals("Information Tech", informaticsAndDesign.getFacultyName());
    }
}
