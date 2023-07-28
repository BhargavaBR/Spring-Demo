package com.dailyCodeBuffer.Springdemo.Service;

import com.dailyCodeBuffer.Springdemo.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getEmployees();

    Employee getEmployee(String id);

    Employee remove(String id);
}
