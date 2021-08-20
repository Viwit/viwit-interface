package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.gateways.general_ms;

import com.viwit.viwitinterface.domain.entities.general_ms.Route;

public interface RouteGateway {

    Route getRouteByIdRoute(String query, String nameQuery);

}
