package com.viwit.viwitinterface.domain.entities.general_ms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class RouteStops {

    private Integer Route_IdRoute;
    private Integer BusStop_IdBusStop;
    private Integer positionRouteStops;

}
