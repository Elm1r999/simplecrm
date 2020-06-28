package com.elmir.simplecrm.data.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {
    Customer customer = new Customer();

    @Test
    void testToString() {
        String result = customer.toString();
        Assertions.assertEquals("Customer[id=null, firstName='null', lastName='null', emailAddress='null', address='null', city='null', country='null', phoneNumber='null']", result);
    }
}