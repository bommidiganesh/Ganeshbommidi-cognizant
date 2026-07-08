package com.pattern.mvc;

public class MVCTest {
    public static void main(String[] args) {
        System.out.println("=== Running MVC Pattern Verification ===");

        // 1. Fetch student record from database/simulation (Model)
        Student studentModel = retrieveStudentFromDatabase();

        // 2. Create a view to write student details to console (View)
        StudentView studentView = new StudentView();

        // 3. Initialize the controller (Controller)
        StudentController controller = new StudentController(studentModel, studentView);

        System.out.println("--- Initial View Rendering ---");
        controller.updateView();

        // 4. Update model data through the controller
        System.out.println("--- Updating Model State via Controller ---");
        controller.setStudentName("Robert Martin");
        controller.setStudentGrade("A+");
        System.out.println("Data updated through controller.\n");

        System.out.println("--- Updated View Rendering ---");
        controller.updateView();

        // Verification assertions
        if (!controller.getStudentName().equals("Robert Martin") || !controller.getStudentGrade().equals("A+")) {
            System.err.println("TEST FAILED: Controller did not update the model properties correctly!");
            System.exit(1);
        }

        System.out.println("TEST PASSED: Model updates were successfully mediated by the Controller and rendered by the View.");
        System.out.println("=== MVC Pattern Verification Completed Successfully ===\n");
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("John Doe");
        student.setId("STU-10294");
        student.setGrade("B-");
        return student;
    }
}
