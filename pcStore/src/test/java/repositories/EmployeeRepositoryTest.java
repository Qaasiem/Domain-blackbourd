package repositories;

import Domain.Employee;
import Factory.EmployeeFactory;
import Repository.EmployeeRepository;
import Repository.Impl.EmployeeRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class EmployeeRepositoryTest
{
    Employee employee;
    Map<String, String> employeeValues;
    EmployeeRepository employeeRepository;
    long employeeId;

    @BeforeMethod
    public void setUp() throws Exception {
        employeeId = 62;
        employeeValues = new HashMap<String, String>();
        employeeValues.put("firstName", "Qaasiem");
        employeeValues.put("lastName", "Samaai");
        employeeValues.put("address", "172 Wellington street Goodwood");
        employeeValues.put("password", "123456");
        employeeValues.put("jobDescription", "IT");
        employee = EmployeeFactory.getEmployee(employeeId, employeeValues);
        employeeRepository = EmployeeRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        employee = employeeRepository.create(employee);
        assertEquals("172 Wellington street Goodwood", employee.getAddress());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        employee = employeeRepository.read(62);
        assertEquals(62,62, employee.getID());

    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        employee = employeeRepository.read(62);
        Employee updateEmployee = new Employee.Builder()
                .id(employeeId)
                .firstName(employeeValues.get("firstName"))
                .lastName(employeeValues.get("lastName"))
                .address(employeeValues.get("address"))
                .password(employeeValues.get("password"))
                .jobDescription(employeeValues.get("jobDescription"))
                .build();
        employeeRepository.update(updateEmployee);
        employee = employeeRepository.read(62);
        assertEquals("123456", employee.getPassword());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        employeeRepository.delete(62);
        employee = employeeRepository.read(62);
        assertNull(employee);
    }
}
