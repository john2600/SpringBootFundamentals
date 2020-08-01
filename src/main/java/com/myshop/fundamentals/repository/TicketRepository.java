package com.myshop.fundamentals.repository;

import com.myshop.fundamentals.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import javax.persistence.Id;

public interface TicketRepository extends CrudRepository<Ticket, Id> {
}
