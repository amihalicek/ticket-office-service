package hr.abysalto.ticket_office_service.line.converter;

import hr.abysalto.ticket_office_service.line.dto.LineDropdownDto;
import hr.abysalto.ticket_office_service.line.entity.Line;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LineConverter {

    public LineDropdownDto toLineDropdownDto(Line line) {
        LineDropdownDto dto = new LineDropdownDto();
        dto.setId(line.getId());
        dto.setInfo(line.getInfo());
        return dto;
    }
}
