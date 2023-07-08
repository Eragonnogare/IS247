package FinalProject;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class LMS {
    private Database database;
    private Stack<User> userLog;  // Stack to hold logged-in users

    public LMS() {
        database = new Database();
        userLog = new Stack<>();
    }

    public User login(String username, String password) {
        User user = database.getUser(username, password);
        if (user != null) {
            userLog.push(user); // Push user into the stack on successful login
            return user;
        }
        return null;
    }

    public void createStudent(String username, String password) {
        database.addUser(username, password, "Student");
    }

    public void createInstructor(String username, String password) {
        database.addUser(username, password, "Instructor");
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

    public void leaveCourse(String courseName, Student student) {
        Course course = database.getCourseByName(courseName);
        if (course == null) {
            System.out.println("Course does not exist!");
            return;
        }
        course.removeStudent(student);
        System.out.println("You've successfully left the course: " + courseName);
    }

    public void instructorAddStudent(String courseName, String studentName, Instructor instructor)  {
        Course course = database.getCourseByName(courseName);
        User user = database.getUserByName(studentName);
        if (course == null) {
            System.out.println("Course does not exist!");
            return;
        }
        if (!course.getInstructor().getUsername().equals(instructor.getUsername())) {
            System.out.println("You do not have permission to modify this course!");
            return;
        }
        if (user instanceof Student) {
            course.addStudent((Student) user);
            System.out.println("Student added successfully to the course!");
        } else {
            System.out.println("User is not a Student!");
        }
    }

    public void instructorRemoveStudent(String courseName, String studentName, Instructor instructor)  {
        Course course = database.getCourseByName(courseName);
        User user = database.getUserByName(studentName);
        if (course == null) {
            System.out.println("Course does not exist!");
            return;
        }
        if (!course.getInstructor().getUsername().equals(instructor.getUsername())) {
            System.out.println("You do not have permission to modify this course!");
            return;
        }
        if (user instanceof Student) {
            course.removeStudent((Student) user);
            System.out.println("Student removed successfully from the course!");
        } else {
            System.out.println("User is not a Student!");
        }
    }

    public Database getDatabase() {
        return this.database;
    }

}
