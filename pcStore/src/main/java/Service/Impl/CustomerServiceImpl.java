package Service.Impl;

import Domain.Customer;
import Repository.CustomerRepository;
import Repository.Impl.CustomerRepositoryImpl;
import Service.CustomerServices;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class CustomerServiceImpl implements CustomerServices
{
    CustomerRepository repository = CustomerRepositoryImpl.getRepository();

    @Override
    public Customer create(Customer customer) {
        return repository.create(customer);
    }

    @Override
    public Customer read(long id) {
        return repository.read(id);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
