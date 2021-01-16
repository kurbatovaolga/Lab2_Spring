package org.example.Lab2_Spring;


import org.example.Lab2_Spring.entity.Department;
import org.example.Lab2_Spring.entity.Employee;
import org.example.Lab2_Spring.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private EmployeeRepo employeeRepo;

//    @GetMapping("/")
//    public String home(
//            @RequestParam(name="title",required = false,defaultValue = "Отдел Кадров")
//                    Map<String, Object> model) {
//
//        model.put("title", "Главная страница");
//        return "home";
//    }
    @GetMapping
    public String main (Map<String, Object> model) {
       Iterable<Employee> employees = employeeRepo.findAll();
        model.put("employees", employees);
        return "main";
    }
    @PostMapping
    public String add(@RequestParam int personnelNumber, @RequestParam String lastName, @RequestParam String firstName, @RequestParam String middleName,
                      @RequestParam int age, @RequestParam Department department, Map<String, Object> model){
       Employee employee = new Employee (personnelNumber, lastName, firstName, middleName,  age, department);

       employeeRepo.save(employee);
        Iterable<Employee> employees = employeeRepo.findAll();
        model.put("employees", employees);
        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Employee> employees;
        if (filter != null && !filter.isEmpty()) {
            employees =employeeRepo.findByLastName(filter);
        } else {
            employees = employeeRepo.findAll();
        }
        model.put("employees",employees);
        return "main";
    }
}
