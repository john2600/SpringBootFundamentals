package com.myshop.fundamentals.web;

import com.myshop.fundamentals.entity.Application;
import com.myshop.fundamentals.services.ApplicationService;
import com.myshop.fundamentals.services.ReleaseService;
import com.myshop.fundamentals.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TzaController {
    private ApplicationService applicationService;
    private ReleaseService releaseService;
    private TicketService ticketService;

    @Autowired
    public TzaController(ApplicationService applicationService, ReleaseService releaseService, TicketService ticketService){
        this.applicationService = applicationService;
        this.releaseService = releaseService;
        this.ticketService = ticketService;
    }

    @GetMapping("/applications")
    public String retrieveApplications(Model model){
        model.addAttribute("applications", applicationService.listApplications());
        return "applications";
    }

    @GetMapping("/tickets")
    public String retrieveTickets(Model model){
        model.addAttribute("tickets", ticketService.ticketIterations());
        return "tickets";
    }

    @GetMapping("/releases")
    public String retrieveReleases(Model model){
        model.addAttribute("releases", releaseService.listReleases());
        return "releases";
    }

}
