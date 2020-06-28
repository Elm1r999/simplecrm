package com.elmir.simplecrm.data.repositories;

import com.elmir.simplecrm.data.entities.Customer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindById_returnCustomer(){
        Customer randomCustomer = new Customer();
        randomCustomer.setId((long) 500); //any number between 1 or 1000

        long id = 500;
        Optional<Customer> optionalEntity =  customerRepository.findById(id);
        Customer customerEntity = optionalEntity.get();

        Assertions.assertEquals(testEntityManager.merge(randomCustomer), customerEntity);
    }

    @Test
    public void failedTest(){
        Customer randomCustomer = new Customer();
        randomCustomer.setId((long) 1001); //No value present

        long id = 1001;
        Optional<Customer> optionalEntity =  customerRepository.findById(id);
        Customer customerEntity = optionalEntity.get();

        Assertions.assertEquals(testEntityManager.merge(randomCustomer), customerEntity);
    }
}