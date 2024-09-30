package com.GuviTask.access_mongodb.Service;

import com.GuviTask.access_mongodb.Repository.EmployeeRepository;
import com.GuviTask.access_mongodb.dto.Employee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmoployeeService {
    EmployeeRepository employeeRepository;
    ModelMapper modelMapper;
    public List<Employee> getAllEmployeeDetails() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeDetailsById(Long id) {
        return employeeRepository.findByEmployeeId(id).get();
    }

    public Employee addEmployeeDetails(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeDetails(Employee employee, Long id) {


        Employee employee1= employeeRepository.findByEmployeeId(id).get();

        employeeRepository.deleteByEmployeeId(id);

        employee1.setEmployeeEmail(employee.getEmployeeEmail());
        employee1.setEmployeeLocation(employee.getEmployeeLocation());
        employee1.setEmployeeName(employee.getEmployeeName());

        employeeRepository.save(employee1);

        return employee1;
    }

    public void deleteEmployeeDetails(Long id) {
         employeeRepository.deleteByEmployeeId(id);

    }
}
