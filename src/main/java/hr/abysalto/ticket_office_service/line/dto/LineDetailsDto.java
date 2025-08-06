package hr.abysalto.ticket_office_service.line.dto;

import hr.abysalto.ticket_office_service.city.dto.CityDetailsDto;

import java.math.BigDecimal;

public class LineDetailsDto {

    private Long id;

    private CityDetailsDto originCity;

    private CityDetailsDto destinationCity;

    private String code;

    private BigDecimal price;

}
