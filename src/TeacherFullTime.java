public class TeacherFullTime extends Teacher{
    private Integer experienceYears;

    public TeacherFullTime(String name, Double baseSalary, Integer experienceYears){
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    @Override
    public Double calculateSalary(){
        return baseSalary * (1.10 + experienceYears);
    }
    public Integer getExperienceYears(){
        return experienceYears;
    }
}
