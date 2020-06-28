package com.elmir.simplecrm.services;

import com.elmir.simplecrm.data.entities.Customer;
import com.elmir.simplecrm.data.repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import static org.mockito.Mockito.*;

public class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomersForDatatable() {
        Page<Customer> result = customerService.getCustomersForDatatable("queryString", null);
        Assertions.assertEquals(null, result);
    }
}