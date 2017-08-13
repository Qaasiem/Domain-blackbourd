package Factory;

import Domain.Customer;

import java.util.Map;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class CustomerFactory
{
    public static Customer getCustomer(Long id, Map<String, String> customerValues)
    {
        Customer customer = new Customer.Builder()
                .id(id)
                .firstName(customerValues.get("firstName"))
                .lastName(customerValues.get("lastName"))
                .email(customerValues.get("email"))
                .address(customerValues.get("address"))
                .password(customerValues.get("password"))
                .build();
        return customer;
    }
}
