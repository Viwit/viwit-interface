package com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.wallet_ms.adapter;

import com.viwit.viwitinterface.application.use_cases.wallet_ms.DataUseCases;
import com.viwit.viwitinterface.domain.entities.wallet_ms.Data;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.gateways.wallet_ms.WalletGateway;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.MutationGraphQL;

import java.util.LinkedHashMap;

public class WalletAdapter implements WalletGateway {
    @Override
    public Data postCreateTransaction(String mutation, String nameMutation) {
        MutationGraphQL mutationGraphQL = new MutationGraphQL();
        return DataUseCases.builder()
                .build()
                .convertLinkedHashMapToData(
                        (LinkedHashMap<String,String>)((Object) mutationGraphQL.sendMutation(mutation, nameMutation))
                );
    }
}
