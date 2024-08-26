package com.bookstoreapi.assembler;

import com.bookstoreapi.controller.CustomerController;
import com.bookstoreapi.dto.CustomerDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerResourceAssembler {

    public EntityModel<CustomerDTO> toModel(CustomerDTO customerDTO) {
        EntityModel<CustomerDTO> customerModel = EntityModel.of(customerDTO);

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class)
                .getCustomerById(customerDTO.getId())).withSelfRel();
        customerModel.add(selfLink);

        Link allCustomersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class)
                .getAllCustomers()).withRel("all-customers");
        customerModel.add(allCustomersLink);

        return customerModel;
    }
}
