package com.myshop.fundamentals.services;

import com.myshop.fundamentals.entity.Application;
import com.myshop.fundamentals.exceptions.ApplicationNotFoundException;
import com.myshop.fundamentals.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Application findApplication(long id) {
        Optional<Application> application = this.applicationRepository.findById(id);
        if(application.isPresent()){
            return application.get();
        } else {
            throw new ApplicationNotFoundException("Application Not Found");
        }
    }
}
