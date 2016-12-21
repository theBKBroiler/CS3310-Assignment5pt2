package edu.wmich.cs3310.KennethRivard;

/**
 * Created by Kenneth Rivard on 11/24/16.
 */

public class MyData<T extends Comparable> {


    String studentName;
    int courseNumber;
    char grade;

    public MyData(String studentName, int courseNumber, char grade) {
        String s = studentName;
        int cn = courseNumber;
        char g = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

}//end class MyData
