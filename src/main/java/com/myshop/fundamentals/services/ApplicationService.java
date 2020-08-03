package com.myshop.fundamentals.services;


import com.myshop.fundamentals.entity.Application;
import com.myshop.fundamentals.entity.Ticket;
import com.myshop.fundamentals.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

public interface ApplicationService {
    Iterable<Application> listApplications();
}
