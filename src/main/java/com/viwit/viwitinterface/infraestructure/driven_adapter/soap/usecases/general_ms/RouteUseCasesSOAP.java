package com.viwit.viwitinterface.infraestructure.driven_adapter.soap.usecases.general_ms;

import com.viwit.viwitinterface.domain.entities.general_ms.Route;

import java.math.BigInteger;

public class RouteUseCasesSOAP {

    public com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Route convertRouteToRouteWs(Route route){
        com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Route routeWs =
                new com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Route();

        routeWs.setIdRoute((route.getIdRoute() == null) ? null : BigInteger.valueOf(route.getIdRoute()));
        routeWs.setNameRoute(route.getNameRoute());
        routeWs.setInitialBusStop(route.getInitialBusStop());
        routeWs.setFinalBusStop(route.getFinalBusStop());
        routeWs.setApproximateDuration(route.getApproximateDuration());
        routeWs.setMensaje(route.getMensaje());

        return routeWs;
    }

}
