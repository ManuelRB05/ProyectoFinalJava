package model;

public class Student {
    private static Integer idCounter = 0;
    private Integer id;
    private String name;
    private Integer age;

    public Student(String name, Integer age){
        idCounter += 1;
        this.id = idCounter;
        this.name = name;
        this.age = age;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return this.name;
    }
    public Integer getAge(){
        return this.age;
    }
}
