package hr.abysalto.ticket_office_service.line.service;

import hr.abysalto.ticket_office_service.common.exception.EntityNotFoundException;
import hr.abysalto.ticket_office_service.line.converter.LineConverter;
import hr.abysalto.ticket_office_service.line.dto.LineDropdownDto;
import hr.abysalto.ticket_office_service.line.entity.Line;
import hr.abysalto.ticket_office_service.line.repository.LineRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {

    private LineRepository lineRepository;

    private LineConverter lineConverter;

    public LineService(LineRepository lineRepository, LineConverter lineConverter) {
        this.lineRepository = lineRepository;
        this.lineConverter = lineConverter;
    }

    public List<LineDropdownDto> getAllLinesForDropdown() {
        return this.lineRepository.findAll().stream().map(l -> lineConverter.toLineDropdownDto(l))
            .collect(Collectors.toList());
    }

    public Line findById(Long id) {
        return lineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Line not found!"));
    }
}
