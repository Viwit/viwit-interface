package com.viwit.viwitinterface.infraestructure.driven_adapter.soap.usecases.wallet_ms;

import com.viwit.viwitinterface.domain.entities.wallet_ms.Data;

public class DataUsesCasesSOAP {

    public Data convertDataWsToData(
            com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Data dataWs
    ){
        return Data.builder()
                .Id(dataWs.getId())
                .Id_method_payment(dataWs.getIdMethodPayment())
                .Mount(dataWs.getMount())
                .Wallet_id(dataWs.getWalletId())
                .Date(dataWs.getDate())
                .Status(dataWs.getStatus())
                .Type(dataWs.getType())
                .Typename(dataWs.getTypename())
                .build();
    }

    public com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Data convertDataToDataWs(
            Data data
    ){
        com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Data dataWs
                = new com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Data();

        dataWs.setId(data.getId());
        dataWs.setIdMethodPayment(data.getId_method_payment());
        dataWs.setMount(data.getMount());
        dataWs.setWalletId(data.getWallet_id());
        dataWs.setDate(data.getDate());
        dataWs.setStatus(data.getStatus());
        dataWs.setType(data.getType());
        dataWs.setTypename(data.getTypename());

        return dataWs;
    }

}
