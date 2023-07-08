package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users;
    private List<Course> courses;

    public Database() {
        users = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}