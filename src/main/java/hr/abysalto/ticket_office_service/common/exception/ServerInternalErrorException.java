package hr.abysalto.ticket_office_service.common.exception;

public class ServerInternalErrorException extends RuntimeException{
    public ServerInternalErrorException(String message) {
        super(message);
    }
}
