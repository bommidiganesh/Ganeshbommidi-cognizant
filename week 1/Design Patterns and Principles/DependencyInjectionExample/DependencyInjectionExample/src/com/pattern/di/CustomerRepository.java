package com.pattern.di;

/**
 * Repository interface defining data access contracts.
 */
public interface CustomerRepository {
    String findCustomerById(int id);
}
