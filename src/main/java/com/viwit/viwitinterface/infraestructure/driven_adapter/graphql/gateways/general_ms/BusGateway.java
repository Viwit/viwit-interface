package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.gateways.general_ms;

import com.viwit.viwitinterface.domain.entities.general_ms.Bus;

public interface BusGateway {

    Bus mutationBus(String mutation, String nameMutation);

    Bus queryBusByLicensePlate(String query, String nameQuery);

}
