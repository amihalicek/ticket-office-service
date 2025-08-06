package hr.abysalto.ticket_office_service.line.repository;

import hr.abysalto.ticket_office_service.line.entity.Line;
import hr.abysalto.ticket_office_service.ticket.entity.Ticket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LineRepository extends CrudRepository<Line, Long> {
    Optional<Line> findById(Long id);
}
