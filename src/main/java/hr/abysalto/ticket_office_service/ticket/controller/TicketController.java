package hr.abysalto.ticket_office_service.ticket.controller;

import hr.abysalto.ticket_office_service.common.dto.EntityCreatedDto;
import hr.abysalto.ticket_office_service.ticket.dto.NewTicketDto;
import hr.abysalto.ticket_office_service.ticket.dto.TicketListDto;
import hr.abysalto.ticket_office_service.ticket.service.TicketService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<TicketListDto>> getTickets() {
        return ResponseEntity.status(200).body(ticketService.findAllTickets());
    }

    @PostMapping
    public ResponseEntity<EntityCreatedDto> createTicket(@RequestBody NewTicketDto dto) {
        return ResponseEntity.status(200).body(ticketService.createTicket(dto));
    }

}
