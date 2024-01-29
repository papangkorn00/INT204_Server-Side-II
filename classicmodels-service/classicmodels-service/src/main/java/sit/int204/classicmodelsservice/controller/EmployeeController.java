package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.services.EmployeeService;
import sit.int204.classicmodelsservice.services.OfficeService;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }
}
