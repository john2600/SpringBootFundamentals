package com.myshop.fundamentals.services;


import com.myshop.fundamentals.entity.Ticket;
import com.myshop.fundamentals.exceptions.ApplicationNotFoundException;
import com.myshop.fundamentals.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl  implements TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Iterable<Ticket> ticketIterations() {
        return this.ticketRepository.findAll();
    }

    @Override
    public Ticket findTicketById(Long id) {
        Optional<Ticket> ticket = this.ticketRepository.findById(id);
        if(ticket.isPresent()) {
            return ticket.get();
        } else {
            throw new ApplicationNotFoundException("Ticket not found");
        }
    }
}
