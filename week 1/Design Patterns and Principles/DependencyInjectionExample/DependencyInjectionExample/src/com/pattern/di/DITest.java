package com.pattern.di;

public class DITest {
    public static void main(String[] args) {
        System.out.println("=== Running Dependency Injection Verification ===");

        // 1. Create the concrete repository (Dependency)
        CustomerRepository repository = new CustomerRepositoryImpl();

        // 2. Inject the dependency into the service via constructor (Assembler/DI)
        CustomerService service = new CustomerService(repository);

        System.out.println("--- Test 1: Querying Customer ID 1 ---");
        String customer1 = service.getCustomerName(1);
        System.out.println("Result: " + customer1);
        System.out.println();

        System.out.println("--- Test 2: Querying Customer ID 2 ---");
        String customer2 = service.getCustomerName(2);
        System.out.println("Result: " + customer2);
        System.out.println();

        System.out.println("--- Test 3: Querying Non-existent Customer ---");
        String customerUnknown = service.getCustomerName(99);
        System.out.println("Result: " + customerUnknown);
        System.out.println();

        // Verification assertions
        if (!customer1.equals("Alice Vance") || !customer2.equals("Bob Miller")) {
            System.err.println("TEST FAILED: Service did not return correct customer data!");
            System.exit(1);
        }

        System.out.println("TEST PASSED: Decoupled service was successfully constructed and executed using Constructor Injection.");
        System.out.println("=== Dependency Injection Verification Completed Successfully ===\n");
    }
}
