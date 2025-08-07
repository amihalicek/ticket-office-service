package hr.abysalto.ticket_office_service.line.entity;

import hr.abysalto.ticket_office_service.city.entity.City;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

import java.math.BigDecimal;

@Entity
public class Line {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false, unique = true)
    @SequenceGenerator(name = "line_seq", sequenceName = "line_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="origin_city_id")
    private City origin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="destination_city_id")
    private City destination;

    @Column(name = "code")
    private String code;

    @Column(name = "price")
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
