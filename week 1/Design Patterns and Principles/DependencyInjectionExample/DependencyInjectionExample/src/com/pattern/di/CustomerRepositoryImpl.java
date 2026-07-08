package com.pattern.di;

/**
 * Concrete implementation of the CustomerRepository.
 */
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulating database lookup
        System.out.println("[CustomerRepositoryImpl] Executing SELECT query for Customer ID: " + id);
        return switch (id) {
            case 1 -> "Alice Vance";
            case 2 -> "Bob Miller";
            case 3 -> "Charlie Jenkins";
            default -> "Unknown Customer (ID: " + id + ")";
        };
    }
}
