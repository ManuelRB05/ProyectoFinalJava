public class TeacherPartTime extends Teacher{
    private Integer activeHoursWeek;

    public TeacherPartTime(String name, Double baseSalary, Integer activeHoursWeek){
        super(name, baseSalary);
        this.activeHoursWeek = activeHoursWeek;
    }

    @Override
    public Double calculateSalary(){
        return baseSalary * activeHoursWeek;
    }
    public Integer getActiveHoursWeek(){
        return activeHoursWeek;
    }
}
