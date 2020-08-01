package com.myshop.fundamentals.repository;

import com.myshop.fundamentals.entity.Application;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface ApplicationRepository extends CrudRepository<Application, Id> {
}
