package com.dailyCodeBuffer.Springdemo.Service;

import com.dailyCodeBuffer.Springdemo.Entity.EmployeeEntity;
import com.dailyCodeBuffer.Springdemo.Exception.EmployeeNotFoundException;
import com.dailyCodeBuffer.Springdemo.Model.Employee;
import com.dailyCodeBuffer.Springdemo.Repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceV2impl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee.getId() == null){
            employee.setId(UUID.randomUUID().toString());
        }
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        employeeRepo.save(entity);

        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();

        List<Employee> employees = employeeEntities.stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity,employee);
                    return employee;
                })
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public Employee getEmployee(String id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for id " +id));
        if(employeeEntity!= null){
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity,employee);
            return employee;
        }
        return null;
    }

    @Override
    public Employee remove(String id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id)
               .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for id " +id));
        if(employeeEntity!=null){
            employeeRepo.deleteById(id);
        }
        else{
            throw new EmployeeNotFoundException("Employee not found for id " +id);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }
}
