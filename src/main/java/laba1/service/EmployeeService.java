package laba1.service;

import laba1.dao.implementations.EmployeeDao;
import laba1.dao.interfaces.IDao;
import laba1.model.Employee;

public class EmployeeService extends GenericService<Employee> {
    public EmployeeService() {
        super(new EmployeeDao());
    }
}
