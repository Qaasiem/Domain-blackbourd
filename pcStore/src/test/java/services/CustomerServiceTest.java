package services;

import Domain.Customer;
import Factory.CustomerFactory;
import Service.CustomerServices;
import Service.Impl.CustomerServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class CustomerServiceTest
{
    Customer customer;
    Map<String, String> customerValues;
    CustomerServices customerServices;
    long customerId;

    @BeforeMethod
    public void setUp() throws Exception {
        customerId = 3;
        customerValues = new HashMap<String, String>();
        customerValues.put("firstName", "Qaasiem");
        customerValues.put("lastName", "Samaai");
        customerValues.put("email", "qaasiemsamaai@gmail.com");
        customerValues.put("address", "Goodwood");
        customerValues.put("password", "12345");
        customer = CustomerFactory.getCustomer(customerId, customerValues);
        customerServices = new CustomerServiceImpl();
    }

    @Test
    public void testCreate() throws Exception {
        customerServices.create(customer);
        assertEquals("Samaai", customer.getLastName());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        customerServices.read(3);
        assertEquals("qaasiemsamaai@gmail.com", customer.getEmail());

    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        customerServices.read(3);
        Customer updateHardware = new Customer.Builder()
                .id(customerId)
                .firstName(customerValues.get("firstName"))
                .lastName(customerValues.get("lastName"))
                .email(customerValues.get("email"))
                .address(customerValues.get("address"))
                .password(customerValues.get("password"))
                .build();
        customerServices.update(updateHardware);
        customer = customerServices.read(3);
        assertEquals("12345", customer.getPassword());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        customerServices.delete(3);
        customer = customerServices.read(3);
        assertNull(customer);
    }
}
