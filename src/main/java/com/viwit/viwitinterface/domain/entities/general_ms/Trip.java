package com.viwit.viwitinterface.domain.entities.general_ms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
public class Trip {

    private Integer IdTrip;
    private Integer Route_IdRoute;
    private String Bus_LicensePlateBus;
    private String Driver_DriversLicense;
    private Integer BusStop_IdBusStop;
    private Integer CurrentTripOccupation;
    private Date StartDate;
    private String TripStatus;
    private Integer TotalPassengersTrip;

}
