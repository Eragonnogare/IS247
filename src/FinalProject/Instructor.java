package FinalProject;

import java.util.ArrayList;
import java.util.List;

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

    public List<Course> getCourses() {
        return this.courses;
    }
}
