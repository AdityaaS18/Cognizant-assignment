package Week1DPP.DependencyInjectionExample;

// Implement Concrete Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Simulate data retrieval from database or other data source
        Customer customer = new Customer(id, "John Doe", "john.doe@example.com");
        return customer;
    }
}