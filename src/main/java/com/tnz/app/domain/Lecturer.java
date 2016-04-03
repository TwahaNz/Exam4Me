package com.tnz.app.domain;

import java.util.List;
import java.util.Map;

import com.tnz.app.services.Student;
import com.tnz.app.services.UploadMarksImpl;

public class Lecturer implements UploadMarksImpl
{
    private Faculty lectureFaculty;
    private Map<Integer, Student> students;
    private String name;
    private String roomNumber;
    private String staffID;
    
    private Lecturer(){}

    public Lecturer(Builder builder){
        this.name = builder.name;
        this.roomNumber = builder.roomNumber;
        this.staffID = builder.staffID;
        this.lectureFaculty = builder.lectureFaculty;
    }
    
    public void assignStudentMarks(Map<Integer, Student> studentsMarks){
        this.students = studentsMarks;
    }

    public String getName() {
        return name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getStaffID() {
        return staffID;
    }

    @Override
    public List<Map<Integer, int[]>> uploadTermMarks(int term) {
        return null;
    }

    public static class Builder
    {
        Faculty lectureFaculty;
        private String name;
        private String roomNumber;
        private String staffID;
                
        public Builder assignName(String name){
            this.name = name;
            return this;
        }
        
        public Builder assignRoomNumber(String roomNumber){
            this.roomNumber = roomNumber;
            return this;
        }
        
        public Builder assignStaffID(String staffID){
            this.staffID = staffID;
            return this;
        }
        
        public Builder assignFaculty(String facultyName, String campusLocation){
            lectureFaculty = new Faculty.Builder(facultyName, campusLocation).build();           
            return this;
        }

        public Lecturer build(){
            return new Lecturer(this);
        }
    }
}
