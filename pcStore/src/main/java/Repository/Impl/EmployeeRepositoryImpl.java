package Repository.Impl;

import Domain.Employee;
import Repository.EmployeeRepository;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qaasiem on 2017-08-13.
 */
public class EmployeeRepositoryImpl implements EmployeeRepository
{
    private static EmployeeRepositoryImpl repository = null;

    private Map<Long, Employee> employeeTable;

    private EmployeeRepositoryImpl()
    {
        employeeTable = new HashMap<Long, Employee>();
    }

    public static EmployeeRepositoryImpl getRepository()
    {
        if(repository == null)
        {
            repository = new EmployeeRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Employee create(Employee employee) {
        employeeTable.put(employee.getID(), employee);
        Employee saveEmployee = employeeTable.get(employee.getID());
        return saveEmployee;
    }

    @Override
    public Employee read(long id) {
        Employee employee = employeeTable.get(id);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        employeeTable.put(employee.getID(), employee);
        Employee updateEmployee = employeeTable.get(employee.getID());
        return updateEmployee;
    }

    @Override
    public void delete(long id) {
        employeeTable.remove(id);
    }
}
