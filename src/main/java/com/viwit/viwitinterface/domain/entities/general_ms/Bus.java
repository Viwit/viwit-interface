package com.viwit.viwitinterface.domain.entities.general_ms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Bus {

    private String LicensePlateBus;
    private String Model;
    private Integer SeatedPassengerCapacity;
    private Integer StandingPassengerCapacity;
    private Integer debtCollectorIdUser;

}
