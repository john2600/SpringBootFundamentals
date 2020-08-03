package com.myshop.fundamentals.services;

import com.myshop.fundamentals.entity.Application;
import com.myshop.fundamentals.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService{
    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Iterable<Application> listApplications() {
        return this.applicationRepository.findAll();
    }
}
