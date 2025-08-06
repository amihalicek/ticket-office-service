package hr.abysalto.ticket_office_service.common.dto;

public class EntityDeletedDto {
    private String message;

    public EntityDeletedDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
