package hr.abysalto.ticket_office_service.line.controller;

import hr.abysalto.ticket_office_service.line.dto.LineDropdownDto;
import hr.abysalto.ticket_office_service.line.service.LineService;
import hr.abysalto.ticket_office_service.ticket.dto.TicketListDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lines")
public class LineController {

    private LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @GetMapping
    public ResponseEntity<List<LineDropdownDto>> getTicketsForDropdown() {
        return ResponseEntity.status(200).body(lineService.getAllLinesForDropdown());
    }

}
