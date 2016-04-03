package com.tnz.app.test;

import com.tnz.app.domain.Faculty;
import com.tnz.app.domain.Lecturer;
import com.tnz.app.domain.NonResidentStudent;
import com.tnz.app.domain.ResidentStudent;
import com.tnz.app.services.Student;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Student student1 = new NonResidentStudent("Twaha", "214308189").assignFaculty("Information Technology", "Cape Town").assignStudentFee("Information Technology");
        Student resStudent1 = new ResidentStudent("John", "214345896").assignFaculty("Chemistry","Bellville").assignStudentFee("Chemistry");
        Student student2 = new NonResidentStudent("Kyle", "214314554").assignFaculty("Accounting", "Wellington").assignStudentFee("Accounting");
        Student student3 = new NonResidentStudent("Thomas", "214318189").assignFaculty("Information Technology", "Cape Town").assignStudentFee("Information Technology");
        Student resStudent2 = new ResidentStudent("Johnson", "214346896").assignFaculty("Information Technology","Bellville").assignStudentFee("Information Technology");


        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(resStudent1);
        students.add(resStudent2);


        for (Student stud : students){
            stud.payStudentFee(16000, "tuition");
            stud.payStudentFee((float)new Random().nextInt(15000), "meal");
            stud.payStudentFee((float)new Random().nextInt(10000), "residence");
        }


        for (Student stud : students){
            stud.writeExam(4);
        }

        for (Student stud : students){
            stud.fetchResults(4);
            stud.viewResults();
        }

    }
}
