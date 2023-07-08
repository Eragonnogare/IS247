package FinalProject;

import java.util.*;

public class Course {
    private String courseName;
    private Instructor instructor;
    private List<Student> students;
    private List<Module> modules;

    public Course(String courseName, Instructor instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = new ArrayList<>();
        this.modules = new ArrayList<>();
        instructor.addCourse(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.addCourse(this);
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }

    public void viewMaterials() {
        for (Module module : modules) {
            module.viewMaterials();
        }
    }

    public void printCourseHierarchy() {
        System.out.println(courseName);
        for (Module module : modules) {
            System.out.println("  Module: " + module.getModuleName());
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getCourseName() {
        return courseName;
    }
}
