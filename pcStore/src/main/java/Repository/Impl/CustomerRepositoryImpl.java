package Repository.Impl;

import Domain.Customer;
import Repository.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class CustomerRepositoryImpl implements CustomerRepository
{
    private static CustomerRepositoryImpl repository = null;

    private Map<Long, Customer> customerTable;

    private CustomerRepositoryImpl()
    {
        customerTable = new HashMap<Long, Customer>();
    }

    public static CustomerRepositoryImpl getRepository()
    {
        if(repository == null)
        {
            repository = new CustomerRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Customer create(Customer customer) {
        customerTable.put(customer.getID(), customer);
        Customer saveCustomer = customerTable.get(customer.getID());
        return saveCustomer;
    }

    @Override
    public Customer read(long id) {
        Customer customer = customerTable.get(id);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        customerTable.put(customer.getID(), customer);
        Customer updateCustomer = customerTable.get(customer.getID());
        return updateCustomer;
    }

    @Override
    public void delete(long id) {
        customerTable.remove(id);
    }
}
