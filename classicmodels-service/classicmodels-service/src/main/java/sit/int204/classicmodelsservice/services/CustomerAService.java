package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.entities.CustomerA;
import sit.int204.classicmodelsservice.repositories.CustomerARepository;

import java.util.List;

@Service
public class CustomerAService {
    @Autowired
    CustomerARepository repository;

    public List<CustomerA> getAllCustomerA(){
        return repository.findAll();
    }

    public List<CustomerA> insertCustomers(List<CustomerA> customerAs) {
        return repository.saveAll(customerAs);
    }

    public void removeCustomer(Long customerId){
        CustomerA customerA = repository.findById(customerId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Customer Id " + customerId + " Does not exist"));
        repository.delete(customerA);
    }


}
