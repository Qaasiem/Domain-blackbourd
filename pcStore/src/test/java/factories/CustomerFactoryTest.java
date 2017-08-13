package factories;

import Domain.Customer;
import Factory.CustomerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class CustomerFactoryTest
{
    Customer customer;

    Map<String, String> customerValues;

    @BeforeMethod
    public void setUp() throws Exception {
        long customerId = 3;
        customerValues = new HashMap<String, String>();
        customerValues.put("firstName", "Qaasiem");
        customerValues.put("lastName", "Samaai");
        customerValues.put("email", "qaasiemsamaai@gmail.com");
        customerValues.put("address", "Goodwood");
        customerValues.put("password", "12345");
        customer = CustomerFactory.getCustomer(customerId, customerValues);
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals(true, customer.equals(customer));
    }
}
