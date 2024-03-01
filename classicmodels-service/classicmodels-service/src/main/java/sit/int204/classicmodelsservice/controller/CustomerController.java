package sit.int204.classicmodelsservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.dtos.SimpleCustomerDTO;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Integer id) {
        Customer customer = service.findByID(id);
        SimpleCustomerDTO simpleCustomer = modelMapper.map(customer, SimpleCustomerDTO.class);
        return ResponseEntity.ok(simpleCustomer);
    }

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomer();
    }

//    @GetMapping("/{customerNumber}")
//    public Customer getCustomerById(@PathVareable String customerNumber) {
//        return service.getCustomer(customerNumber);
//    }

}
