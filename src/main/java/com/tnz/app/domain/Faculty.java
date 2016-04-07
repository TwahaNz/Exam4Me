package com.tnz.app.domain;

public class Faculty
{
    private String facultyName;
    private String facultyLocation;
    
    private Faculty(){}
    
    public Faculty(Builder builder){
        this.facultyName = builder.facultyName;
        this.facultyLocation = builder.facultyLocation;
    }

    public String getFacultyName(){
        return this.facultyName;
    }
        
    public String getFacultyLocation(){
        return this.facultyLocation;
    }
    
    public static class Builder
    {
            private String facultyName;
            private String facultyLocation;

            public Builder assignFacultyName(String facultyName) {
                this.facultyName = facultyName;
                return this;
            }

            public Builder assignFacultyLocation(String facultyLocation) {
                this.facultyLocation = facultyLocation;
                return this;
            }

            public Faculty build(){
                return new Faculty(this);
            }

            public Builder copyFaculty(Faculty toBeCopiedFaculty){
                this.facultyName = toBeCopiedFaculty.facultyName;
                this.facultyLocation = toBeCopiedFaculty.facultyLocation;
                return this;
            }
    }     
}
