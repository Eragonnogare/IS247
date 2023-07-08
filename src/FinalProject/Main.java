package FinalProject;

import java.util.Scanner;

public class Main {
    private static LMS lms = new LMS();
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
        }
    }

    private static void displayMenu() {
        if (currentUser == null) {
            System.out.println("1. Login\n2. Create Student\n3. Create Instructor\n4. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter username");
                    String username = scanner.nextLine();
                    System.out.println("Enter password");
                    String password = scanner.nextLine();
                    currentUser = lms.login(username, password);
                    break;
                case 2:
                    System.out.println("Enter username");
                    username = scanner.nextLine();
                    System.out.println("Enter password");
                    password = scanner.nextLine();
                    lms.createStudent(username, password);
                    break;
                case 3:
                    System.out.println("Enter username");
                    username = scanner.nextLine();
                    System.out.println("Enter password");
                    password = scanner.nextLine();
                    lms.createInstructor(username, password);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } else {
            if(currentUser instanceof Student) {
                System.out.println("1. View My Courses\n2. View Course Material\n3. Logout\n4. Exit");
            } else {
                System.out.println("1. View All Courses\n2. Create Course\n3. Add Course Material\n4. Logout\n5. Exit");
            }

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if (currentUser instanceof Student) {
                        lms.viewStudentCourses((Student) currentUser);
                    } else {
                        lms.viewCourses();
                    }
                    break;
                case 2:
                    if (currentUser instanceof Student) {
                        System.out.println("Enter course name");
                        String courseName = scanner.nextLine();
                        lms.viewCourseMaterial(courseName, (Student) currentUser);
                    } else {
                        System.out.println("Enter course name");
                        String courseName = scanner.nextLine();
                        lms.createCourse(courseName);
                    }
                    break;
                case 3:
                    if (currentUser instanceof Instructor) {
                        System.out.println("Enter course name");
                        String courseName = scanner.nextLine();
                        System.out.println("Enter module name");
                        String moduleName = scanner.nextLine();
                        System.out.println("Enter material");
                        String material = scanner.nextLine();
                        lms.addMaterialToCourse(courseName, moduleName, material);
                    }
                    break;
                case 4:
                    currentUser = null;
                    System.out.println("Logged out successfully");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
