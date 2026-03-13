package P3;

import java.util.*;
import java.util.stream.Collectors;

public class StudentAnalyzer {

    /**
     * Calculates the average GPA for each major.
     * Uses functional programming with Streams to group students by major
     * and compute the average GPA for each group.
     *
     * @param students List of Student objects to analyze
     * @return Map where keys are major names (String) and values are average GPAs (Double)
     *         Example: {"Computer Science" → 3.45, "Biology" → 3.62}
     */
    public Map<String, Double> averageGpaByMajor(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.averagingDouble(Student::getGpa)
                ));
    }

    /**
     * Retrieves a sorted list of students who have a GPA at or above the minimum threshold.
     * Uses functional programming with Streams to filter students by GPA
     * and sort the results alphabetically by name.
     *
     * @param students List of Student objects to analyze
     * @param minGpa Minimum GPA threshold (inclusive)
     * @return List of student names (String) with GPA >= minGpa, sorted alphabetically
     *         Example: If minGpa = 3.5, returns ["Alice Johnson", "Bob Smith", "Carol White"]
     */
    public List<String> getHonorsStudents(List<Student> students, double minGpa) {
        return students.stream()
                .filter(student -> student.getGpa() >= minGpa)
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Counts the number of students graduating in each year.
     * Uses functional programming with Streams to group students by graduation year
     * and count the number in each group.
     *
     * @param students List of Student objects to analyze
     * @return Map where keys are graduation years (Integer) and values are student counts (Long)
     *         Example: {2024 → 15, 2025 → 23, 2026 → 18}
     */
    public Map<Integer, Long> countStudentsByGraduationYear(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGraduationYear,
                        Collectors.counting()
                ));
    }

    // Main method for testing
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice Johnson", "Computer Science", 3.8, 2024),
                new Student("Bob Smith", "Computer Science", 3.5, 2024),
                new Student("Carol White", "Biology", 3.9, 2025),
                new Student("David Brown", "Biology", 3.4, 2025),
                new Student("Eve Davis", "Computer Science", 3.2, 2026),
                new Student("Frank Miller", "Mathematics", 3.7, 2024),
                new Student("Grace Lee", "Mathematics", 3.6, 2025),
                new Student("Henry Wilson", "Biology", 3.5, 2026)
        );

        StudentAnalyzer analyzer = new StudentAnalyzer();

        // Test 1: Average GPA by Major
        System.out.println("Average GPA by Major:");
        Map<String, Double> avgGpa = analyzer.averageGpaByMajor(students);
        avgGpa.forEach((major, gpa) ->
                System.out.printf("  %s is %.2f%n", major, gpa));

        // Test 2: Honors Students (GPA >= 3.5)
        System.out.println("\nHonors Students (GPA >= 3.5):");
        List<String> honorsStudents = analyzer.getHonorsStudents(students, 3.5);
        honorsStudents.forEach(name -> System.out.println("  " + name));

        // Test 3: Count by Graduation Year
        System.out.println("\nStudents by Graduation Year:");
        Map<Integer, Long> countByYear = analyzer.countStudentsByGraduationYear(students);
        countByYear.forEach((year, count) ->
                System.out.printf("  %d is %d%n", year, count));
    }
}