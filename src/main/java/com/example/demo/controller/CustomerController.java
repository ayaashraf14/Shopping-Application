package com.example.demo.controller;


//import com.example.demo.config.JwtUnil;
import com.example.demo.entity.Customer;
//import com.example.demo.models.AuthenticationModel;
import com.example.demo.entity.Order;
import com.example.demo.models.CustomerModel;
//import com.example.demo.models.JwtResponse;
import com.example.demo.models.GetOrderModel;
//import com.example.demo.service.CustomerDetailsService;
import com.example.demo.models.OrderDetailsModel;
import com.example.demo.service.CustomerInterface;
import com.example.demo.service.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerInterface customerInterface;

    @Autowired
    private OrderInterface orderInterface;

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private CustomerDetailsService myCustomerDetailsService;

//    @Autowired
//    private JwtUnil jwtUnil;

    @PostMapping
    public Customer createCustomer(@RequestBody CustomerModel customerModel){
        return  customerInterface.create(customerModel);
    }

    @PostMapping("/order/{id}")
    public Order createOrder(@RequestBody List<GetOrderModel> getOrderModel, @PathVariable Long id){

       return customerInterface.addOrder(getOrderModel,id);
    }

    @GetMapping("/orders/{id}")
    public List<OrderDetailsModel> getAllOrders(@PathVariable Long id){
        return customerInterface.getAllOrders(id);
    }

//    @PostMapping("/login")
//    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody AuthenticationModel authenticationRequest) throws Exception {
//
//        Authentication authentication =  authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
//
//
//        final UserDetails userDetails = myCustomerDetailsService
//                .loadUserByUsername(authenticationRequest.getUserName());
//
//        final String token = jwtUnil.generateJwtToken(authentication);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
//    private Authentication authenticate(String username, String password) throws Exception {
//        try {
//          return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }

}
