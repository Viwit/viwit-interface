package com.viwit.viwitinterface.domain.entities.general_ms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Driver {

    private String DriversLicense;
    private String Name;
    private Integer DriverExperience;
    private String AverageDriverRating;

}
