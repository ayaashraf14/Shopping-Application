//package com.example.demo.service;
//
//import com.example.demo.entity.Customer;
//import com.example.demo.repositories.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomerDetailsService implements UserDetailsService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    public CustomerDetailsService(CustomerRepository customerRepository){
//        super();
//        this.customerRepository = customerRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer = this.customerRepository.findByUserName(username);
//        if(null==customer){
//            throw new UsernameNotFoundException("cannot find username: " + username);
//        }
//        return new CustomerPrincipal(customer);
//    }
//}
