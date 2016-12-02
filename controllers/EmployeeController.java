package ua.edu.khibs.resalex.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.EmployeeDao;
import ua.edu.khibs.resalex.model.Employee;
import ua.edu.khibs.resalex.model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {

        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

        Employee employee = new Employee();
        employee.setId(5L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setSalary(100000.0F);

        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeesByName(String name) {
        return employeeDao.findByName(name);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
