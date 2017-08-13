package Service.Impl;

import Domain.Employee;
import Repository.EmployeeRepository;
import Repository.Impl.EmployeeRepositoryImpl;
import Service.EmployeeServices;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class EmployeeServiceImpl implements EmployeeServices
{
    EmployeeRepository repository = EmployeeRepositoryImpl.getRepository();

    @Override
    public Employee create(Employee employee) {
        return repository.create(employee);
    }

    @Override
    public Employee read(long id) {
        return repository.read(id);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
