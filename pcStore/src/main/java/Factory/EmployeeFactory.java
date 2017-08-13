package Factory;

import Domain.Employee;

import java.util.Map;
/**
 * Created by qaasiem on 2017-08-13.
 */
public class EmployeeFactory
{
    public static Employee getEmployee(Long id, Map<String, String> employeeValues)
    {
        Employee employee = new Employee.Builder()
                .id(id)
                .firstName(employeeValues.get("firstName"))
                .lastName(employeeValues.get("lastName"))
                .address(employeeValues.get("address"))
                .password(employeeValues.get("password"))
                .jobDescription(employeeValues.get("jobDescription"))
                .build();
        return employee;
    }
}
