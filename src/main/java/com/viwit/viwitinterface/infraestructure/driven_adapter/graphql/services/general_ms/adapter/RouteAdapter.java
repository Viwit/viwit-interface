package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.general_ms.adapter;

import com.viwit.viwitinterface.application.use_cases.general_ms.RouteUseCases;
import com.viwit.viwitinterface.domain.entities.general_ms.Route;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.gateways.general_ms.RouteGateway;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.QueryGraphQL;

import java.util.LinkedHashMap;

public class RouteAdapter implements RouteGateway {

    @Override
    public Route getRouteByIdRoute(String query,String nameQuery) {
        QueryGraphQL queryGraphQL = new QueryGraphQL();
        try{
            return RouteUseCases
                    .builder()
                    .build()
                    .convertLinkedHashMapToRoute(
                            (LinkedHashMap<String, String>) (( Object ) queryGraphQL.sendQueryIndividualResponse(query, nameQuery))
                    );
        }catch (NullPointerException ex){
            return Route.builder()
                    .mensaje("The route with the entered ID does not exist")
                    .build();
        }catch (Exception ex){
            return Route.builder()
                    .mensaje("Error: " + ex)
                    .build();
        }
    }

}
