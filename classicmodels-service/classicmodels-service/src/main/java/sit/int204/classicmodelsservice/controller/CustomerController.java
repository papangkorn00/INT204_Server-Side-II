package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomer();
    }

    @GetMapping("/{customerNumber}")
    public Customer getCustomerById(@PathVariable String customerNumber) {
        return service.getCustomer(customerNumber);
    }

}
