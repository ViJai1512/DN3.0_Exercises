public class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(String id) {
        // Simulate fetching a customer from a database
        return new Customer(id, "Customer " + id);
    }
}
