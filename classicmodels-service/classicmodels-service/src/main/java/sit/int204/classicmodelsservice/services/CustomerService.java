package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }

    public Customer getCustomer(String customerNumber) {
        return repository.findById(customerNumber).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Employee Number " + customerNumber + " Does not exist!!!"));
    }
}
