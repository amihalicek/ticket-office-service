package hr.abysalto.ticket_office_service.line.service;

import hr.abysalto.ticket_office_service.common.exception.EntityNotFoundException;
import hr.abysalto.ticket_office_service.line.entity.Line;
import hr.abysalto.ticket_office_service.line.repository.LineRepository;

import org.springframework.stereotype.Service;

@Service
public class LineService {

    private LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Line findById(Long id) {
        return lineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Line not found!"));
    }
}
