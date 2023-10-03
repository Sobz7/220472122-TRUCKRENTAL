package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;

import za.ac.cput.factory.CustomerFactory;

import za.ac.cput.service.CustomerService;
import za.ac.cput.service.impl.CustomerServiceImpl;

import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:3000")
@RestController

@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;


    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        Customer newCustomer = CustomerFactory.createCustomer(customer.getName(), customer.getSurname(), customer.getEmail(), customer.getAddress(), customer.getPassword());
        return customerService.create(newCustomer);
    }

    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id) {
        return customerService.read(id);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        customerService.delete(id);
        return true;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Set<Customer>> getAll() {
        Set<Customer> customers = customerService.getAll();
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.FOUND);
    }
}

//    @GetMapping("/getCustomers")
//    public ResponseEntity<List<Customer>> getCustomers(){
//        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.FOUND);
//    }


//    @GetMapping("/customer/{id}")
//    public Customer getCustomerById(@PathVariable Long id){
//        return customerService.getCustomerById(id);
//    }

