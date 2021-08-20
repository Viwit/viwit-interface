package com.viwit.viwitinterface.application.use_cases.general_ms;

import com.viwit.viwitinterface.domain.entities.general_ms.Bus;
import lombok.Builder;

import java.math.BigInteger;
import java.util.LinkedHashMap;

@Builder(toBuilder = true)
public class BusUseCases {

    public Bus convertLinkedHashMapToBus(LinkedHashMap<String,String> linkedHashMap){
        return Bus.builder()
                .LicensePlateBus(linkedHashMap.get("licensePlateBus"))
                .Model(linkedHashMap.get("model"))
                .SeatedPassengerCapacity((Integer)((Object)linkedHashMap.get("seatedPassengerCapacity")))
                .StandingPassengerCapacity((Integer)((Object)linkedHashMap.get("standingPassengerCapacity")))
                .debtCollectorIdUser((Integer)((Object)linkedHashMap.get("debtCollectorIdUser")))
                .build();
    }

}
