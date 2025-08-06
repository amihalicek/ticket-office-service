package hr.abysalto.ticket_office_service.line.entity;

import hr.abysalto.ticket_office_service.city.entity.City;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class Line {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private City origin;

    @ManyToOne
    private City destination;

    private String code;

    private BigDecimal price;

    public String getInfo() {
        return getOrigin().getName() + " - " + getDestination().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
