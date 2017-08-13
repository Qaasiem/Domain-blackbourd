package factories;

import Domain.Employee;
import Factory.EmployeeFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class EmployeeFactoryTest
{
    Employee employee;

    Map<String, String> employeeValues;

    @BeforeMethod
    public void setUp() throws Exception {
        long employeeId = 1;
        employeeValues = new HashMap<String, String>();
        employeeValues.put("firstName", "Qaasiem");
        employeeValues.put("lastName", "Samaai");
        employeeValues.put("address", "172 Wellington street Goodwood");
        employeeValues.put("password", "123456");
        employeeValues.put("jobDescription", "IT");
        employee = EmployeeFactory.getEmployee(employeeId, employeeValues);
    }

    @Test
    public void testGetlastName() throws Exception {
        assertEquals(true, employee.equals(employee));
    }
}
