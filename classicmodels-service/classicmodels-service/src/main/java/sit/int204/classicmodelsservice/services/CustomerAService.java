package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.CustomerA;
import sit.int204.classicmodelsservice.repositories.CustomerARepository;

import java.util.List;

@Service
public class CustomerAService {
    @Autowired
    CustomerARepository customerRepository;

    public List<CustomerA> getAllCustomerA(){
        return customerRepository.findAll();
    }

    public List<CustomerA> insertCustomers(List<CustomerA> customerAs) {
        return customerRepository.saveAll(customerAs);
    }


}
