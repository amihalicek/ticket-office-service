package hr.abysalto.ticket_office_service.common.dto;

public class EntityCreatedDto {
    Long id;
    String message = "Entity created.";

    public EntityCreatedDto(Long id) {
        this.id = id;
    }

    public EntityCreatedDto(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
