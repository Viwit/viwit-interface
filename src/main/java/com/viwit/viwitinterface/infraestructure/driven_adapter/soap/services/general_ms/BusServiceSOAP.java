package com.viwit.viwitinterface.infraestructure.driven_adapter.soap.services.general_ms;

import com.viwit.viwitinterface.domain.entities.general_ms.Bus;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.general_ms.adapter.BusAdapter;

public class BusServiceSOAP {

    public Bus queryBusByLicensePlate(String licensePlate){
        String query = "query{\n" +
                "  getBusByLicensePlate(licensePlate:\"" + licensePlate +"\"){\n" +
                "    licensePlateBus,\n" +
                "    model,\n" +
                "    seatedPassengerCapacity,\n" +
                "    standingPassengerCapacity,\n" +
                "    debtCollectorIdUser\n" +
                "  }\n" +
                "}", nameQuery = "getBusByLicensePlate";
        return (new BusAdapter())
                .queryBusByLicensePlate(query,nameQuery);
    }

}
