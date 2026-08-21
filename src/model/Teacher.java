package model;

public abstract class Teacher {
    protected String name;
    protected Double baseSalary;

    public Teacher(String name, Double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract Double calculateSalary();

    public String getName(){
        return name;
    }

    public Double getBaseSalary(){
        return baseSalary;
    }
}
