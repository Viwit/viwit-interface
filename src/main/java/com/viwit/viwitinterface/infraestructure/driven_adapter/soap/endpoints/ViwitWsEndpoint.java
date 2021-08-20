package com.viwit.viwitinterface.infraestructure.driven_adapter.soap.endpoints;

import com.viwit.viwitinterface.domain.entities.general_ms.Route;
import com.viwit.viwitinterface.infraestructure.driven_adapter.soap.data.wallet_ms.TransactionInput;
import com.viwit.viwitinterface.infraestructure.driven_adapter.soap.services.general_ms.BusServiceSOAP;
import com.viwit.viwitinterface.infraestructure.driven_adapter.soap.services.general_ms.RouteServiceSOAP;
import com.viwit.viwitinterface.infraestructure.driven_adapter.soap.services.wallet_ms.WalletServiceSOAP;
import com.viwit.viwitinterface.infraestructure.driven_adapter.soap.usecases.wallet_ms.DataUsesCasesSOAP;
import com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.Data;
import com.viwit.viwitinterface.infraestructure.driven_adapter.soap.ws.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Endpoint
public class ViwitWsEndpoint {

    private static final String NAMESPACE = "http://viwit.com/viwitinterface/infraestructure/driven_adapter/soap/ws";

    //Return Bus (Domain)
    @PayloadRoot(namespace = NAMESPACE, localPart = "getBusByLicensePlateRequest")
    @ResponsePayload
    public GetBusByLicensePlateResponse getBusByLicensePlate(
            @RequestPayload GetBusByLicensePlateRequest getBusByLicensePlateRequest
    ) {
        GetBusByLicensePlateResponse getBusByLicensePlateResponseReturn = new GetBusByLicensePlateResponse();
        getBusByLicensePlateResponseReturn
                .setBus(
                        (new BusServiceSOAP())
                                .queryBusByLicensePlate(
                                        getBusByLicensePlateRequest.getLicensePlate()
                                )
                );
        return getBusByLicensePlateResponseReturn;
    }

    //Return route (Domain)
    @PayloadRoot(namespace = NAMESPACE, localPart = "getRouteByIdRouteRequest")
    @ResponsePayload
    public GetRouteByIdRouteResponse getRouteByIdRoute(
            @RequestPayload GetRouteByIdRouteRequest getRouteByIdRouteRequest
    ) {
        GetRouteByIdRouteResponse getRouteByIdRouteResponseReturn = new GetRouteByIdRouteResponse();
        getRouteByIdRouteResponseReturn.setRoute(
                (new RouteServiceSOAP())
                        .getRouteByIdRoute(
                                getRouteByIdRouteRequest
                                        .getIdRoute()
                                        .intValue()
                        )
        );
        return getRouteByIdRouteResponseReturn;
    }

    //Return dataWS
    @PayloadRoot(namespace = NAMESPACE, localPart = "addBalanceRequest")
    @ResponsePayload
    public AddBalanceResponse addBalance(
            @RequestPayload AddBalanceRequest balanceRequest
    ) {
        TransactionInput transactionInput = TransactionInput.builder()
                .token(balanceRequest.getToken())
                .wallet_id(balanceRequest.getWalletId().intValue())
                .id_method_payment(balanceRequest.getIdMethodPayment().intValue())
                .mount(balanceRequest.getMount().intValue())
                .type(balanceRequest.getType().intValue())
                .tokenFirebase(balanceRequest.getTokenFirebase())
                .build();
        AddBalanceResponse addBalanceResponseReturn = new AddBalanceResponse();
        addBalanceResponseReturn.setData(
                (new DataUsesCasesSOAP())
                        .convertDataToDataWs(
                                (new WalletServiceSOAP())
                                        .addBalance(transactionInput)
                        )
        );
        return addBalanceResponseReturn;
    }

}
