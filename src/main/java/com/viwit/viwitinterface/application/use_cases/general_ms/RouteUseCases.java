package com.viwit.viwitinterface.application.use_cases.general_ms;

import com.viwit.viwitinterface.domain.entities.general_ms.Route;
import lombok.Builder;

import java.util.LinkedHashMap;

@Builder(toBuilder = true)
public class RouteUseCases {

    public Route convertLinkedHashMapToRoute(LinkedHashMap<String,String> linkedHashMap){
        return Route.builder()
                .IdRoute((Integer) (( Object )linkedHashMap.get("idRoute")))
                .NameRoute(linkedHashMap.get("nameRoute"))
                .InitialBusStop(linkedHashMap.get("initialBusStop"))
                .FinalBusStop(linkedHashMap.get("finalBusStop"))
                .ApproximateDuration(linkedHashMap.get("approximateDuration"))
                .build();
    }

}
