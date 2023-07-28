package com.dailyCodeBuffer.Springdemo.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

    private  String Id;
    private String name;
    private  String address;
    private String department;
    private int salary;

}
