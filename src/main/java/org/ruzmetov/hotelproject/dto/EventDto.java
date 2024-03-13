package org.ruzmetov.hotelproject.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EventDto {

    private String eventName;

    private String eventDescription;

    private String location;

    private int capacity;

    private String organizedCompanyName;

    private String contactPersonName;

}
