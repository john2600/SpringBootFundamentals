package com.myshop.fundamentals.services;


import com.myshop.fundamentals.entity.Ticket;
import com.myshop.fundamentals.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
