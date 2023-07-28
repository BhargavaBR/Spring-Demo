package com.dailyCodeBuffer.Springdemo.Controller;


import com.dailyCodeBuffer.Springdemo.Model.Employee;
import com.dailyCodeBuffer.Springdemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class EmpolyeeControllerV2 {


    @Qualifier("employeeServiceV2impl")
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        //return employee;
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/allEmpolyees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable String id){
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/employee/{id}")
    public Employee remove(@PathVariable String id){
        return employeeService.remove(id);
    }
}
