package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.gateways.wallet_ms;

import com.viwit.viwitinterface.domain.entities.wallet_ms.Data;

public interface WalletGateway {

    Data postCreateTransaction(String mutation, String nameMutation);

}
