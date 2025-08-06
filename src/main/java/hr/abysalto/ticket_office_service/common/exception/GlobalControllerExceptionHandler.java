package hr.abysalto.ticket_office_service.common.exception;

import hr.abysalto.ticket_office_service.common.dto.GenericErrorResponseDto;

import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {


    @ExceptionHandler({ BadRequestException.class, MultipartException.class })
    public ResponseEntity<GenericErrorResponseDto> handleBadRequestException(Exception ex) {
        return ResponseEntity.badRequest().body(new GenericErrorResponseDto(ex.getMessage()));
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<GenericErrorResponseDto> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(new GenericErrorResponseDto(ex.getMessage()));
    }


    @ExceptionHandler({ AccessForbiddenException.class })
    public ResponseEntity<GenericErrorResponseDto> handleTenantAccessException(AccessForbiddenException ex) {
        return ResponseEntity.status(403).body(new GenericErrorResponseDto(ex.getMessage()));
    }

    @ExceptionHandler({ ServerInternalErrorException.class })
    public ResponseEntity<GenericErrorResponseDto> handleInternalServerException(ServerInternalErrorException ex) {
        return ResponseEntity.status(500).body(new GenericErrorResponseDto(ex.getMessage()));
    }
}
