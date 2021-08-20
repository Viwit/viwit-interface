package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.general_ms.adapter;

import com.viwit.viwitinterface.application.use_cases.general_ms.BusUseCases;
import com.viwit.viwitinterface.domain.entities.general_ms.Bus;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.gateways.general_ms.BusGateway;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.QueryGraphQL;

import java.util.LinkedHashMap;

public class BusAdapter implements BusGateway {

    @Override
    public Bus mutationBus(String mutation, String nameMutation) {
        //TODO pendiiente por implementar
        return null;
    }

    @Override
    public Bus queryBusByLicensePlate(String query, String nameQuery) {
        QueryGraphQL queryGraphQL = new QueryGraphQL();
        queryGraphQL.sendQueryIndividualResponse(query, nameQuery);
        return BusUseCases.builder()
                .build()
                .convertLinkedHashMapToBus(
                        (LinkedHashMap<String, String>) queryGraphQL.sendQueryIndividualResponse(query, nameQuery)
                );
    }
}
