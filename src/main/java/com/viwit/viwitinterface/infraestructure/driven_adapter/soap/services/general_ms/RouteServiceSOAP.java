package com.viwit.viwitinterface.infraestructure.driven_adapter.soap.services.general_ms;

import com.viwit.viwitinterface.domain.entities.general_ms.Route;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.general_ms.adapter.RouteAdapter;

public class RouteServiceSOAP {

    public Route getRouteByIdRoute(Integer idRoute){
        String query = "query{\n" +
                "  getRouteByIdRoute(idRoute:" + idRoute + "){\n" +
                "    idRoute,\n" +
                "    nameRoute,\n" +
                "    initialBusStop,\n" +
                "    finalBusStop,\n" +
                "    approximateDuration,\n" +
                "    __typename\n" +
                "  }\n" +
                "}", nameQuery = "getRouteByIdRoute";
        return (new RouteAdapter())
                .getRouteByIdRoute(query,nameQuery);
    }

}
