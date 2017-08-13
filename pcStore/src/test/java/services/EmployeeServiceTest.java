package services;

import Domain.Employee;
import Factory.EmployeeFactory;
import Service.EmployeeServices;
import Service.Impl.EmployeeServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class EmployeeServiceTest
{
    Employee employee;
    Map<String, String> employeeValues;
    EmployeeServices employeeService;
    long employeeId;

    @BeforeMethod
    public void setUp() throws Exception {
        employeeId = 41;
        employeeValues = new HashMap<String, String>();
        employeeValues.put("firstName", "Qaasiem");
        employeeValues.put("lastName", "Samaai");
        employeeValues.put("address", "172 Wellington street Goodwood");
        employeeValues.put("password", "123456");
        employeeValues.put("jobDescription", "IT");
        employee = EmployeeFactory.getEmployee(employeeId, employeeValues);
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testCreate() throws Exception {
        employeeService.create(employee);
        assertEquals("172 Wellington street Goodwood", employee.getAddress());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        employeeService.read(41);
        assertEquals("IT", employee.getJobDescription());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        employeeService.read(41);
        Employee updateSupplier = new Employee.Builder()
                .id(employeeId)
                .firstName(employeeValues.get("firstName"))
                .lastName(employeeValues.get("lastName"))
                .address(employeeValues.get("address"))
                .password(employeeValues.get("password"))
                .jobDescription(employeeValues.get("jobDescription"))
                .build();
        employeeService.update(updateSupplier);
        employee = employeeService.read(41);
        assertEquals("123456", employee.getPassword());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        employeeService.delete(41);
        employee = employeeService.read(41);
        assertNull(employee);
    }
}
