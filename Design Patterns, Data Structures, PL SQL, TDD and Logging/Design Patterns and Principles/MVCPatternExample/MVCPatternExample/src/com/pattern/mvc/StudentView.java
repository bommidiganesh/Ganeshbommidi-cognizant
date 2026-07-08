package com.pattern.mvc;

/**
 * View class. Responsible for rendering the presentation layer.
 */
public class StudentView {
    /**
     * Display student details in a clean, formatted card.
     */
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("========================================");
        System.out.println("             STUDENT RECORD             ");
        System.out.println("========================================");
        System.out.println("  ID:     " + studentId);
        System.out.println("  Name:   " + studentName);
        System.out.println("  Grade:  " + studentGrade);
        System.out.println("========================================\n");
    }
}
