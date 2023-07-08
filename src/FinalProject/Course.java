package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private List<Module> modules;
    private List<Student> students;
    private Instructor instructor;

    public Course(String courseName, Instructor instructor) {
        this.courseName = courseName;
        this.modules = new ArrayList<>();
        this.students = new ArrayList<>();
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void addModule(Module module) {
        this.modules.add(module);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Module getModuleByName(String moduleName) {
        for (Module module : modules) {
            if (module.getModuleName().equals(moduleName)) {
                return module;
            }
        }
        return null;
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

}
