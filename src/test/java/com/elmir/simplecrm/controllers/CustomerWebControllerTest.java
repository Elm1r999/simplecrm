package com.elmir.simplecrm.controllers;

import com.elmir.simplecrm.data.entities.Customer;
import com.elmir.simplecrm.data.repositories.CustomerRepository;
import com.elmir.simplecrm.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class CustomerWebControllerTest {
    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerWebController customerWebController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIndex() {
        String result = customerWebController.index();
        Assertions.assertEquals("/customer/index.html", result);
    }

    @Test
    public void testGetDataForDatatable() {
        when(customerService.getCustomersForDatatable(anyString(), any())).thenReturn(null);

        String result = customerWebController.getDataForDatatable(new HashMap<String, Object>() {{
            put("String", "params");
        }});
        Assertions.assertEquals(customerRepository.findAll(), result);
    }

    @Test
    public void testEdit() {
        String result = customerWebController.edit("id", null);
        Assertions.assertEquals("/customer/edit.html", result);
    }

    @Test
    public void testUpdate() {
        String result = customerWebController.update(new Customer(), null, null, null);
        Assertions.assertEquals("redirect:/customer/", result);
    }

    @Test
    public void testCreate() {
        String result = customerWebController.create(null);
        Assertions.assertEquals("/customer/create.html", result);
    }

    @Test
    public void testSave() {
        String result = customerWebController.save(new Customer(), null, null, null);
        Assertions.assertEquals("redirect:/customer/", result);
    }

    @Test
    public void testDelete() {
        String result = customerWebController.delete(Long.valueOf(1), null);
        Assertions.assertEquals("redirect:/customer/", result);
    }
}