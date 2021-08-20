package com.viwit.viwitinterface.application.use_cases.wallet_ms;

import com.viwit.viwitinterface.domain.entities.wallet_ms.Data;
import lombok.Builder;

import java.math.BigInteger;
import java.util.LinkedHashMap;

@Builder(toBuilder = true)
public class DataUseCases {

    public Data convertLinkedHashMapToData(LinkedHashMap<String,String> linkedHashMap){
        LinkedHashMap<String,String> data = ( LinkedHashMap<String,String> )(( Object )linkedHashMap.get("data"));
        return Data.builder()
                .Id(BigInteger.valueOf((Integer) ((Object) data.get("id"))))
                .Id_method_payment(BigInteger.valueOf((Integer) ((Object) data.get("id_method_payment"))))
                .Mount(BigInteger.valueOf((Integer) ((Object) data.get("mount"))))
                .Status(data.get("status"))
                .Type(BigInteger.valueOf((Integer) ((Object) data.get("type"))))
                .Wallet_id(BigInteger.valueOf((Integer) ((Object) data.get("wallet_id"))))
                .Date(data.get("date"))
                .Typename(data.get("__typename"))
                .build();
    }

}
