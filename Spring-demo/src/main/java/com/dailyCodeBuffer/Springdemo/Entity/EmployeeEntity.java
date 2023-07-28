package com.dailyCodeBuffer.Springdemo.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EmployeeEntity {
    @Id
    private  String Id;
    private String name;
    private  String address;
    private String department;
    private int salary;
}
