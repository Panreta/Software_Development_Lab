package P3;

public class Student {
    private String name;
    private String major;
    private double gpa;
    private int graduationYear;

    public Student(String name, String major, double gpa, int graduationYear)
    {
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        this.graduationYear = graduationYear;
    }

    // Getters
    public String getName() { return name; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    public int getGraduationYear() { return graduationYear; }
}