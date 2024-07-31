package Week1DPP.DependencyInjectionExample;

// Test the Dependency Injection Implementation
public class Main {
    public static void main(String[] args) {
        // Create a CustomerRepositoryImpl instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Create a CustomerService instance with the CustomerRepositoryImpl instance
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the CustomerService to find a customer
        Customer customer = customerService.findCustomerById(1);

        System.out.println("Customer found: " + customer.getName() + " (" + customer.getEmail() + ")");
    }
}
