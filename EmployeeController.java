package com.GuviTask.access_mongodb.Controller;

import com.GuviTask.access_mongodb.dto.Employee;
import com.GuviTask.access_mongodb.Service.EmoployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmoployeeService emoployeeService;

    @GetMapping("/homePage")
    public String  getAllEmployeeDetails(Model model){
        model.addAttribute("allEmpList",emoployeeService.getAllEmployeeDetails());
        return "index";
    }


    @GetMapping("/addNew")
    public String  addNewEmployee(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "newEmployee";
    }

    @PostMapping("/save")
    public String addEmployeeDetails(@ModelAttribute("employee") Employee employee){
        emoployeeService.addEmployeeDetails(employee);
        return "redirect:/homePage";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String  addNewEmployee(@PathVariable long id, Model model){
        Employee employee=emoployeeService.getEmployeeDetailsById(id);
        model.addAttribute("employee",employee);
        return "update";
    }


    @GetMapping("deleteEmployee/{id}")
    public String  deleteEmployeeDetails(@PathVariable Long  id){
        emoployeeService.deleteEmployeeDetails(id);
        return "redirect:/homePage";
    }

}
