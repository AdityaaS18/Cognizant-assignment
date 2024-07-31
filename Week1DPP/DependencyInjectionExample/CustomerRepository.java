package Week1DPP.DependencyInjectionExample;

// Define Repository Interface
public interface CustomerRepository {
    Customer findCustomerById(int id);
}
