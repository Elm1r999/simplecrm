package com.elmir.simplecrm.data.specifications;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.Predicate;

public class CustomerDatatableFilterTest {
    CustomerDatatableFilter customerDatatableFilter = new CustomerDatatableFilter("userQuery");

    @Test
    public void testToPredicate() {
        Predicate result = customerDatatableFilter.toPredicate(null, null, null);
        Assertions.assertEquals(null, result);
    }
}