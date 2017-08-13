package repositories;

import Domain.Customer;
import Factory.CustomerFactory;
import Repository.CustomerRepository;
import Repository.Impl.CustomerRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class CustomerRepositoryTest
{
    Customer customer;
    Map<String, String> customerValues;
    CustomerRepository customerRepository;
    long customerId;

    @BeforeMethod
    public void setUp() throws Exception {
        customerId = 6;
        customerValues = new HashMap<String, String>();
        customerValues.put("firstName", "Qaasiem");
        customerValues.put("lastName", "Samaai");
        customerValues.put("email", "qaasiemsamaai@gmail.com");
        customerValues.put("address", "Goodwood");
        customerValues.put("password", "12345");
        customer = CustomerFactory.getCustomer(customerId, customerValues);
        customerRepository = CustomerRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        customer = customerRepository.create(customer);
        assertEquals("Samaai", customer.getLastName());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        customer = customerRepository.read(6);
        assertEquals(6,6, customer.getID());

    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        customer = customerRepository.read(6);
        Customer updateCustomer = new Customer.Builder()
                .id(customerId)
                .firstName(customerValues.get("firstName"))
                .lastName(customerValues.get("lastName"))
                .email(customerValues.get("email"))
                .address(customerValues.get("address"))
                .password(customerValues.get("password"))
                .build();
        customerRepository.update(updateCustomer);
        customer = customerRepository.read(6);
        assertEquals("qaasiemsamaai@gmail.com", customer.getEmail());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        customerRepository.delete(6);
        customer = customerRepository.read(6);
        assertNull(customer);
    }
}
