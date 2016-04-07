package com.tnz.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tnz.app.domain.Lecturer;
import com.tnz.app.domain.NonResidentStudent;
import com.tnz.app.domain.RetrievedUploadedResults;
import com.tnz.app.implementations.ResidentFee;
import com.tnz.app.services.Student;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Admin on 2016/04/03.
 */
public class MethodTest{

    @Test
    public void  testLecturerInfoUpdate(){

        Lecturer lecturer1 = new Lecturer.Builder().assignName("Mr. Peter")
                .assignFaculty("Information Technology", "Cape Town")
                .assignRoomNumber("Room 2.25")
                .assignStaffID("123").build();

        Assert.assertEquals(lecturer1.getName(), "Mr. Peter");
        Assert.assertEquals(lecturer1.getRoomNumber(), "Room 2.25");
        Assert.assertEquals(lecturer1.getStaffID(), "123");

        System.out.println("\n Lecture Current Room: " + lecturer1.getRoomNumber());

        lecturer1 = new Lecturer.Builder().copyLecturer(lecturer1).assignRoomNumber("Room 2.11").build();

        Assert.assertEquals(lecturer1.getRoomNumber(), "Room 2.11");

        System.out.println("\n Lecture Has Move To Room: " + lecturer1.getRoomNumber());
    }
}
