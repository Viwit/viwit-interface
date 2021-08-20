package com.viwit.viwitinterface.domain.entities.general_ms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class BusStop {

    private Integer IdBusStop;
    private String NameOrAddressBusStop;

}
