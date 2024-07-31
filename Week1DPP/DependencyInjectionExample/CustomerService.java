package Week1DPP.DependencyInjectionExample;

// Define Service Class
public class CustomerService {
    private final CustomerRepository customerRepository;

    // Implement Dependency Injection using constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}
