package com.dailyCodeBuffer.Springdemo.Repository;

import com.dailyCodeBuffer.Springdemo.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
}
