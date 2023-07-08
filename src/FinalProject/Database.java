package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users;
    private List<Course> courses;

    public Database() {
        this.users = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Course getCourseByName(String courseName) {
        for (Course course : courses) {
            if (course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        return null;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public List<User> getAllUsers() {
        return this.users;
    }
}
