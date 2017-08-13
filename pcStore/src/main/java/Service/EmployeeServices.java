package Service;

import Domain.Employee;

/**
 * Created by qaasiem on 2017-08-13.
 */
public interface EmployeeServices
{
    Employee create(Employee employee);

    Employee read(long id);

    Employee update(Employee employee);

    void delete(long id);
}
