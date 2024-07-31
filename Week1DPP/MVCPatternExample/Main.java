package Week1DPP.MVCPatternExample;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Create a new student
        Student model = new Student(1, "John Doe", 85.0);

        // Create a new student view
        StudentView view = new StudentView();

        // Create a new student controller
        StudentController controller = new StudentController(model, view);

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade(90.0);

        // Update the view
        controller.updateView();
    }
}
