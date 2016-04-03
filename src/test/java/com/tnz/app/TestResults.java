package com.tnz.app;

import com.tnz.app.domain.Lecturer;
import com.tnz.app.domain.NonResidentStudent;
import com.tnz.app.domain.ResidentStudent;
import com.tnz.app.services.Student;

import org.junit.*;
import org.junit.rules.ExpectedException;

/**
 * Created by Admin on 2016/04/03.
 */
public class TestResults {

    Student student;
    Lecturer lecturer;


    @Test
    public void  testLecturer(){

        Lecturer lecturer1 = new Lecturer.Builder().assignName("Mr. Peter")
                .assignFaculty("Information Technology", "Cape Town")
                .assignRoomNumber("Room 2.25")
                .assignStaffID("123").build();

        Assert.assertEquals(lecturer1.getName(), "Mr. Peter");
        Assert.assertEquals(lecturer1.getRoomNumber(), "Room 2.25");
        Assert.assertEquals(lecturer1.getStaffID(), "123");
    }

    @Test
    public void testNonResidentStudent(){

        student = new NonResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        Assert.assertEquals(student.getStudentNumber(), (Integer) 123);
        Assert.assertEquals(student.getFacultyLocation(), "Cape Town");
        Assert.assertEquals(student.getFacultyName(), "Information Technology");
    }

    @Test
    public void testResidentStudent(){

        student = new ResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        System.out.println(student.displayAllFees());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testTerms() {

        student = new NonResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        int examTerm = 5;

        student.writeExam(examTerm);
    }

    @Test
    public void writeExamTest(){

        student = new NonResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        int examTerm = 1;

        student.writeExam(examTerm);
        student.fetchResults(examTerm);
        student.viewResults();
    }

    @Test
    public void testPrint(){
        student = new NonResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        student.writeExam(1);
        student.writeExam(2);
        student.writeExam(3);
        student.writeExam(4);

        student.fetchResults(2);

        student.printResults();
    }

    @Test
    public void testViewResults() throws InterruptedException {

        student = new NonResidentStudent("Test", "123").
                assignFaculty("Information Technology", "Cape Town").
                assignStudentFee("Information Technology");

        student.writeExam(1);
        student.fetchResults(1);
        student.viewResults();

        Thread.sleep(2000);

        student.writeExam(2);
        student.fetchResults(2);
        student.viewResults();
    }

}
