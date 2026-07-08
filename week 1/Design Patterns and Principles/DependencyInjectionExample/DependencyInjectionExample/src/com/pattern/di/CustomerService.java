package com.pattern.di;

/**
 * Service class that depends on CustomerRepository.
 * Follows the Dependency Injection pattern (specifically constructor injection).
 */
public class CustomerService {
    private final CustomerRepository repository;

    /**
     * Dependency is injected via the constructor.
     * This decouples the service from the concrete implementation of the repository.
     *
     * @param repository The injected repository dependency
     */
    public CustomerService(CustomerRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("CustomerRepository cannot be null.");
        }
        this.repository = repository;
    }

    /**
     * Business logic using the injected dependency.
     */
    public String getCustomerName(int id) {
        System.out.println("[CustomerService] Handling request to find customer details...");
        return repository.findCustomerById(id);
    }
}
