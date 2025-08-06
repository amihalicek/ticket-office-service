package hr.abysalto.ticket_office_service.common.exception;

public class AccessForbiddenException extends RuntimeException{
    public AccessForbiddenException(String message) {
        super(message);
    }
}
