package hr.abysalto.ticket_office_service.ticket.service;

import hr.abysalto.ticket_office_service.common.exception.EntityNotFoundException;
import hr.abysalto.ticket_office_service.ticket.converter.TicketConverter;
import hr.abysalto.ticket_office_service.ticket.dto.TicketListDto;
import hr.abysalto.ticket_office_service.ticket.entity.Ticket;
import hr.abysalto.ticket_office_service.ticket.repository.TicketRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    private TicketConverter ticketConverter;

    public List<TicketListDto> findAllTickets() {
        return ticketRepository.findAll().stream().map(ticketConverter::toTicketListDto).collect(Collectors.toList());
    }

    private Ticket findTicketById(Long id) {
        return ticketRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Ticket with ID " + id + " not found!!"));
    }

}
