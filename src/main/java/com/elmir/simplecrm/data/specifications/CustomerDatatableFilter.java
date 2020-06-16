package com.elmir.simplecrm.data.specifications;

import com.elmir.simplecrm.data.entities.Customer;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class CustomerDatatableFilter implements Specification<Customer> {

    String userQuery;

    public CustomerDatatableFilter(String userQuery) {
        this.userQuery = userQuery;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        ArrayList<Predicate> predicates = new ArrayList<>();

        if (userQuery != null && userQuery != ""){
            predicates.add(criteriaBuilder.like(root.get("firstName"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("lastName"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("city"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("emailAddress"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("phoneNumber"), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(root.get("country"), '%' + userQuery + '%'));
        }

        return (! predicates.isEmpty() ? criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])) : null);
    }
}