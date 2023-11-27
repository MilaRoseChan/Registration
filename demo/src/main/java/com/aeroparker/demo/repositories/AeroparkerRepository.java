package com.aeroparker.demo.repositories;

import com.aeroparker.demo.models.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroparkerRepository extends CrudRepository<Customer, Integer> {
}
