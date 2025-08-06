package hr.abysalto.ticket_office_service.ticket.service;

import hr.abysalto.ticket_office_service.common.dto.EntityCreatedDto;
import hr.abysalto.ticket_office_service.common.exception.EntityNotFoundException;
import hr.abysalto.ticket_office_service.ticket.converter.TicketConverter;
import hr.abysalto.ticket_office_service.ticket.dto.NewTicketDto;
import hr.abysalto.ticket_office_service.ticket.dto.TicketListDto;
import hr.abysalto.ticket_office_service.ticket.entity.Ticket;
import hr.abysalto.ticket_office_service.ticket.repository.TicketRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private Logger logger = LoggerFactory.getLogger(TicketService.class);

    private TicketRepository ticketRepository;

    private TicketConverter ticketConverter;

    public TicketService(TicketRepository ticketRepository, TicketConverter ticketConverter) {
        this.ticketRepository = ticketRepository;
        this.ticketConverter = ticketConverter;
    }

    public List<TicketListDto> findAllTickets() {
        logger.debug("Finding all tickets...");
        return ticketRepository.findAll().stream().map(ticketConverter::toTicketListDto).collect(Collectors.toList());
    }

    public EntityCreatedDto createTicket(NewTicketDto dto) {
        logger.debug("Creating new ticket: " + dto) ;
        Ticket ticket = ticketConverter.fromNewTicketDto(dto);
        ticket = ticketRepository.save(ticket);
        return new EntityCreatedDto(ticket.getId(), "Ticket created!");
    }

    private Ticket findTicketById(Long id) {
        return ticketRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Ticket with ID " + id + " not found!!"));
    }

}
