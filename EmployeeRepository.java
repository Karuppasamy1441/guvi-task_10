package com.GuviTask.access_mongodb.Repository;

import com.GuviTask.access_mongodb.dto.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Long> {



    void deleteByEmployeeId(Long employeeId);
}
