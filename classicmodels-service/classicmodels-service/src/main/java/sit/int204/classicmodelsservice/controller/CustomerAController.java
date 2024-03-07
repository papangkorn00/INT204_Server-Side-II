package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.CustomerA;
import sit.int204.classicmodelsservice.services.CustomerAService;

import java.util.List;

@RestController
@RequestMapping("/api/customerAs")
public class CustomerAController {
    @Autowired
    private CustomerAService service;

    @GetMapping("")
    public List<CustomerA> getAllCustomerA(){
        return service.getAllCustomerA();
    }

    @PostMapping("")
    public List<CustomerA> insertCustomerAs(@RequestBody List<CustomerA> customerAs){
        return service.insertCustomers(customerAs);
    }

    @DeleteMapping("/{customerId}")
    public void removeOffice(@PathVariable Long customerId){
        service.removeCustomer(customerId);
    }
}
