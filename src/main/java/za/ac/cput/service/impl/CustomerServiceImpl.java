//Domain  Customer class
// Pojo Customer
// Author: Jordy Meye (220072841)
// Date: 10 06 2023
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;

import za.ac.cput.repository.ICustomerRepository;
//import za.ac.cput.repository.impl.CustomerRepository;
import za.ac.cput.service.CustomerService;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService{

    private static CustomerService service = null;
    @Autowired

    private ICustomerRepository repository;




    @Override
    public Customer create(Customer customerId){

        return this.repository.save(customerId);
    }


    @Override
    public Customer read(String customerId) {
        return repository.findById(customerId).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if (this.repository.existsById(customer.getCustomerId()))
            return this.repository.save(customer);
        return  null;
    }

    @Override

    public void delete(String customerId){
        this.repository.deleteById(customerId);

    }

    @Override
    public Set<Customer> getAll(){
        Iterable<Customer> customer = this.repository.findAll();
        Set<Customer> customerSet = new HashSet<>();
        customer.forEach(customerSet::add);
        return customerSet;
    }


}
