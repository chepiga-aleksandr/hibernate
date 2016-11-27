package ua.edu.khibs.resalex.model.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.model.Employee;
import ua.edu.khibs.resalex.model.EmployeeDao;
import ua.edu.khibs.resalex.model.Position;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {

        Employee employee = new Employee();
        employee.setId(3L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setSalary(100000.0F);

        employeeDao.save(employee);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
