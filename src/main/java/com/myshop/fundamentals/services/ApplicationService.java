package com.myshop.fundamentals.services;


import com.myshop.fundamentals.entity.Application;

public interface ApplicationService {
    Iterable<Application> listApplications();
    Application findApplication(long id);
}
