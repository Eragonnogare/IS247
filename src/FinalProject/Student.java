package FinalProject;

import java.util.*;

public class Student extends User {
    private List<Course> courses;

    public Student(String username, String password) {
        super(username, password);
        this.courses = new ArrayList<>();
    }

    @Override
    public void login() {
        System.out.println("Student logged in");
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void viewCourses() {
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }
}
