package com.example.RPD.Repository;


import com.example.RPD.Models.CrimeCase;
import org.springframework.data.repository.CrudRepository;

public interface CrimeCaseRepository extends CrudRepository<CrimeCase,Long> {
}
