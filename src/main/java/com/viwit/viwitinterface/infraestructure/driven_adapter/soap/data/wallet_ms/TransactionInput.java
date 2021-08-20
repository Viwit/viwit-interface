package com.viwit.viwitinterface.infraestructure.driven_adapter.soap.data.wallet_ms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class TransactionInput {

    private String token;
    private Integer wallet_id;
    private Integer id_method_payment;
    private Integer mount;
    private Integer type;
    private String tokenFirebase;

}
