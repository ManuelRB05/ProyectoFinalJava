package model;

import java.util.ArrayList;

public class Classes {
    private String name;
    private Integer classroom;
    private Teacher teacher;
    private ArrayList<Student> studentsList= new ArrayList<>();

    public Classes(String name, Integer classroom, Teacher teacher){
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
    }

    public void addStudent(Student student){
        studentsList.add(student);
    }

    public String getName(){
        return this.name;
    }

    public Integer getClassroom(){
        return this.classroom;
    }

    public Teacher getTeacher(){
        return this.teacher;
    }

    public ArrayList<Student> getStudents(){
        return this.studentsList;
    }
}
