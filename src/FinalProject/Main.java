package FinalProject;

import java.util.Scanner;

public class Main {

    private static final LMS lms = new LMS();
    private static User loggedInUser = null;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Welcome to the LMS");
        while (!exit) {
            System.out.println("1. Login");
            System.out.println("2. Create Student");
            System.out.println("3. Create Instructor");
            System.out.println("4. View All Courses");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline left-over
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    createInstructor();
                    break;
                case 4:
                    lms.viewAllCourses();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Try again");
                    break;
            }
        }
    }

    private static void login() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        loggedInUser = lms.login(username, password);
        if (loggedInUser != null) {
            System.out.println("Login Successful!");
            if (loggedInUser instanceof Student) {
                studentMenu();
            } else if (loggedInUser instanceof Instructor) {
                instructorMenu();
            }
        } else {
            System.out.println("Invalid username or password! Try again");
        }
    }

    private static void studentMenu() {
        boolean logout = false;
        while (!logout) {
            System.out.println("1. View Courses");
            System.out.println("2. Join Course");
            System.out.println("3. View Course Materials");
            System.out.println("4. Logout");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline left-over
            switch (choice) {
                case 1:
                    lms.viewStudentCourses((Student) loggedInUser);
                    break;
                case 2:
                    joinCourse();
                    break;
                case 3:
                    viewCourseMaterials();
                    break;
                case 4:
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid option! Try again");
                    break;
            }
        }
    }

    private static void instructorMenu() {
        boolean logout = false;
        while (!logout) {
            System.out.println("1. Create Course");
            System.out.println("2. Add Course Material");
            System.out.println("3. Logout");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline left-over
            switch (choice) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    addCourseMaterial();
                    break;
                case 3:
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid option! Try again");
                    break;
            }
        }
    }

    private static void createStudent() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        lms.createStudent(username, password);
        System.out.println("Student created successfully!");
    }

    private static void createInstructor() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        lms.createInstructor(username, password);
        System.out.println("Instructor created successfully!");
    }

    private static void createCourse() {
        System.out.println("Enter course name:");
        String courseName = sc.nextLine();
        lms.createCourse(courseName, (Instructor) loggedInUser);
        System.out.println("Course created successfully!");
    }

    private static void addCourseMaterial() {
        System.out.println("Enter course name:");
        String courseName = sc.nextLine();
        System.out.println("Enter module name:");
        String moduleName = sc.nextLine();
        System.out.println("Enter material name:");
        String materialName = sc.nextLine();
        lms.addCourseMaterial(courseName, moduleName, materialName, (Instructor) loggedInUser);
    }

    private static void joinCourse() {
        System.out.println("Enter course name:");
        String courseName = sc.nextLine();
        lms.joinCourse(courseName, (Student) loggedInUser);
    }

    private static void viewCourseMaterials() {
        System.out.println("Enter course name:");
        String courseName = sc.nextLine();
        System.out.println("Enter module name:");
        String moduleName = sc.nextLine();
        lms.viewCourseMaterials(courseName, moduleName);
    }
}
