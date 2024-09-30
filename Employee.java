package com.GuviTask.access_mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "EmployeeDetails")
public class Employee {
    @Id
    private Long employeeId;
    private String employeeEmail;
    private String employeeName;
    private String employeeLocation;
}
