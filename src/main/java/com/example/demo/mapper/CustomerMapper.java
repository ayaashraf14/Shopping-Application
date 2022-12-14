package com.example.demo.mapper;


import com.example.demo.models.CustomerModel;
import com.example.demo.repository.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

   public Customer modelToCustomer(CustomerModel customerModel);
}
