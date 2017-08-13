package Service;

import Domain.Customer;

/**
 * Created by qaasiem on 2017-08-13.
 */
public interface CustomerServices
{
    Customer create(Customer customer);

    Customer read(long id);

    Customer update(Customer customer);

    void delete(long id);
}
