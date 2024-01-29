package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    public Employee getEmployee(int employeeNumber) {
        return repository.findById(employeeNumber).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Employee Number " + employeeNumber + " Does not exist!!!"));
    }


}