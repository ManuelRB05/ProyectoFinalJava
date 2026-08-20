public abstract class Teacher {
    String name;
    Double salary;
    Boolean isFullTime;

    public Teacher(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }

    abstract void FullTimeTeacher();

    abstract void MidTimeTeacher();
}
