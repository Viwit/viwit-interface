package com.viwit.viwitinterface.infraestructure.driven_adapter.soap.usecases.general_ms;

import com.viwit.viwitinterface.domain.entities.general_ms.Bus;

import java.math.BigInteger;

public class BusUseCasesSOAP {

    public Bus convertBusWsToBus(
            com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Bus busWs
    ){
        return Bus.builder()
                .LicensePlateBus(busWs.getLicensePlateBus())
                .Model(busWs.getModel())
                .SeatedPassengerCapacity(busWs.getSeatedPassengerCapacity().intValue())
                .StandingPassengerCapacity(busWs.getStandingPassengerCapacity().intValue())
                .debtCollectorIdUser(busWs.getDebtCollectorIdUser().intValue())
                .build();
    }

    public com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Bus convertBusToBusWs(
            Bus bus
    ){
        com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Bus busWs =
                new com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Bus();

        busWs.setLicensePlateBus(bus.getLicensePlateBus());
        busWs.setModel(bus.getModel());
        busWs.setSeatedPassengerCapacity(
                (bus.getSeatedPassengerCapacity() == null)
                        ? null : BigInteger.valueOf(bus.getSeatedPassengerCapacity())
        );
        busWs.setStandingPassengerCapacity(
                (bus.getSeatedPassengerCapacity() == null)
                        ? null : BigInteger.valueOf(bus.getSeatedPassengerCapacity())
        );
        busWs.setDebtCollectorIdUser(
                (bus.getDebtCollectorIdUser() == null)
                        ? null : BigInteger.valueOf(bus.getDebtCollectorIdUser())
        );
        busWs.setMensaje(bus.getMensaje());

        return busWs;
    }


}
