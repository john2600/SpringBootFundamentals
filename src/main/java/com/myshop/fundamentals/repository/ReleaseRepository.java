package com.myshop.fundamentals.repository;

import com.myshop.fundamentals.entity.Release;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface ReleaseRepository extends CrudRepository<Release, Id> {
}
