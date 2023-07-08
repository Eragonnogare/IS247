package FinalProject;

import java.util.*;

import java.util.*;

public class Instructor extends User {
    private List<Course> courses;

    public Instructor(String username, String password) {
        super(username, password);
        this.courses = new ArrayList<>();
    }

    @Override
    public void login() {
        System.out.println("Instructor logged in");
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
