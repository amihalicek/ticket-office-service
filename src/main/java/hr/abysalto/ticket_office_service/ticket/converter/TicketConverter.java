package hr.abysalto.ticket_office_service.ticket.converter;

import hr.abysalto.ticket_office_service.ticket.dto.TicketListDto;
import hr.abysalto.ticket_office_service.ticket.entity.Ticket;

import org.springframework.stereotype.Component;

@Component
public class TicketConverter {

    public TicketListDto toTicketListDto(Ticket ticket) {
        TicketListDto dto = new TicketListDto();
        dto.setId(ticket.getId());
        dto.setLineName(ticket.getLine().getInfo());
        dto.setPassengerName(ticket.getPassengerName());
        dto.setPricePaid(ticket.getPricePaid());
        dto.setPurchaseTime(ticket.getPurchaseTime());
        return dto;
    }

}
