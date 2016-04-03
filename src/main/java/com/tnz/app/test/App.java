package com.tnz.app.test;

import com.tnz.app.domain.Faculty;
import com.tnz.app.domain.Lecturer;
import com.tnz.app.domain.NonResidentStudent;
import com.tnz.app.domain.ResidentStudent;
import com.tnz.app.services.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Student student1 = new NonResidentStudent("Twaha", "214308189").assignFaculty("Information Technology", "Cape Town").assignStudentFee("Chemistry");
        Student resStudent = new ResidentStudent("John", "214345896").assignFaculty("Chemistry","Bellville").assignStudentFee("Chemistry");
        Student student2 = new NonResidentStudent("Peter", "21431254").assignFaculty("Accounting", "Wellington").assignStudentFee("Accounting");
        
    }
}
