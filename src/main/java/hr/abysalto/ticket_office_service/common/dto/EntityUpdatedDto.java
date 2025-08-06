package hr.abysalto.ticket_office_service.common.dto;

public class EntityUpdatedDto<T> {
    private String message = "Entity updated!";

    private T data;

    public EntityUpdatedDto(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
