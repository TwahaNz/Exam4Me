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
            
            public Builder (String facultyName, String facultyLocation){
                this.facultyName = facultyName;
                this.facultyLocation = facultyLocation;
            }
            
            public String getFacultyName(){
                return this.facultyName;
            }
            
            public String getFacultyLocation(){
                return this.facultyLocation;
            }
            
            public Faculty build(){
                return new Faculty(this);
            }
    }     
}
