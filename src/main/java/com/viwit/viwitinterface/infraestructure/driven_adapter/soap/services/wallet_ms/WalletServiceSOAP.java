package com.viwit.viwitinterface.infraestructure.driven_adapter.soap.services.wallet_ms;

import com.viwit.viwitinterface.domain.entities.wallet_ms.Data;
import com.viwit.viwitinterface.infraestructure.driven_adapter.graphql.services.wallet_ms.adapter.WalletAdapter;
import com.viwit.viwitinterface.infraestructure.driven_adapter.soap.data.wallet_ms.TransactionInput;

public class WalletServiceSOAP {

    public Data addBalance(TransactionInput transactionInput){
       String mutation = "mutation{\n" +
               "  postCreateTransaction(transaction:{\n" +
               "    token: \"" + transactionInput.getToken() + "\",\n" +
               "    wallet_id: " + transactionInput.getWallet_id() + ",\n" +
               "    id_method_payment: " + transactionInput.getId_method_payment() + ",\n" +
               "    mount: " + transactionInput.getMount() + ",\n" +
               "    type: " + transactionInput.getType() + "\n" +
               "  }){\n" +
               "    data{\n" +
               "      id,\n" +
               "      id_method_payment,\n" +
               "      mount,\n" +
               "      status,\n" +
               "      type,\n" +
               "      wallet_id,\n" +
               "      date,\n" +
               "      __typename\n" +
               "    }\n" +
               "  }\n" +
               "}", nameMutation = "postCreateTransaction";
       return (new WalletAdapter())
               .postCreateTransaction(mutation,nameMutation);
    }

}
