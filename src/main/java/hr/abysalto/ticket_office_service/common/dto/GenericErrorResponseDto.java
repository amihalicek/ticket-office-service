package hr.abysalto.ticket_office_service.common.dto;

public class GenericErrorResponseDto {
    private String message;

    public GenericErrorResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
