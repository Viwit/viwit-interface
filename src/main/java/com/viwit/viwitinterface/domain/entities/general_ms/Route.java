package com.viwit.viwitinterface.domain.entities.general_ms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Route {

    private Integer IdRoute;
    private String NameRoute;
    private String InitialBusStop;
    private String FinalBusStop;
    private String ApproximateDuration;

}
