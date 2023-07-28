package com.dailyCodeBuffer.Springdemo.Service;

import com.dailyCodeBuffer.Springdemo.Exception.EmployeeNotFoundException;
import com.dailyCodeBuffer.Springdemo.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees = new ArrayList<>();
    @Override
    public Employee addEmployee( Employee employee) {
        if(employee.getId() == null){
            employee.setId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployee(String id) {
        return employees.stream()
                .filter(employee -> employee.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() ->  new EmployeeNotFoundException("Employee Not found with id :"+id));
    }

    @Override
    public Employee remove(String id) {

        Employee removedEmp = employees.stream()
                .filter(employee -> employee.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id :"+id+" not found "));

        employees.remove(removedEmp);
        return removedEmp;
    }
}
