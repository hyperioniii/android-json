package com.emildesign.jsonparsingapp;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Student 
{
	
//	@SerializedName(JSONParsingClass.STUDENT_ID)
	private String Student_Id;
	
	@SerializedName(JSONParsingClass.STUDENT_NAME)
    private String studentName;
	
	@SerializedName(JSONParsingClass.STUDENT_AGE)
    private int studentAge;
	
	@SerializedName(JSONParsingClass.STUDENT_GRADE_LIST)
    private List<Grade> studentGrades;
     
	public Student() {
		super();
		this.studentGrades = new ArrayList<Grade>();
	}
	
	
public String getStudentId() {
		return Student_Id;
	}


	public void setStudentId(String studentId) {
		this.Student_Id = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public int getStudentAge() {
		return studentAge;
	}


	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}


	public List<Grade> getStudentGrades() {
		return studentGrades;
	}


	public void setStudentGrades(List<Grade> studentGrades) {
		this.studentGrades = studentGrades;
	}


	
	public void addGradeToGradesList(Grade grade)
	{
		this.studentGrades.add(grade);
	}
	@Override
	public String toString() {
		return "Student [ \nstudentId=" + Student_Id + ", studentName="
				+ studentName + ", studentAge=" + studentAge
				+ ", studentGrades=" + 
				studentGrades + 
				"] \n";
	}	
}
