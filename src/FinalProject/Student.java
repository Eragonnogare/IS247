package FinalProject;

public class Student extends User {

    public Student(String username, String password) {
        super(username, password);
    }

    @Override
    public void login() {
        System.out.println("Student logged in");
    }
}
