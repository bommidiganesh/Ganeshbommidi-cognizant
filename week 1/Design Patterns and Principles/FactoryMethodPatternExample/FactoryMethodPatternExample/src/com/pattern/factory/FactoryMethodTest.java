package com.pattern.factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Running Factory Method Pattern Verification ===");

        // Initialize factories for different document types
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        System.out.println("--- Test 1: Creating Word Document ---");
        Document wordDoc = wordFactory.createDocument();
        System.out.println("Created Document Type: " + wordDoc.getType());
        wordDoc.open();
        wordDoc.close();
        System.out.println();

        System.out.println("--- Test 2: Creating PDF Document ---");
        Document pdfDoc = pdfFactory.createDocument();
        System.out.println("Created Document Type: " + pdfDoc.getType());
        pdfDoc.open();
        pdfDoc.close();
        System.out.println();

        System.out.println("--- Test 3: Creating Excel Spreadsheet ---");
        Document excelDoc = excelFactory.createDocument();
        System.out.println("Created Document Type: " + excelDoc.getType());
        excelDoc.open();
        excelDoc.close();
        System.out.println();

        System.out.println("--- Test 4: Dynamic Factory Operations ---");
        // Demonstrate invoking operations defined on the creator
        System.out.println("Executing wordFactory.printDocumentDetails():");
        wordFactory.printDocumentDetails();
        System.out.println();
        
        System.out.println("Executing pdfFactory.printDocumentDetails():");
        pdfFactory.printDocumentDetails();
        System.out.println();

        System.out.println("Executing excelFactory.printDocumentDetails():");
        excelFactory.printDocumentDetails();
        System.out.println();

        // Basic Assertions to verify correct inheritance and instantiation
        if (!(wordDoc instanceof WordDocument) || !(pdfDoc instanceof PdfDocument) || !(excelDoc instanceof ExcelDocument)) {
            System.err.println("TEST FAILED: Incorrect class instantiation via factory methods!");
            System.exit(1);
        }

        System.out.println("TEST PASSED: Document factories instantiated correct document subclasses successfully.");
        System.out.println("=== Factory Method Pattern Verification Completed Successfully ===\n");
    }
}
