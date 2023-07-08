package FinalProject;

import java.util.List;
import java.util.Optional;

public class LMS {
    private Database database;

    public LMS() {
        database = new Database();
    }

    public User login(String username, String password) {
        return database.getUser(username, password);
    }

    public void createStudent(String username, String password) {
        database.addUser(new Student(username, password));
    }

    public void createInstructor(String username, String password) {
        database.addUser(new Instructor(username, password));
    }

    public void createCourse(String courseName, Instructor instructor) {
        Course course = new Course(courseName, instructor);
        database.addCourse(course);
    }

    public void joinCourse(String courseName, Student student) {
        Course course = database.getCourseByName(courseName);
        if (course != null) {
            course.addStudent(student);
            System.out.println("You've successfully joined the course!");
        } else {
            System.out.println("Course not found");
        }
    }

    public void addCourseMaterial(String courseName, String moduleName, String materialName, Instructor instructor) {
        Course course = database.getCourseByName(courseName);
        if (course == null) {
            System.out.println("Course does not exist!");
            return;
        }
        if (!course.getInstructor().getUsername().equals(instructor.getUsername())) {
            System.out.println("You do not have permission to modify this course!");
            return;
        }
        Module module = course.getModuleByName(moduleName);
        if (module == null) {
            module = new Module(moduleName);
            course.addModule(module);
        }
        module.addMaterial(materialName);
        System.out.println("Material added successfully!");
    }

    public void viewCourseMaterials(String courseName, String moduleName) {
        Course course = database.getCourseByName(courseName);
        if (course != null) {
            Optional<Module> module = course.getModules().stream().filter(m -> m.getModuleName().equals(moduleName)).findFirst();
            if (module.isPresent()) {
                System.out.println("Materials for module " + moduleName + " in " + courseName + ":");
                List<String> materials = module.get().getMaterials();
                for (String material : materials) {
                    System.out.println(material);
                }
            } else {
                System.out.println("Module not found in the course");
            }
        } else {
            System.out.println("Course not found");
        }
    }

    public void viewAllCourses() {
        List<Course> courses = database.getCourses();
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }

    public void viewStudentCourses(Student student) {
        List<Course> courses = database.getCourses();
        for (Course course : courses) {
            if (course.getStudents().contains(student)) {
                System.out.println(course.getCourseName());
            }
        }
    }
}
