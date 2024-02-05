package org.ruzmetov.hotelproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EventUpdateDto {

    private String eventName;

    private String eventDescription;

    private Date date;

    private Date eventTimeBeginning;

    private Date eventTimeEnd;

    private int capacity;

    private String organizedCompanyName;

    private String contactPersonName;

}

