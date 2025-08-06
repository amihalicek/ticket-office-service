package hr.abysalto.ticket_office_service.ticket.converter;

import hr.abysalto.ticket_office_service.line.entity.Line;
import hr.abysalto.ticket_office_service.line.service.LineService;
import hr.abysalto.ticket_office_service.ticket.dto.NewTicketDto;
import hr.abysalto.ticket_office_service.ticket.dto.TicketListDto;
import hr.abysalto.ticket_office_service.ticket.entity.Ticket;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TicketConverter {

    private LineService lineService;

    public TicketConverter(LineService lineService) {
        this.lineService = lineService;
    }

    public TicketListDto toTicketListDto(Ticket ticket) {
        TicketListDto dto = new TicketListDto();
        dto.setId(ticket.getId());
        dto.setLineName(ticket.getLine().getInfo());
        dto.setPassengerName(ticket.getPassengerName());
        dto.setSeatNumber(ticket.getSeatNumber());
        dto.setPricePaid(ticket.getPricePaid());
        dto.setPurchaseTime(ticket.getPurchaseTime());
        return dto;
    }

    public Ticket fromNewTicketDto(NewTicketDto dto) {
        Ticket ticket = new Ticket();
        Line line = lineService.findById(dto.getLineId());
        ticket.setLine(line);
        ticket.setPassengerName(dto.getPassengerName());
        ticket.setPricePaid(line.getPrice());
        ticket.setPurchaseTime(LocalDateTime.now());
        ticket.setSeatNumber(dto.getSeatNumber());
        return ticket;
    }

}
