package com.myshop.fundamentals.web;

import com.myshop.fundamentals.entity.Application;
import com.myshop.fundamentals.entity.Ticket;
import com.myshop.fundamentals.exceptions.ApplicationNotFoundException;
import com.myshop.fundamentals.services.ApplicationService;
import com.myshop.fundamentals.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tza")
public class TzaRestController {
    private ApplicationService applicationService;
    private TicketService ticketService;

    @Autowired
    public TzaRestController(ApplicationService applicationService, TicketService ticketService){
        this.applicationService = applicationService;
        this.ticketService = ticketService;
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getListApplications(Model model){
        List<Application> applicationList = (List<Application>) applicationService.listApplications();
        return new ResponseEntity<>(applicationList, HttpStatus.OK);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getTickets(){
        List<Ticket> tickets = (List<Ticket>) ticketService.ticketIterations();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Long id){
        try{
           return new ResponseEntity<>(this.applicationService.findApplication(id),HttpStatus.OK);
        }catch (ApplicationNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity(this.ticketService.findTicketById(id),HttpStatus.OK);
        }catch (ApplicationNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }


}
