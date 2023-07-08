package FinalProject;

import java.util.*;

public class LMS {
    private Database database;

    public LMS() {
        this.database = new Database();
    }

    public User login(String username, String password) {
        for (User user : database.getAllUsers()) {
            if (user.verify(username, password)) {
                System.out.println("Login successful");
                return user;
            }
        }
        System.out.println("Login failed");
        return null;
    }

    public void viewCourses() {
        for (Course course : database.getAllCourses()) {
            System.out.println(course.getCourseName());
        }
    }

    public void createStudent(String username, String password) {
        Student student = new Student(username, password);
        database.addUser(student);
        System.out.println("Student created");
    }

    public void createInstructor(String username, String password) {
        Instructor instructor = new Instructor(username, password);
        database.addUser(instructor);
        System.out.println("Instructor created");
    }

    public void createCourse(String courseName, String instructorUsername) {
        Instructor instructor = (Instructor) getUser(instructorUsername);
        if (instructor != null) {
            Course course = new Course(courseName, instructor);
            database.addCourse(course);
            System.out.println("Course created");
        } else {
            System.out.println("Instructor not found");
        }
    }

    private User getUser(String username) {
        for (User user : database.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void viewStudentCourses(Student student) {
        for (Course course : database.getAllCourses()) {
            if (course.getStudents().contains(student)) {
                System.out.println(course.getCourseName());
            }
        }
    }

    public void addMaterialToCourse(String courseName, String moduleName, String material) {
        Course course = getCourse(courseName);
        if (course != null) {
            Module module = getModuleFromCourse(course, moduleName);
            if (module != null) {
                module.addMaterial(material);
                System.out.println("Material added to course");
            } else {
                System.out.println("Module not found");
            }
        } else {
            System.out.println("Course not found");
        }
    }

    private Course getCourse(String courseName) {
        for (Course course : database.getAllCourses()) {
            if (course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        return null;
    }

    private Module getModuleFromCourse(Course course, String moduleName) {
        for (Module module : course.getModules()) {
            if (module.getModuleName().equals(moduleName)) {
                return module;
            }
        }
        return null;
    }

    public void viewCourseMaterials(String courseName) {
        Course course = getCourse(courseName);
        if (course != null) {
            course.viewMaterials();
        } else {
            System.out.println("Course not found");
        }
    }
}
