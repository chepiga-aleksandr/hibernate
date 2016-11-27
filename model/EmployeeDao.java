package ua.edu.khibs.resalex.model;

import java.util.List;

public interface EmployeeDao {

    void save (Employee employee);

    Employee load (Long id);

    List<Employee> findAll ();

}
